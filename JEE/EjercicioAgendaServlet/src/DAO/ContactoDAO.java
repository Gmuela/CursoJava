package DAO;

import AgendaClasses.Contacto;

import java.util.ArrayList;

public interface ContactoDAO {
    boolean guardarContacto(Contacto contacto);

    Contacto recuperarContacto(String dni);

    ArrayList<Contacto> listarContactos();

    boolean borrarContacto(String dni);

    boolean modificarContacto(Contacto contacto);
}
