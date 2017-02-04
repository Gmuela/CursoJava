package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import beans.Contacto;

@Repository("ContactoDAO")
public class ContactoDaoJPA implements ContactoDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean guardarContacto(Contacto contacto) {
		em.persist(contacto);
		return true;
	}

	@Override
	public Contacto recuperarContacto(Integer id) {

		return em.find(Contacto.class, id);
	}

	@Override
	public ArrayList<Contacto> recuperarContactos() {
		@SuppressWarnings("unchecked")
		List<Contacto> contactos = em.createQuery("SELECT contacto FROM Contacto contacto").getResultList();
		return (ArrayList<Contacto>) contactos;
	}

	@Override
	public void borrarContacto(Integer id) {
		Contacto contacto = em.find(Contacto.class, id);
		em.remove(contacto);
	}

	@Override
	public boolean modificarContacto(Contacto contacto) {
		em.merge(contacto);
		return true;
	}

}
