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
import android.widget.TextView;
import android.widget.Toast;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.R;

public class MainActivity extends AppCompatActivity {

    private Button crearUsuario;
    private Button verListaUsuarios;

    private TextView tipoPersistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crearUsuario = (Button) findViewById(R.id.crearUsuarioButton);
        verListaUsuarios = (Button) findViewById(R.id.verListaUsuarios);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();

        int tipoPersistencia = preferences.getInt("tipoPersistencia", 0);
        this.tipoPersistencia = (TextView) findViewById(R.id.tipoPersistenciaElegida);

        if (tipoPersistencia == 0) {
            editor.putInt("tipoPersistencia", R.integer.SQLITE);
            editor.apply();
            this.tipoPersistencia.setText(R.string.SQLite_Activado);
        } else {

            if (tipoPersistencia == (R.integer.SQLITE)) {
                this.tipoPersistencia.setText(R.string.SQLite_Activado);
            } else if (tipoPersistencia == (R.integer.SHARED)) {
                this.tipoPersistencia.setText(R.string.Shared_Activado);
            }
        }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();

        switch (item.getItemId()) {
            case R.id.sqlite:
                editor.putInt("tipoPersistencia",R.integer.SQLITE);
                editor.apply();
                toastMessageAndUpdateTypePersistence(R.string.MSG_SUCCESS_CHANGED_PERSISTENCE_SQLITE, R.string.SQLite_Activado);
                break;

            case R.id.shared_preferences:
                editor.putInt("tipoPersistencia", R.integer.SHARED);
                editor.apply();
                toastMessageAndUpdateTypePersistence(R.string.MSG_SUCCESS_CHANGED_PERSISTENCE_SHARED, R.string.Shared_Activado);
                break;
        }

        return true;
    }

    private void toastMessageAndUpdateTypePersistence(int msgSuccessChangedPersistenceSqlite, int sqLite_activado) {
        Toast msgChangedPersistenceSQLite = Toast.makeText(getApplicationContext(), msgSuccessChangedPersistenceSqlite, Toast.LENGTH_SHORT);
        msgChangedPersistenceSQLite.show();
        tipoPersistencia.setText(sqLite_activado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_config, menu);
        return true;
    }


}
