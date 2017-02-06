package controlador;

import beans.Usuario;

import negocio.NegocioUsuario;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login.do")
public class Login {

	@Autowired
	NegocioUsuario negocioUsuario;

	@RequestMapping(method = RequestMethod.POST)
	public String loguearUsuario(@RequestParam(value = "nombre") String nombre, HttpSession session, Model modelo) {

		String direccion;

		Usuario usuario = negocioUsuario.recuperarUsuario(nombre);

		if (usuario != null) {

			session.setAttribute("usuario", usuario);
			session.setAttribute("mes", "00");
			direccion = "principal";
		} else {

			direccion = "index";
		}

		return direccion;

	}

}