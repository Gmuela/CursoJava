package Controllers;

import Beans.Contacto;
import Beans.Usuario;
import Business.ContactoBusiness;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ActionContactos extends ActionSupport implements ModelDriven<Contacto> {

    private Contacto contacto = new Contacto();
    private ContactoBusiness contactoBusiness = new ContactoBusiness();

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String button = request.getParameter("button");
        String id = request.getParameter("idContacto");

        if (button.equalsIgnoreCase("remove")) {
            contactoBusiness.removeContacto(id);
            return SUCCESS;

        } else if (button.equalsIgnoreCase("update")) {
            Contacto contacto = contactoBusiness.getContactoWithId(id);
            session.setAttribute("contactoModificar", contacto);
            return "modificar";

        } else if (button.equalsIgnoreCase("add")) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            contacto.setUsuario(usuario);
            contactoBusiness.createContacto(this.contacto);
            return SUCCESS;

        } else if (button.equalsIgnoreCase("filter")) {
            session.removeAttribute("mes");
            session.setAttribute("mes", request.getParameter("mes"));
            return SUCCESS;
        }
        return ERROR;
    }

    @Override
    public Contacto getModel() {
        return contacto;
    }
}
