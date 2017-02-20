package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.beans.Usuario;

public class UsuarioDAO {

    private UsuarioSQLHelper sqlHelper;

    public UsuarioDAO(Context context) {
        this.sqlHelper = new UsuarioSQLHelper(context, "DBUsuarios", null, 15);
    }

    public void insert(Usuario usuario) {
        SQLiteDatabase writableDatabase = sqlHelper.getWritableDatabase();
        ContentValues nuevoUsuario = new ContentValues();

        nuevoUsuario.put("nombre", usuario.getNombre());
        nuevoUsuario.put("password", usuario.getPassword());
        nuevoUsuario.put("email",usuario.getEmail());

        writableDatabase.insert("Usuarios", null, nuevoUsuario);
        writableDatabase.close();
    }

    public List<Usuario> selectAll(String from) {
        SQLiteDatabase readableDatabase = sqlHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery("SELECT * FROM " + from, null);
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = new ArrayList<>();

        if(cursor.moveToFirst()){
            do{
                usuario.setId(cursor.getInt(0));
                usuario.setNombre(cursor.getString(1));
                usuario.setPassword(cursor.getString(2));
                usuario.setEmail(cursor.getString(3));
                usuarios.add(usuario);
                usuario = new Usuario();
            } while (cursor.moveToNext());
        }
        cursor.close();
        readableDatabase.close();
        return usuarios;
    }

    public Usuario select(int idUsuario) {
        SQLiteDatabase readableDatabase = sqlHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery("SELECT * FROM Usuarios WHERE _id = " + idUsuario, null);
        Usuario usuario = new Usuario();
        if(cursor.moveToFirst()){
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setPassword(cursor.getString(2));
            usuario.setEmail(cursor.getString(3));
        }
        cursor.close();
        readableDatabase.close();
        return usuario;
    }

    public void delete(Usuario usuarioBorrar) {
        SQLiteDatabase writableDatabase = sqlHelper.getWritableDatabase();
        String[] bindParams = new String[]{String.valueOf(usuarioBorrar.getId())};
        writableDatabase.delete("Usuarios","_id = ?", bindParams);
    }

    public void update(Usuario usuarioActualizar) {
        ContentValues valores = new ContentValues();
        valores.put("nombre",usuarioActualizar.getNombre());
        valores.put("password", usuarioActualizar.getPassword());
        valores.put("email", usuarioActualizar.getEmail());

        String[] bindParams = new String[]{String.valueOf(usuarioActualizar.getId())};
        SQLiteDatabase writableDatabase = sqlHelper.getWritableDatabase();
        writableDatabase.update("Usuarios", valores, "_id = ?", bindParams);
    }
}
