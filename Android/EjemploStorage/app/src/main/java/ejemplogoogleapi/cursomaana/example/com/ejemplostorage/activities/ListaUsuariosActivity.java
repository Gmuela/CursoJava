package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.R;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.adaptadores.AdaptadorUsuario;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.beans.Usuario;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.UsuarioDAO;

public class ListaUsuariosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);

        UsuarioDAO usuarioDAO = new UsuarioDAO(this);

        List<Usuario> usuarios = usuarioDAO.selectAll("Usuarios");

        AdaptadorUsuario adaptadorUsuario = new AdaptadorUsuario(this, usuarios);
        ListView listaUsuarios = (ListView) findViewById(R.id.lista_usuarios);
        listaUsuarios.setAdapter(adaptadorUsuario);

        listaUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario usuarioClickado = (Usuario) parent.getItemAtPosition(position);
                Intent nextIntent = new Intent(ListaUsuariosActivity.this, DetalleUsuarioActivity.class);
                nextIntent.putExtra("idUsuario", usuarioClickado.getId());
                startActivity(nextIntent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_ver_datos);

        UsuarioDAO usuarioDAO = new UsuarioDAO(this);

        List<Usuario> usuarios = usuarioDAO.selectAll("Usuarios");

        AdaptadorUsuario adaptadorUsuario = new AdaptadorUsuario(this, usuarios);
        ListView listaUsuarios = (ListView) findViewById(R.id.lista_usuarios);
        listaUsuarios.setAdapter(adaptadorUsuario);

        listaUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario usuarioClickado = (Usuario) parent.getItemAtPosition(position);
                Intent nextIntent = new Intent(ListaUsuariosActivity.this, DetalleUsuarioActivity.class);
                nextIntent.putExtra("idUsuario", usuarioClickado.getId());
                startActivity(nextIntent);
            }
        });
    }
}
