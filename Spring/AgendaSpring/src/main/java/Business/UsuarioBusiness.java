package Business;

import Beans.Usuario;
import Model.DAO.BasicDAO;
import Model.DAO.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UsuarioBusiness {


    @Autowired
    @Qualifier("UsuarioDAOJPA")
    private UsuarioDAO usuarioDAO;

    @Autowired
    @Qualifier("UsuarioDAOJPA")
    private BasicDAO<Usuario> basicDAO;

    public boolean registrarUsuario(Usuario usuario) {
        basicDAO.insert(usuario);
        return true;
    }

    public Usuario login(String nombre, String password){
        return usuarioDAO.login(nombre,password);
    }
}
