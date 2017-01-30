package Model.Factories;

import Model.DAO.*;
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
