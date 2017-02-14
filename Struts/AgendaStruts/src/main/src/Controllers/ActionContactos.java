package Controllers;

import Beans.Contacto;
import Beans.Usuario;
import Business.ContactoBusiness;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ActionContactos extends ActionSupport implements ModelDriven<Contacto> {

    private Contacto contacto = new Contacto();
    private ContactoBusiness contactoBusiness = new ContactoBusiness();

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String button = request.getParameter("button");
        String id = request.getParameter("id");
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (button.equalsIgnoreCase("remove")) {
            contactoBusiness.removeContacto(id);
            updateSession(session, usuario);

            return SUCCESS;

        } else if (button.equalsIgnoreCase("update")) {
            Integer idInteger = Integer.valueOf(id);
            Contacto contactoModificar = contactoBusiness.getContactoWithId(idInteger);
            session.setAttribute("contactoModificar", contactoModificar);
            updateSession(session, usuario);

            return "modificar";

        } else if (button.equalsIgnoreCase("add")) {
            contacto.setUsuario(usuario);
            contactoBusiness.createContacto(this.contacto);
            updateSession(session, usuario);

            return SUCCESS;

        } else if (button.equalsIgnoreCase("filter")) {
            session.removeAttribute("mes");
            session.setAttribute("mes", request.getParameter("mes"));
            updateSession(session, usuario);

            return SUCCESS;
        }
        return ERROR;
    }

    private void updateSession(HttpSession session, Usuario usuario) {
        ArrayList<Contacto> contactos;
        if (session.getAttribute("mes").equals("00")) {
            contactos = contactoBusiness.getContactosOf(usuario);

        } else {
            contactos = contactoBusiness.getContactosWithMonth(usuario, (String) session.getAttribute("mes"));
        }

        session.setAttribute("listaContactos", contactos);
    }

    @Override
    public Contacto getModel() {
        return contacto;
    }
}
