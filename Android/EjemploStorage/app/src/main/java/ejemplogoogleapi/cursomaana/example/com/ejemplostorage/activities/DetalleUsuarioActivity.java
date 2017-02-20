package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.R;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.beans.Usuario;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.dao.UsuarioDAO;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.factory.FactoryDAO;

public class DetalleUsuarioActivity extends AppCompatActivity {

    private TextView nombreDetalle;
    private TextView passwordDetalle;
    private TextView emailDetalle;
    private int idUsuarioDetalle;

    private Button actualizar;
    private Button borrar;

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        final UsuarioDAO usuarioDAO = FactoryDAO.getDAO(getApplicationContext(), preferences.getInt("tipoPersistencia", 0));

        Intent lastIntent = getIntent();
        idUsuarioDetalle = lastIntent.getIntExtra("idUsuarioClickado", 0);

        usuario = usuarioDAO.select(idUsuarioDetalle);

        nombreDetalle = (TextView) findViewById(R.id.nombre_detalle);
        passwordDetalle = (TextView) findViewById(R.id.password_detalle);
        emailDetalle = (TextView) findViewById(R.id.email_detalle);
        idUsuarioDetalle = usuario.getId();

        nombreDetalle.setText(usuario.getNombre());
        passwordDetalle.setText(usuario.getPassword());
        emailDetalle.setText(usuario.getEmail());

        actualizar = (Button) findViewById(R.id.actualizarButton);
        borrar = (Button) findViewById(R.id.borrarButton);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(DetalleUsuarioActivity.this, ActualizarUsuarioActivity.class);
                nextIntent.putExtra("idUsuarioActualizar", idUsuarioDetalle);
                startActivity(nextIntent);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            usuarioDAO.delete(usuario);
            toastMessageAndBackToList();
            }
        });
    }

    private void toastMessageAndBackToList() {
        Intent backToList = new Intent(DetalleUsuarioActivity.this, ListaUsuariosActivity.class);
        Toast msgDeleted = Toast.makeText(getApplicationContext(), R.string.MSG_SUCCESS_DELETED_USER, Toast.LENGTH_SHORT);
        msgDeleted.show();
        startActivity(backToList);
        finish();
    }
}
