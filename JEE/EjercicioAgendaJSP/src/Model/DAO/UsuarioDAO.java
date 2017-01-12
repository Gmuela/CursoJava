package Model.DAO;

import AgendaClasses.Usuario;

public interface UsuarioDAO {
    Usuario getUsuario(String nombre, String password);

    boolean registrarUsuario(Usuario usuario);
}
