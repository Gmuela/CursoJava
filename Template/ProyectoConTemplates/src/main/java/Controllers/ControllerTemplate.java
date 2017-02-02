package Controllers;

import Beans.BeanTemplate;
import Model.Business.BusinessTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping(value="nombreAccionGeneral.do")
public class ControllerTemplate {
    @Autowired
    private BusinessTemplate businessTemplate;

    @RequestMapping(value = "nombreAccion.do", method = RequestMethod.POST/*||GET*/)
    public String unaAccionCualquiera(HttpSession session,
                                      @RequestParam(value = "nombreParam") String nombreParam,
                                      @SessionAttribute(value = "nombreAtribSesion") Object objeto,
                                      BeanTemplate beanTemplate){

        businessTemplate.unMetodoCualquiera();
        return "nombreVista";
    }
}
