package Model.DAO;

import AgendaClasses.Contacto;

import java.util.ArrayList;

public interface ContactoDAO {
    boolean guardarContacto(Contacto contacto);

    Contacto recuperarContacto(String dni);

    ArrayList<Contacto> listarContactos();

    boolean borrarContacto(String id);

    boolean modificarContacto(Contacto contacto);

    ArrayList<Contacto> getContactosOf(String usuario);

    ArrayList<Contacto> getContactosFromMonth(String nombreUsuario, String mes);
}
