package Model.DAO;

import Beans.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO {
    Usuario login(String nombre, String password);
}
