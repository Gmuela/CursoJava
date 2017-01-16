package Model.Factories;

import Model.DAO.ContactoDAO;
import Model.DAO.ContactoDAOJDBC;
import Model.DAO.UsuarioDAO;
import Model.DAO.UsuarioDAOJDBC;

public class FactoryDAO {

    public static ContactoDAO getContactoDAO(){
        ContactoDAO dao = null;
        dao = new ContactoDAOJDBC();
        return dao;
    }

    public static UsuarioDAO getUsuarioDAO(){
        UsuarioDAO dao = null;
        dao = new UsuarioDAOJDBC();
        return dao;
    }
}
