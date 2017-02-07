package Business;

import Beans.Contacto;
import Beans.Usuario;
import Model.DAO.JPA.BasicDAOJPA;
import Model.DAO.ContactoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ContactoBusiness {

    @Autowired
    @Qualifier("ContactoDAOJPA")
    private ContactoDAO contactoDAO;

    @Autowired
    @Qualifier("ContactoDAOJPA")
    private BasicDAOJPA<Contacto> basicDAOJPA;

    @Transactional
    public ArrayList<Contacto> getAllContactos(){
        return contactoDAO.selectAll();
    }

    @Transactional
    public Contacto getContactoWithId(String id){
        return contactoDAO.selectContactoBy(id);
    }

    @Transactional
    public ArrayList<Contacto> getContactosOf(Usuario usuario){
        return contactoDAO.selectContactosOf(usuario);
    }

    @Transactional
    public ArrayList<Contacto> getContactosWithMonth(Usuario usuario, String mes){
        return contactoDAO.selectContactosFromMonth(usuario,mes);
    }

    @Transactional
    public boolean removeContacto(String id){
        contactoDAO.deleteContactoBy(id);
        return true;
    }

    @Transactional
    public boolean createContacto(Contacto contacto){
        basicDAOJPA.insert(contacto);
        return true;
    }

    @Transactional
    public boolean modifyContacto(Contacto contacto){
        basicDAOJPA.update(contacto);
        return true;
    }

}
