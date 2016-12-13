package DAO;

import AgendaClasses.Persona;

import java.util.ArrayList;

public interface PersonaDAO {
    boolean guardaPersona(Persona persona);

    Persona recuperarPersona(String dni);

    ArrayList<Persona> listarPersonas();

    boolean borrarPersona(String dni);
}
