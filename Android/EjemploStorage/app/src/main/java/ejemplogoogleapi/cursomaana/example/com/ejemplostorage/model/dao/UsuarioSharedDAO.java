package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.beans.Usuario;

public class UsuarioSharedDAO implements UsuarioDAO {

    private Context context;

    public UsuarioSharedDAO(Context context) {
        this.context = context;
    }

    @Override
    public void insert(Usuario usuario) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();

        int idUsuario = preferences.getInt("idUsuario", 0);
        idUsuario++;
        editor.putInt("idUsuario", idUsuario);
        usuario.setId(idUsuario);

        Gson gson = new Gson();
        String usuarioJSON = gson.toJson(usuario);
        editor.putString(String.valueOf("usuario" + usuario.getId()), usuarioJSON);
        editor.apply();
    }

    @Override
    public List<Usuario> selectAll() {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        List<Usuario> usuarios = new ArrayList<Usuario>();
        Map<String, ?> prefs = preferences.getAll();

        for (String key : prefs.keySet()) {
            Object pref = prefs.get(key);
            if (pref instanceof String) {
                Gson gson = new Gson();
                String usuarioJSON = (String)pref;
                Usuario usuario = gson.fromJson(usuarioJSON, Usuario.class);
                usuarios.add(usuario);
            }
        }

        return usuarios;
    }

    @Override
    public Usuario select(int idUsuario) {

        Usuario usuario = null;

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Map<String, ?> prefs = preferences.getAll();

        for (String key : prefs.keySet()) {
            Object pref = prefs.get(key);
            if (pref instanceof String && key.equals("usuario" + idUsuario)) {
                Gson gson = new Gson();
                String usuarioJSON = (String) pref;
                usuario = gson.fromJson(usuarioJSON, Usuario.class);
            }
        }

        return usuario;
    }

    @Override
    public void delete(Usuario usuarioBorrar) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("usuario" + usuarioBorrar.getId());
        editor.apply();
    }

    @Override
    public void update(Usuario usuarioActualizar) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String usuarioJSON = gson.toJson(usuarioActualizar);
        editor.putString("usuario" + usuarioActualizar.getId(), usuarioJSON);
        editor.apply();
    }
}
