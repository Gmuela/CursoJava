package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.R;

public class MainActivity extends AppCompatActivity {

    private Button crearUsuario;
    private Button verListaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crearUsuario = (Button) findViewById(R.id.crearUsuarioButton);
        verListaUsuarios = (Button) findViewById(R.id.verListaUsuarios);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("tipoPersistencia", "sqlite");
        editor.apply();

        crearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(MainActivity.this, CrearUsuarioActivity.class);
                startActivity(nextIntent);
            }
        });

        verListaUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(MainActivity.this, ListaUsuariosActivity.class);
                startActivity(nextIntent);
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();

        switch (item.getItemId()) {
            case R.id.shared_preferences:
                editor.putString("tipoPersistencia", "shared");
                editor.apply();
                Toast msgChangedPersistenceShared = Toast.makeText(getApplicationContext(), R.string.MSG_SUCCESS_CHANGED_PERSISTENCE_SHARED, Toast.LENGTH_SHORT);
                msgChangedPersistenceShared.show();
                break;

            case R.id.sqlite:
                editor.putString("tipoPersistencia", "sqlite");
                editor.apply();
                Toast msgChangedPersistenceSQLite = Toast.makeText(getApplicationContext(), R.string.MSG_SUCCESS_CHANGED_PERSISTENCE_SQLITE, Toast.LENGTH_SHORT);
                msgChangedPersistenceSQLite.show();
                break;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_config, menu);
        return true;
    }


}
