package AgendaClasses;

import DAO.Factories.FactoryPersonaDAO;
import DAO.PersonaDAO;

public class Agenda {

    private PersonaDAO personaDao = FactoryPersonaDAO.getPersonaDAO();

    public String insertarPersona(String nombre, String apellidos, String dni, Fecha fecha, String telefono) {

        Persona personaNueva = new Persona(nombre, apellidos, dni, fecha, telefono);
        boolean personaGuardadaCorrectamente = this.personaDao.guardarPersona(personaNueva);
        String mensaje;

        if (personaGuardadaCorrectamente) {
            mensaje = "Persona guardada";
        } else {
            mensaje = "Error al guardar persona";
        }
        return mensaje;
    }

    public String buscarPersona(String dni) {
        Persona persona = this.personaDao.recuperarPersona(dni);
        String informacionPersona;
        if (persona == null) {
            informacionPersona = "Persona con dni " + dni + " no encontrada";
        } else {
            informacionPersona = persona.toString();
        }
        return informacionPersona;
    }

    public void borrarPersona(String dni) {
        boolean borrado = this.personaDao.borrarPersona(dni);
        if (borrado) {
            System.out.println("Persona borrada correctamente" + "\n");
        } else{
            System.out.println("Persona no encontrada" + "\n");
        }
    }

    public void listarPersonas() {
        for (Persona contacto : this.personaDao.listarPersonas()) {
            System.out.println(contacto.toString() + "\n");
        }
    }

    public void listarCumpleanios(String mes) {
        for (Persona contacto : this.personaDao.listarPersonas()) {
            Fecha fechaNacimiento = contacto.getFechaNacimiento();
            String contactoMes = fechaNacimiento.getMes();
            if (contactoMes.equalsIgnoreCase(mes)) {
                System.out.println(contacto.toString() + "\n");
            }
        }
    }

    public void modificarPersona(String nombre, String apellidos, String dni, String fechaNacimiento, String telefono) {
        Persona persona = this.personaDao.recuperarPersona(dni);

        if(!nombre.equalsIgnoreCase("")){
            persona.setNombre(nombre);
        }
        if(!apellidos.equalsIgnoreCase("")){
            persona.setApellidos(apellidos);
        }
        if(!fechaNacimiento.equalsIgnoreCase("")){
            persona.setFechaNacimiento(new Fecha(fechaNacimiento));
        }
        if(!telefono.equalsIgnoreCase("")){
            persona.setTelefono(telefono);
        }

        boolean modificado = this.personaDao.modificarPersona(persona);

        if (modificado) {
            System.out.println("Persona modificada correctamente" + "\n");
        } else{
            System.out.println("Persona no encontrada" + "\n");
        }
    }
}
