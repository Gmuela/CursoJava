package Controller;

import Beans.Contacto;
import Beans.Usuario;
import Business.ContactoBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ContactosController implements ParentController {

    @Autowired
    private ContactoBusiness contactoBusiness;

    @RequestMapping(value = "crearContacto.do", method = RequestMethod.POST)
    public String crearContacto(HttpSession session, Contacto contacto) {
        contacto.setUsuarios(new ArrayList<>());
        contacto.addUsuario((Usuario) session.getAttribute("usuario"));
        contactoBusiness.createContacto(contacto);
        modificarListaContactos(session);
        return LISTA_CONTACTOS;
    }

    @RequestMapping(value = "borrarContacto.do", method = RequestMethod.POST)
    public String borrarContacto(HttpSession session, @RequestParam(value = "idContacto") String idContacto){
        contactoBusiness.removeContacto(idContacto);
        modificarListaContactos(session);
        return LISTA_CONTACTOS;
    }

    @RequestMapping(value = "redirectToUpdateForm.do", method = RequestMethod.POST)
    public String redirectToUpdateForm(HttpSession session, @RequestParam(value = "idContacto") String id){
        Contacto contacto = contactoBusiness.getContactoWithId(id);
        session.setAttribute("contactoModificar", contacto);
        return MODIFICAR_CONTACTO;
    }

    @RequestMapping(value = "updateContacto.do", method = RequestMethod.POST)
    public String updateContacto(HttpSession session, @SessionAttribute("contactoModificar") Contacto contacto, Contacto nuevosDatos){
        contacto.setNombre(nuevosDatos.getNombre());
        contacto.setApellidos(nuevosDatos.getApellidos());
        contacto.setDni(nuevosDatos.getDni());
        contacto.setFechaNacimiento(nuevosDatos.getFechaNacimiento());
        contacto.setTelefono(nuevosDatos.getTelefono());
        contactoBusiness.modifyContacto(contacto);
        modificarListaContactos(session);
        return LISTA_CONTACTOS;
    }

    @RequestMapping(value = "filterFecha.do", method = RequestMethod.POST)
    public String filterFecha(HttpSession session, @RequestParam(value = "mes") String mes){
        session.removeAttribute("mes");
        session.setAttribute("mes", mes);
        modificarListaContactos(session);
        return LISTA_CONTACTOS;
    }

    private void modificarListaContactos(HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        ArrayList<Contacto> contactos;
        if (session.getAttribute("mes").equals("00")) {
            contactos = contactoBusiness.getContactosOf(usuario);

        } else {
            contactos = contactoBusiness.getContactosWithMonth(usuario, (String) session.getAttribute("mes"));
        }

        session.setAttribute("listaContactos", contactos);
    }
}
