package Model.DAO;

import Beans.Contacto;
import Beans.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository(value = "ContactoDAO")
public interface ContactoDAO {
    ArrayList<Contacto> selectAll();

    Contacto selectContactoBy(String dni);

    ArrayList<Contacto> selectContactosOf(Usuario usuario);

    ArrayList<Contacto> selectContactosFromMonth(Usuario usuario, String mes);

    boolean deleteContactoBy(String id);
}
