package DAO;

import AgendaClasses.Contacto;
import AgendaClasses.Fecha;
import AgendaClasses.Usuario;

class UtilDAO {

    Contacto crearContacto(String[] datos) {

        String id = datos[0];
        String nombre = datos[1];
        String apellidos = datos[2];
        String dni = datos[3];
        Fecha fechaNacimiento = new Fecha(datos[4]);
        String telefono = datos[5];
        String nombre_usuario = datos[6];

        Contacto contacto = new Contacto(nombre, apellidos, dni, fechaNacimiento, telefono, nombre_usuario);
        contacto.setId(Integer.parseInt(id));

        return contacto;
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
        String fecha = fechaNacimiento.toString();

        String telefono = contacto.getTelefono();
        String nombre_usuario = contacto.getNombre_usuario();

        return new String[]{nombre, apellidos, dni, fecha, telefono, nombre_usuario};
    }

    protected String[] getUsuarioData(Usuario usuario) {

        String nombre = usuario.getNombre();
        String email = usuario.getEmail();
        String password = usuario.getPassword();

        return new String[]{nombre, email, password};
    }
}
