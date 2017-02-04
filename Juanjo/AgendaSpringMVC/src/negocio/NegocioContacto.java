package negocio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.Contacto;
import modelo.ContactoDao;


@Service
public class NegocioContacto {

	@Autowired
    @Qualifier("ContactoDAO")
	private ContactoDao contactoDao;

	@Transactional
	public boolean registrarContacto(Contacto contacto) {
		contactoDao.guardarContacto(contacto);
		return true;
	}

	@Transactional
	public boolean modificarContacto(Contacto contacto) {
		contactoDao.modificarContacto(contacto);
		return true;
	}

	@Transactional
	public boolean eliminarContacto(Integer id) {
		contactoDao.borrarContacto(id);
		return true;
	}

	@Transactional
	public Contacto recuperContacto(Integer id) {

		return contactoDao.recuperarContacto(id);
	}

	@Transactional
	public ArrayList<Contacto> recuperarContactos() {
		return contactoDao.recuperarContactos();
	}

	@Transactional
	public ArrayList<Contacto> recuperarContactosPorMes(Integer mes) {

		ArrayList<Contacto> aux = contactoDao.recuperarContactos();
		for (Contacto contacto : aux) {
			if (contacto.getFechaNacimiento().getMonthValue() == mes) {
				aux.add(contacto);

			}

		}
		return aux;
	}

}
