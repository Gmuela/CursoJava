package Business;

import Beans.Contacto;
import Beans.Usuario;
import Model.DAO.ContactoDAO;
import Model.DAO.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ContactoBusiness {

    @Autowired
    @Qualifier("ContactoDAOMongo")
    private ContactoDAO contactoDAO;

    @Autowired
    @Qualifier("ContactoDAOMongo")
    private BasicDAO<Contacto> basicDAO;

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
        basicDAO.insert(contacto);
        return true;
    }

    @Transactional
    public boolean modifyContacto(Contacto contacto){
        basicDAO.update(contacto);
        return true;
    }

}
