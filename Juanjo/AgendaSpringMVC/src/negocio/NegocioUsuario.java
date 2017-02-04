package negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import beans.Usuario;
import modelo.UsuarioDao;

@Service
public class NegocioUsuario {

	@Autowired
    @Qualifier("UsuarioDAO")
	private UsuarioDao usuarioDao;


	@Transactional
	public boolean registrarUsuario(Usuario usuario) {
		usuarioDao.registrarUsuario(usuario);
		return true;
	}


	@Transactional
	public Usuario recuperarUsuario(String nombre) {
		return usuarioDao.recuperarUsuario(nombre);
	}
	
}