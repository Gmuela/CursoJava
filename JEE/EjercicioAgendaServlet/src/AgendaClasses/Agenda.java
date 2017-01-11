package AgendaClasses;

import DAO.Factories.FactoryDAO;
import DAO.ContactoDAO;

public class Agenda {

    private ContactoDAO contactoDao = FactoryDAO.getContactoDAO();

    public String insertarPersona(String nombre, String apellidos, String dni, Fecha fecha, String telefono, String nombre_usuario) {

        Contacto contactoNuevo = new Contacto(nombre, apellidos, dni, fecha, telefono, nombre_usuario);
        boolean personaGuardadaCorrectamente = this.contactoDao.guardarContacto(contactoNuevo);
        String mensaje;

        if (personaGuardadaCorrectamente) {
            mensaje = "Contacto guardada";
        } else {
            mensaje = "Error al guardar persona";
        }
        return mensaje;
    }

    public String buscarPersona(String dni) {
        Contacto contacto = this.contactoDao.recuperarContacto(dni);
        String informacionPersona;
        if (contacto == null) {
            informacionPersona = "Contacto con dni " + dni + " no encontrada";
        } else {
            informacionPersona = contacto.toString();
        }
        return informacionPersona;
    }

    public void borrarPersona(String dni) {
        boolean borrado = this.contactoDao.borrarContacto(dni);
        if (borrado) {
            System.out.println("Contacto borrada correctamente" + "\n");
        } else{
            System.out.println("Contacto no encontrada" + "\n");
        }
    }

    public void listarcontactos() {
        for (Contacto contacto : this.contactoDao.listarContactos()) {
            System.out.println(contacto.toString() + "\n");
        }
    }

    public void listarCumpleanios(String mes) {
        for (Contacto contacto : this.contactoDao.listarContactos()) {
            Fecha fechaNacimiento = contacto.getFechaNacimiento();
            String contactoMes = fechaNacimiento.getMes();
            if (contactoMes.equalsIgnoreCase(mes)) {
                System.out.println(contacto.toString() + "\n");
            }
        }
    }

    public void modificarPersona(String nombre, String apellidos, String dni, String fechaNacimiento, String telefono) {
        Contacto contacto = this.contactoDao.recuperarContacto(dni);

        if(!nombre.equalsIgnoreCase("")){
            contacto.setNombre(nombre);
        }
        if(!apellidos.equalsIgnoreCase("")){
            contacto.setApellidos(apellidos);
        }
        if(!fechaNacimiento.equalsIgnoreCase("")){
            contacto.setFechaNacimiento(new Fecha(fechaNacimiento));
        }
        if(!telefono.equalsIgnoreCase("")){
            contacto.setTelefono(telefono);
        }

        boolean modificado = this.contactoDao.modificarContacto(contacto);

        if (modificado) {
            System.out.println("Contacto modificada correctamente" + "\n");
        } else{
            System.out.println("Contacto no encontrada" + "\n");
        }
    }
}
