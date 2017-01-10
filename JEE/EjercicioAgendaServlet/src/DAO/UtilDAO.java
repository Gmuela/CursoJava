package DAO;

import AgendaClasses.Contacto;
import AgendaClasses.Fecha;
import AgendaClasses.Usuario;

class UtilDAO {

    Contacto crearContacto(String[] datos) {

        String nombre = datos[0];
        String apellidos = datos[1];
        String dni = datos[2];
        Fecha fechaNacimiento = new Fecha(datos[3]);
        String telefono = datos[4];

        return new Contacto(nombre, apellidos, dni, fechaNacimiento, telefono);
    }

    Usuario crearUsuario(String[] datos) {

        String nombre = datos[0];
        String email = datos[1];
        String password = datos[2];

        return new Usuario(nombre, email, password);
    }

    protected String[] getContactoData(Contacto contacto) {

        String nombre = contacto.getNombre();
        String apellidos = contacto.getApellidos();
        String dni = contacto.getDni();

        Fecha fechaNacimiento = contacto.getFechaNacimiento();
        String s = fechaNacimiento.toString();

        String telefono = contacto.getTelefono();

        return new String[]{nombre, apellidos, dni, s, telefono};
    }
}
