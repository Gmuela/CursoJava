package Controllers;

import Beans.Usuario;
import Business.UsuarioBusiness;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ActionLogin extends ActionSupport implements ModelDriven<Usuario> {

    private Usuario usuario = new Usuario();
    private UsuarioBusiness usuarioBusiness = new UsuarioBusiness();

    @Override
    public String execute() throws Exception {
        String result = ERROR;
        Usuario usuarioLogado = usuarioBusiness.login(usuario);
        if(usuarioLogado != null){
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarioLogado);
            result = SUCCESS;
        }
        return result;
    }

    @Override
    public Usuario getModel() {
        return usuario;
    }
}
