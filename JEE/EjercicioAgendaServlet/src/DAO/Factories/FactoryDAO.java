package DAO.Factories;

import DAO.ContactoDAO;
import DAO.ContactoDAOJDBC;
import DAO.UsuarioDAO;
import DAO.UsuarioDAOJDBC;

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
