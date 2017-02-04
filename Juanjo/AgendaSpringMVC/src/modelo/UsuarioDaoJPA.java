package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import beans.Usuario;

@Repository("UsuarioDAO")
public class UsuarioDaoJPA implements UsuarioDao {

	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void registrarUsuario(Usuario usuario) {
		em.persist(usuario);
		
	}

	@Override
	public Usuario recuperarUsuario(String nombre) {
	
		return em.find(Usuario.class, nombre);
	}

}
