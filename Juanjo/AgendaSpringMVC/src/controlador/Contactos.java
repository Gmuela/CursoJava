package controlador;

import java.util.ArrayList;

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
@RequestMapping("/Contactos.do")
public class Contactos {

	@Autowired
	NegocioContacto negocioContacto;

	@RequestMapping(method = RequestMethod.GET)
	public String visualizarContactos(Contacto contacto, HttpSession session,
			@RequestParam(value = "button") String button, @RequestParam(value = "idContacto") String id,
			@RequestParam(value = "mes") String mes, Model modelo) {

		if (button.equalsIgnoreCase("remove")) {
			negocioContacto.eliminarContacto(Integer.parseInt(id));
			return recuperarContactos(session);

		} else if (button.equalsIgnoreCase("update")) {
			Contacto contac = negocioContacto.recuperContacto(Integer.parseInt(id));
			session.setAttribute("contactoModificar", contac);
			return "modificarContacto";

		} else if (button.equalsIgnoreCase("add")) {

			negocioContacto.registrarContacto(contacto);
			return recuperarContactos(session);

		} else if (button.equalsIgnoreCase("filter")) {
			session.removeAttribute("mes");
			session.setAttribute("mes", mes);
			return recuperarContactos(session);
		}
		return "index";
	}

	public String recuperarContactos(HttpSession session) {

		ArrayList<Contacto> contactos;
		if (session.getAttribute("mes").equals("00")) {
			contactos = negocioContacto.recuperarContactos();

		} else {
			contactos = negocioContacto.recuperarContactosPorMes((Integer) session.getAttribute("mes"));
		}

		session.setAttribute("principal", contactos);
		return "principal";
	}

}
