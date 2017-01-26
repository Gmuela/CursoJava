package Controllers;

import Beans.Usuario;
import Business.UsuarioBusiness;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionRegistro extends ActionSupport implements ModelDriven<Usuario> {

    private Usuario usuario = new Usuario();
    private UsuarioBusiness usuarioBusiness = new UsuarioBusiness();

    @Override
    public String execute() throws Exception {
        String result = ERROR;
        boolean inserted = usuarioBusiness.registrarUsuario(usuario);
        if(inserted){
            result = SUCCESS;
        }
        return result;
    }

    @Override
    public Usuario getModel() {
        return usuario;
    }
}
