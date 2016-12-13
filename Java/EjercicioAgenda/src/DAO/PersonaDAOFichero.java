package DAO;

import AgendaClasses.Fecha;
import AgendaClasses.Persona;
import IOClasses.EscrituraFichero;
import IOClasses.LectorFichero;

import java.util.ArrayList;

public class PersonaDAOFichero implements PersonaDAO {

    private EscrituraFichero escritor;
    private LectorFichero lector;
    private String FICHERO_AGENDA = "ficheroAgenda.txt";

    public PersonaDAOFichero() {
        //Default
    }

    private void createReader() {
        this.lector = new LectorFichero(FICHERO_AGENDA);
    }

    private void createWriter() {
        this.escritor = new EscrituraFichero(FICHERO_AGENDA, true);
    }

    @Override
    public boolean guardaPersona(Persona persona) {

        boolean success;

        createWriter();
        String datosPersona = persona.returnData();
        success = escritor.escribirLinea(datosPersona);
        escritor.close();

        return success;
    }

    @Override
    public Persona recuperarPersona(String dni) {
        createReader();
        Persona personaRecuperada = null;
        String line;

        line = lector.leerLinea();
        while (line != null) {
            line = lector.leerLinea();
            String[] split = line.split(" ");
            for (String data : split) {
                if (data.equalsIgnoreCase(dni)) {
                    personaRecuperada = crearPersona(split);
                }
            }
        }
        this.lector.close();
        return personaRecuperada;
    }

    private Persona crearPersona(String[] split) {

        String nombre = split[0];
        String apellidos = split[1];
        String dni = split[2];
        Fecha fechaNacimiento = new Fecha(split[3]);
        String telefono = split[4];

        Persona persona = new Persona(nombre, apellidos, dni, fechaNacimiento, telefono);

        return persona;
    }


    @Override
    public ArrayList<Persona> listarPersonas() {
        return null;
    }

    @Override
    public boolean borrarPersona(String dni) {
        return false;
    }
}
