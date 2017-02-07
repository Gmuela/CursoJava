package Business;

import Beans.Usuario;
import Model.DAO.JPA.BasicDAOJPA;
import Model.DAO.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioBusiness {


    @Autowired
    @Qualifier("UsuarioDAOJPA")
    private UsuarioDAO usuarioDAO;

    @Autowired
    @Qualifier("UsuarioDAOJPA")
    private BasicDAOJPA<Usuario> basicDAOJPA;

    @Transactional
    public boolean registrarUsuario(Usuario usuario) {
        basicDAOJPA.insert(usuario);
        return true;
    }

    @Transactional
    public Usuario login(String nombre, String password){
        return usuarioDAO.login(nombre,password);
    }
}
