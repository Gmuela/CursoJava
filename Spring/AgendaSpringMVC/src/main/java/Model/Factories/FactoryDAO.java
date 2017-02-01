package Model.Factories;

import Model.DAO.ContactoDAO;
import Model.DAO.ContactoDAOJPA;
import Model.DAO.UsuarioDAO;
import Model.DAO.UsuarioDAOJPA;
import org.springframework.stereotype.Repository;

@Repository
public class FactoryDAO {

    public static ContactoDAO getContactoDAO(){
        ContactoDAO dao = null;
        dao = new ContactoDAOJPA();
        return dao;
    }

    public static UsuarioDAO getUsuarioDAO(){
        UsuarioDAO dao = null;
        dao = new UsuarioDAOJPA();
        return dao;
    }
}
