package DAO;

import AgendaClasses.Persona;

import java.util.ArrayList;

public interface PersonaDAO {
    boolean guardarPersona(Persona persona);

    Persona recuperarPersona(String dni);

    ArrayList<Persona> listarPersonas();

    boolean borrarPersona(String dni);

    boolean modificarPersona(Persona persona);
}
