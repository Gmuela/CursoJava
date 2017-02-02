package Controller;

import Beans.Contacto;
import Beans.Usuario;
import Business.ContactoBusiness;
import Business.UsuarioBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "login.do")
public class LoginController implements ParentController {

    @Autowired
    private UsuarioBusiness usuarioBusiness;

    @Autowired
    private ContactoBusiness contactoBusiness;

    @RequestMapping(method = RequestMethod.POST)
    protected String login(@RequestParam(value = "nombre") String nombre, @RequestParam(value = "password") String password, HttpSession session){

        Usuario usuario = usuarioBusiness.login(nombre, password);

        if(usuario != null){
            session.setAttribute("usuario", usuario);
            session.setAttribute("mes", "00");
            List<Contacto> contactos = contactoBusiness.getContactosOf(usuario);
            session.setAttribute("listaContactos", contactos);

            return LISTA_CONTACTOS;
        } else{
            return LOGIN;
        }
    }

}
