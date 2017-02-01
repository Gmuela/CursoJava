package Controller;

import Beans.Usuario;
import Business.UsuarioBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "registro.do")
public class RegistroController implements ParentController {

    @Autowired
    private UsuarioBusiness usuarioBusiness;

    @RequestMapping(method = RequestMethod.POST)
    public String registrarUsuario(Usuario usuario){
        usuarioBusiness.registrarUsuario(usuario);
        return LOGIN;
    }

}
