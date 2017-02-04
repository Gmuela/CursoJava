package controlador;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout.do")
public class ControladorLogout {
	@RequestMapping(method = RequestMethod.GET)
	public String logout(HttpSession sesion) {
		sesion.invalidate();
		return "index";
	}

}