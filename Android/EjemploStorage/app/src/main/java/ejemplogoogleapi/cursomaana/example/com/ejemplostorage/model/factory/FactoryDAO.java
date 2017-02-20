package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.factory;

import android.content.Context;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.R;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.dao.UsuarioDAO;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.dao.UsuarioSQLiteDAO;
import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.dao.UsuarioSharedDAO;

public class FactoryDAO {

    private static UsuarioDAO usuarioDAO;

    public static UsuarioDAO getDAO(Context context, int typePersistence){
        if(typePersistence == R.integer.SQLITE){
            usuarioDAO = new UsuarioSQLiteDAO(context);
        } else if(typePersistence == R.integer.SHARED){
            usuarioDAO = new UsuarioSharedDAO(context);
        }
        return usuarioDAO;
    }
}
