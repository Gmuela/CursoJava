package Model.Factories;

import Beans.Contacto;
import Beans.Usuario;
import Model.DAO.*;

public class FactoryDAO {

    public static ContactoDAO getContactoDAO(){
        return new ContactoDAOJPA();
    }

    public static UsuarioDAO getUsuarioDAO(){
        return new UsuarioDAOJPA();
    }

    public static BasicDAO<Usuario> getBasiDAOUsuario(){
        return new UsuarioDAOJPA();
    }

    public static BasicDAO<Contacto> getBasiDAOContacto(){
        return new ContactoDAOJPA();
    }
}
