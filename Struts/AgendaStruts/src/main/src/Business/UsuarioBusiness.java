package Business;

import Beans.Usuario;
import Model.DAO.BasicDAO;
import Model.DAO.UsuarioDAO;
import Model.Factories.FactoryDAO;

public class UsuarioBusiness {

    private UsuarioDAO usuarioDAO;
    private BasicDAO<Usuario> basicDAO;

    public UsuarioBusiness() {
        this.usuarioDAO = FactoryDAO.getUsuarioDAO();
        this.basicDAO = FactoryDAO.getBasiDAOUsuario();
    }

    public boolean registrarUsuario(Usuario usuario) {
        basicDAO.insert(usuario);
        return true;
    }

    public Usuario login(Usuario usuario){
        return usuarioDAO.login(usuario.getNombre(),usuario.getPassword());
    }
}
