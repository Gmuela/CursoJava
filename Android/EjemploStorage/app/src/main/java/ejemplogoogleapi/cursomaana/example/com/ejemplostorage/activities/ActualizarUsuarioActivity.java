package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.R;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.beans.Usuario;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.UsuarioDAO;

public class ActualizarUsuarioActivity extends AppCompatActivity {


    private EditText nombre;
    private EditText password;
    private EditText email;

    private Button actualizar;
    private Usuario usuarioActualizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_usuario);

        final UsuarioDAO usuarioDAO = new UsuarioDAO(this);

        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = preferences.edit();

        Intent lastIntent = getIntent();
        int idUsuarioActualizar = lastIntent.getIntExtra("idUsuarioActualizar", 0);

        usuarioActualizar = usuarioDAO.select(idUsuarioActualizar);

        nombre = (EditText) findViewById(R.id.nombre_actualizar);
        password = (EditText) findViewById(R.id.password_actualizar);
        email = (EditText) findViewById(R.id.email_actulizar);

        actualizar = (Button) findViewById(R.id.actualizarButtonFormulario);

        nombre.setText(usuarioActualizar.getNombre());
        password.setText(usuarioActualizar.getPassword());
        email.setText(usuarioActualizar.getEmail());

        String tipoPersistencia = preferences.getString("tipoPersistencia", "sqlite");

        if (tipoPersistencia.equals("sqlite")) {
            actualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usuarioActualizar.setNombre(String.valueOf(nombre.getText()));
                    usuarioActualizar.setPassword(String.valueOf(password.getText()));
                    usuarioActualizar.setEmail(String.valueOf(email.getText()));

                    usuarioDAO.update(usuarioActualizar);

                    Toast msg = Toast.makeText(getApplicationContext(), R.string.MSG_SUCCESS_UPDATED_USER, Toast.LENGTH_SHORT);
                    msg.show();

                    Intent nextIntent = new Intent(ActualizarUsuarioActivity.this, ListaUsuariosActivity.class);
                    startActivity(nextIntent);
                    finish();

                }
            });
        }

        if (tipoPersistencia.equals("shared")) {
            actualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Usuario usuario = new Usuario("Hola Actualización", "123456", "gmuela92@gmail.com");
                    Gson gson = new Gson();
                    String usuarioJSON = gson.toJson(usuario);
                    editor.putString("usuario0", usuarioJSON);
                    editor.commit();
                }
            });
        }
    }
}
