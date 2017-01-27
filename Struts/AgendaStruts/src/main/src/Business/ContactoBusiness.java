package Business;

import Beans.Contacto;
import Beans.Usuario;
import Model.DAO.BasicDAO;
import Model.DAO.ContactoDAO;
import Model.Factories.FactoryDAO;

import java.util.ArrayList;

public class ContactoBusiness {

    private ContactoDAO contactoDAO;
    private BasicDAO<Contacto> basicDAO;

    public ContactoBusiness() {
        this.contactoDAO = FactoryDAO.getContactoDAO();
        this.basicDAO = FactoryDAO.getBasiDAOContacto();
    }

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
