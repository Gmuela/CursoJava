package DAO;

import AgendaClasses.Contacto;
import Utils.UtilDB;

import java.sql.*;
import java.util.ArrayList;

public class ContactoDAOJDBC extends UtilDAO implements ContactoDAO {

    private Connection connectionDB;

    public ContactoDAOJDBC() {
        UtilDB utilDB = new UtilDB();
        this.connectionDB = utilDB.getConnection();
    }

    @Override
    public boolean guardarContacto(Contacto contacto) {

        boolean success = true;

        String[] datosPersona = getContactoData(contacto);

        String sql = "INSERT INTO contactos(nombre,apellidos,dni,fechaNacimiento,telefono) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement insertPersona = this.connectionDB.prepareStatement(sql);

            String nombre = datosPersona[0];
            String apellidos = datosPersona[1];
            String dni = datosPersona[2];
            String fechaNacimiento = datosPersona[3];
            String telefono = datosPersona[4];

            insertPersona.setString(1, nombre);
            insertPersona.setString(2, apellidos);
            insertPersona.setString(3, dni);
            insertPersona.setString(4, fechaNacimiento);
            insertPersona.setString(5, telefono);

            insertPersona.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar la contacto " + contacto.getNombre() + " " + e);
            success = false;
        }

        return success;
    }

    @Override
    public Contacto recuperarContacto(String dni) {

        Contacto contactoRecuperado = null;

        String sql = "SELECT * FROM contactos WHERE contactos.dni = ?";

        try {
            PreparedStatement selectPersona = this.connectionDB.prepareStatement(sql);

            selectPersona.setString(1, dni);

            ResultSet datosPersona = selectPersona.executeQuery();

            String[] datosPersonaEnString = new String[5];

            datosPersona.next();

            for (int i = 0; i <= 4; i++) {
                datosPersonaEnString[i] = datosPersona.getString(i + 1);
            }

            contactoRecuperado = crearContacto(datosPersonaEnString);

        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta del dni " + dni + " " + e);
        }


        return contactoRecuperado;
    }

    @Override
    public ArrayList<Contacto> listarContactos() {
        ArrayList<Contacto> allcontactos = new ArrayList<>();
        Contacto contacto = null;

        String sql = "SELECT * FROM contactos";

        try {
            Statement selectAll = this.connectionDB.createStatement();

            ResultSet datosPersona = selectAll.executeQuery(sql);

            String[] datosPersonaEnString = new String[5];

            while (datosPersona.next()) {
                for (int i = 0; i <= 4; i++) {
                    datosPersonaEnString[i] = datosPersona.getString(i + 1);
                }
                contacto = crearContacto(datosPersonaEnString);
                allcontactos.add(contacto);
            }

        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta " + e);
        }

        return allcontactos;
    }

    @Override
    public boolean borrarContacto(String dni) {

        boolean borrado = false;

        String sql = "DELETE FROM contactos WHERE contactos.dni = ?";

        try {
            PreparedStatement deletePersona = this.connectionDB.prepareStatement(sql);

            deletePersona.setString(1, dni);

            deletePersona.execute();

            borrado = true;

        } catch (SQLException e) {
            System.out.println("Error al realizar el borrado del dni " + dni + " " + e);
        }

        return borrado;
    }

    @Override
    public boolean modificarContacto(Contacto contacto) {

        String[] datosPersona = getContactoData(contacto);

        boolean modificado = false;

        String sql = "UPDATE contactos SET nombre = ?, apellidos = ?, dni = ?, fechaNacimiento = ?, telefono = ? WHERE contactos.dni = ?";


        try {
            PreparedStatement updatePersona = this.connectionDB.prepareStatement(sql);

            String nombre = datosPersona[0];
            String apellidos = datosPersona[1];
            String dni = datosPersona[2];
            String fechaNacimiento = datosPersona[3];
            String telefono = datosPersona[4];

            updatePersona.setString(1, nombre);
            updatePersona.setString(2, apellidos);
            updatePersona.setString(3, dni);
            updatePersona.setString(4, fechaNacimiento);
            updatePersona.setString(5, telefono);
            updatePersona.setString(6, dni);

            updatePersona.executeUpdate();

            modificado = true;

        } catch (SQLException e) {
            System.out.println("Error al realizar el update de " + contacto.getNombre() + " " + e);
        }

        return modificado;
    }

}
