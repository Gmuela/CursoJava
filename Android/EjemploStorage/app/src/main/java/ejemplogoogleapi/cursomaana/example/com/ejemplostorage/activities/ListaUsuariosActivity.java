package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.R;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.adaptadores.AdaptadorUsuario;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.beans.Usuario;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.factory.FactoryDAO;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.dao.UsuarioDAO;

public class ListaUsuariosActivity extends AppCompatActivity {

    private List<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        UsuarioDAO usuarioDAO = FactoryDAO.getDAO(getApplicationContext(), preferences.getInt("tipoPersistencia", 0));

        usuarios = usuarioDAO.selectAll();

        AdaptadorUsuario adaptadorUsuario = new AdaptadorUsuario(this, usuarios);
        ListView listaUsuarios = (ListView) findViewById(R.id.lista_usuarios);
        listaUsuarios.setAdapter(adaptadorUsuario);

        listaUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario usuarioClickado = (Usuario) parent.getItemAtPosition(position);
                Intent nextIntent = new Intent(ListaUsuariosActivity.this, DetalleUsuarioActivity.class);
                nextIntent.putExtra("idUsuarioClickado", usuarioClickado.getId());
                startActivity(nextIntent);
            }
        });
    }
}
