package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Map;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.R;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.beans.Usuario;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.dao.UsuarioSQLiteDAO;

public class CrearUsuarioActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText password;
    private EditText email;

    private Button guardar;

    private int idUsuario;
    private int tipoPersistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);

        final UsuarioSQLiteDAO usuarioSQLiteDAO = new UsuarioSQLiteDAO(this);

        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = preferences.edit();

        Map<String, ?> allEntries = preferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
        }

        idUsuario = preferences.getInt("idUsuario", 0);

        nombre = (EditText) findViewById(R.id.nombre);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);

        guardar = (Button) findViewById(R.id.guardarButton);

        tipoPersistencia = preferences.getInt("tipoPersistencia", 0);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipoPersistencia == R.integer.SQLITE) {

                    saveWithSQLite(usuarioSQLiteDAO);

                } else if(tipoPersistencia == R.integer.SHARED){
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
        editor.putString(String.valueOf("usuario"+usuario.getId()), usuarioJSON);
        editor.apply();

        toastMessageAndBackToList();
    }

    private void saveWithSQLite(UsuarioSQLiteDAO usuarioSQLiteDAO) {
        String nombreUsuario = String.valueOf(nombre.getText());
        String passwordUsuario = String.valueOf(password.getText());
        String emailUsuario = String.valueOf(email.getText());

        Usuario usuario = new Usuario(nombreUsuario, passwordUsuario, emailUsuario);

        usuarioSQLiteDAO.insert(usuario);

        toastMessageAndBackToList();
    }

    private void toastMessageAndBackToList() {
        Toast msg = Toast.makeText(getApplicationContext(), R.string.MSG_SUCCESS_CREATED_USER, Toast.LENGTH_SHORT);
        msg.show();

        Intent nextIntent = new Intent(CrearUsuarioActivity.this, ListaUsuariosActivity.class);
        startActivity(nextIntent);
        finish();
    }
}
