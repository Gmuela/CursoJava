package DAO;

import AgendaClasses.Fecha;
import AgendaClasses.Persona;
import IOClasses.EscrituraFichero;
import IOClasses.LectorFichero;

import java.util.ArrayList;

public class PersonaDAOFichero extends UtilDAO implements PersonaDAO {

    private EscrituraFichero escritor;
    private LectorFichero lector;
    private static final String FICHERO_AGENDA = "ficheroAgenda.txt";

    public PersonaDAOFichero() {
        //Default
    }

    private void createReader() {
        this.lector = new LectorFichero(FICHERO_AGENDA);
    }

    private void createWriter() {
        this.escritor = new EscrituraFichero(FICHERO_AGENDA, true);
    }

    private void createWriterOverWrite() {
        this.escritor = new EscrituraFichero(FICHERO_AGENDA, false);
    }

    @Override
    public boolean guardarPersona(Persona persona) {

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
            if (line != null) {
                String[] split = line.split(" ");
                for (String data : split) {
                    if (data.equalsIgnoreCase(dni)) {
                        personaRecuperada = crearPersona(split);
                    }
                }
            }
        }
        this.lector.close();
        return personaRecuperada;
    }

    @Override
    public ArrayList<Persona> listarPersonas() {
        createReader();
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        String line = "";

        while (line != null) {
            line = lector.leerLinea();
            if (line != null) {
                String[] split = line.split(" ");
                listaPersonas.add(crearPersona(split));
            }
        }
        this.lector.close();
        return listaPersonas;
    }


    @Override
    public boolean borrarPersona(String dni) {

        boolean borrado = false;

        createReader();

        ArrayList<Persona> personasGuardadas = new ArrayList<>();
        String linea = "";

        while (linea != null) {
            linea = lector.leerLinea();
            if (linea != null) {
                String[] split = linea.split(" ");
                Persona personaRecuperada = crearPersona(split);

                String dniPersona = personaRecuperada.getDni();
                if (!dniPersona.equalsIgnoreCase(dni)) {
                    personasGuardadas.add(personaRecuperada);
                } else {
                    borrado = true;
                }
            }
        }
        this.lector.close();

        createWriterOverWrite();

        for (Persona persona : personasGuardadas) {
            this.escritor.escribirLinea(persona.returnData());
        }
        this.escritor.close();

        return borrado;
    }

    @Override
    public boolean modificarPersona(Persona persona) {
        borrarPersona(persona.getDni());
        guardarPersona(persona);
        return false;
    }
}
