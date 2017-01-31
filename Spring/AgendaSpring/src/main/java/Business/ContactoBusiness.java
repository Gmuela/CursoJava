package Business;

import Beans.Contacto;
import Beans.Usuario;
import Model.DAO.BasicDAO;
import Model.DAO.ContactoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContactoBusiness {

    @Autowired
    @Qualifier("ContactoDAOJPA")
    private ContactoDAO contactoDAO;

    @Autowired
    @Qualifier("ContactoDAOJPA")
    private BasicDAO<Contacto> basicDAO;

    public ArrayList<Contacto> getAllContactos(){
        return contactoDAO.selectAll();
    }

    public Contacto getContactoWithId(String id){
        return contactoDAO.selectContactoBy(id);
    }

    public ArrayList<Contacto> getContactosOf(Usuario usuario){
        return contactoDAO.selectContactosOf(usuario);
    }

    public ArrayList<Contacto> getContactosWithMonth(Usuario usuario, String mes){
        return contactoDAO.selectContactosFromMonth(usuario,mes);
    }

    public boolean removeContacto(String id){
        contactoDAO.deleteContactoBy(id);
        return true;
    }

    public boolean createContacto(Contacto contacto){
        basicDAO.insert(contacto);
        return true;
    }

    public boolean modifyContacto(Contacto contacto){
        basicDAO.update(contacto);
        return true;
    }

}
