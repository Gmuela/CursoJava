package Model.DAO;

import Beans.Usuario;

public interface UsuarioDAO {
    Usuario getUsuario(String nombre, String password);

    boolean registrarUsuario(Usuario usuario);
}
