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

public class CrearUsuarioActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText password;
    private EditText email;

    private Button guardar;

    private int idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);

        final UsuarioDAO usuarioDAO = new UsuarioDAO(this);

        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = preferences.edit();

        idUsuario = preferences.getInt("idUsuario", 0);

        nombre = (EditText) findViewById(R.id.nombre);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);

        guardar = (Button) findViewById(R.id.guardarButton);

        final String tipoPersistencia = preferences.getString("tipoPreferencia", "sqlite");

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipoPersistencia.equals("sqlite")) {

                    saveWithSQLite(usuarioDAO);

                } else if(tipoPersistencia.equals("shared")){
                    saveWithShared(editor);
                }
            }
        });
    }

    private void saveWithShared(SharedPreferences.Editor editor) {
        String nombreUsuario = String.valueOf(nombre.getText());
        String passwordUsuario = String.valueOf(password.getText());
        String emailUsuario = String.valueOf(email.getText());

        Usuario usuario = new Usuario(nombreUsuario,passwordUsuario,emailUsuario);
        usuario.setId(idUsuario);
        idUsuario++;
        editor.putInt("idUsuario", idUsuario);
        Gson gson = new Gson();
        String usuarioJSON = gson.toJson(usuario);
        editor.putString(String.valueOf(usuario.getId()), usuarioJSON);
        editor.apply();
    }

    private void saveWithSQLite(UsuarioDAO usuarioDAO) {
        String nombreUsuario = String.valueOf(nombre.getText());
        String passwordUsuario = String.valueOf(password.getText());
        String emailUsuario = String.valueOf(email.getText());

        Usuario usuario = new Usuario(nombreUsuario, passwordUsuario, emailUsuario);

        usuarioDAO.insert(usuario);

        Toast msg = Toast.makeText(getApplicationContext(), R.string.MSG_SUCCESS_CREATED_USER, Toast.LENGTH_SHORT);
        msg.show();

        Intent nextIntent = new Intent(CrearUsuarioActivity.this, ListaUsuariosActivity.class);
        startActivity(nextIntent);
        finish();
    }
}
