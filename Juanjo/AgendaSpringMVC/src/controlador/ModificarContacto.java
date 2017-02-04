package controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Contacto;
import negocio.NegocioContacto;

@Controller
@RequestMapping("/modificarContacto.do")
public class ModificarContacto {

	@Autowired
	NegocioContacto negocioContacto;

	@RequestMapping(method = RequestMethod.POST)
	public String modContactos(Contacto contacto, HttpSession session, Model modelo) {

		negocioContacto.modificarContacto(contacto);

		return "contactos";
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String recuperarContacto(HttpSession session, @RequestParam(value = "idContacto") String id) {

		Contacto contacto = negocioContacto.recuperContacto(Integer.parseInt(id));
		session.setAttribute("contactoModificar", contacto);

		return "modificarContacto";
	}
}
