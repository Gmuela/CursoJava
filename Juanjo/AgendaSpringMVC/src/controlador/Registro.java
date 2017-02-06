package controlador;

import beans.Usuario;

import negocio.NegocioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/registro.do")
public class Registro {

	@Autowired
	private NegocioUsuario negocioUsuario;

	@RequestMapping(method = RequestMethod.POST)
	public String registrarUsuario(Usuario usuario) {

		String direccion;

		boolean success = negocioUsuario.registrarUsuario(usuario);

		if (!success) {
			direccion = "errorRegistro";
		} else {

			direccion = "index";
		}

		return direccion;
	}

}