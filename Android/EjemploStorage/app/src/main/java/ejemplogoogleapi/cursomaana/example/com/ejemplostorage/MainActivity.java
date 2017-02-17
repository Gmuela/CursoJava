package ejemplogoogleapi.cursomaana.example.com.ejemplostorage;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText password;
    private EditText email;

    private Button guardar;
    private Button actualizar;
    private Button verDatos;
    private Button borrar;

    private int idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsuarioSQLHelper sqlHelper = new UsuarioSQLHelper(getApplicationContext(), "DBUsuarios", null, 1);
        final SQLiteDatabase database = sqlHelper.getWritableDatabase();

        nombre = (EditText) findViewById(R.id.nombre);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);

        guardar = (Button) findViewById(R.id.guardarButton);
        actualizar = (Button) findViewById(R.id.actualizarButton);
        verDatos = (Button) findViewById(R.id.verButton);
        borrar = (Button) findViewById(R.id.borrarButton);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = String.valueOf(nombre.getText());
                String passwordUsuario = String.valueOf(password.getText());
                String emailUsuario = String.valueOf(email.getText());
                database.execSQL("INSERT INTO Usuarios (nombre,email,password) " + "VALUES ('" + nombreUsuario + "','" + emailUsuario + "','" + passwordUsuario + "')");
                database.close();
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        verDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(MainActivity.this, VerDatos.class);
                startActivity(nextIntent);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
