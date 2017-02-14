package Model.DAO;

import Beans.Contacto;
import Beans.Usuario;

import java.util.ArrayList;

public interface ContactoDAO {
    ArrayList<Contacto> selectAll();

    Contacto selectContactoBy(Integer id);

    ArrayList<Contacto> selectContactosOf(Usuario usuario);

    ArrayList<Contacto> selectContactosFromMonth(Usuario usuario, String mes);

    boolean deleteContactoBy(String id);
}
