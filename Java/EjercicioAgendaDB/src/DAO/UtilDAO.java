package DAO;

import AgendaClasses.Fecha;
import AgendaClasses.Persona;

class UtilDAO {

    Persona crearPersona(String[] datos) {

        String nombre = datos[0];
        String apellidos = datos[1];
        String dni = datos[2];
        Fecha fechaNacimiento = new Fecha(datos[3]);
        String telefono = datos[4];

        return new Persona(nombre, apellidos, dni, fechaNacimiento, telefono);
    }

    protected String[] getPersonaData(Persona persona) {

        String nombre = persona.getNombre();
        String apellidos = persona.getApellidos();
        String dni = persona.getDni();

        Fecha fechaNacimiento = persona.getFechaNacimiento();
        String s = fechaNacimiento.toString();

        String telefono = persona.getTelefono();

        return new String[]{nombre, apellidos, dni, s, telefono};
    }
}
