package Business;

import Beans.Usuario;
import Model.DAO.BasicDAO;
import Model.DAO.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioBusiness {


    @Autowired
    @Qualifier("UsuarioDAOMongo")
    private UsuarioDAO usuarioDAO;

    @Autowired
    @Qualifier("UsuarioDAOMongo")
    private BasicDAO<Usuario> basicDAO;

    @Transactional
    public boolean registrarUsuario(Usuario usuario) {
        basicDAO.insert(usuario);
        return true;
    }

    @Transactional
    public Usuario login(String nombre, String password){
        return usuarioDAO.login(nombre,password);
    }
}
