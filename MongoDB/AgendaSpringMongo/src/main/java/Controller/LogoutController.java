package Controller;

import Business.ContactoBusiness;
import Business.UsuarioBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "logout.do")
public class LogoutController implements ParentController {

    @Autowired
    private UsuarioBusiness usuarioBusiness;

    @Autowired
    private ContactoBusiness contactoBusiness;

    @RequestMapping(method = RequestMethod.GET)
    protected String logout(HttpSession session){

        session.invalidate();
        return LOGIN;
    }

}
