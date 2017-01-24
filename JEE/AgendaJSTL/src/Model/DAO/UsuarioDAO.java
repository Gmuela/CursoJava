package Model.DAO;

import Beans.Usuario;

public interface UsuarioDAO {
    Usuario login(String nombre, String password);
}
