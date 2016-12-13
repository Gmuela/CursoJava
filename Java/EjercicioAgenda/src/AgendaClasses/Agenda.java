package AgendaClasses;

import DAO.PersonaDAO;
import DAO.PersonaDAOFichero;

public class Agenda {

    private PersonaDAO personaDao = new PersonaDAOFichero();

    public void insertarPersona(String nombre, String apellidos, String dni, Fecha fecha, String telefono) {
        Persona personaNueva = new Persona(nombre, apellidos, dni, fecha, telefono);

        this.personaDao.guardaPersona(personaNueva);
    }

    public void buscarPersona(String dni) {
        System.out.println(this.personaDao.recuperarPersona(dni));
    }

    public void borrarPersona(String dni) {
        this.personaDao.borrarPersona(dni);
    }

    public void listarPersonas() {
        for (Persona contacto : this.personaDao.listarPersonas()) {
            System.out.println(contacto.toString());
        }
    }

    public void listarCumpleanios(String mes) {
        for (Persona contacto : this.personaDao.listarPersonas()) {
            Fecha fechaNacimiento = contacto.getFechaNacimiento();
            String contactoMes = fechaNacimiento.getMes();
            if (contactoMes.equalsIgnoreCase(mes)) {
                System.out.println(contacto.toString());
            }
        }
    }
}
