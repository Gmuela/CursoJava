package DAO;

import AgendaClasses.Fecha;
import AgendaClasses.Persona;
import Utils.UtilDB;

import java.sql.*;
import java.util.ArrayList;

public class PersonaDAOJDBC extends UtilDAO implements PersonaDAO {

    private Connection connectionDB;

    public PersonaDAOJDBC() {
        UtilDB utilDB = new UtilDB();
        this.connectionDB = utilDB.getConnection();
    }

    @Override
    public boolean guardarPersona(Persona persona) {

        boolean success = true;

        String[] datosPersona = getPersonaData(persona);

        String sql = "INSERT INTO Personas(nombre,apellidos,dni,fechaNacimiento,telefono) VALUES (?,?,?,?,?)";

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
            System.out.println("Error al insertar la persona " + persona.getNombre() + " " + e);
            success = false;
        }

        return success;
    }

    @Override
    public Persona recuperarPersona(String dni) {

        Persona personaRecuperada = null;

        String sql = "SELECT * FROM personas WHERE personas.dni = ?";

        try {
            PreparedStatement selectPersona = this.connectionDB.prepareStatement(sql);

            selectPersona.setString(1, dni);

            ResultSet datosPersona = selectPersona.executeQuery();

            String[] datosPersonaEnString = new String[5];

            datosPersona.next();

            for (int i = 0; i <= 4; i++) {
                datosPersonaEnString[i] = datosPersona.getString(i + 1);
            }

            personaRecuperada = crearPersona(datosPersonaEnString);

        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta del dni " + dni + " " + e);
        }


        return personaRecuperada;
    }

    @Override
    public ArrayList<Persona> listarPersonas() {
        ArrayList<Persona> allPersonas = new ArrayList<>();
        Persona persona = null;

        String sql = "SELECT * FROM personas";

        try {
            Statement selectAll = this.connectionDB.createStatement();

            ResultSet datosPersona = selectAll.executeQuery(sql);

            String[] datosPersonaEnString = new String[5];

            while (datosPersona.next()) {
                for (int i = 0; i <= 4; i++) {
                    datosPersonaEnString[i] = datosPersona.getString(i + 1);
                }
                persona = crearPersona(datosPersonaEnString);
                allPersonas.add(persona);
            }

        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta " + e);
        }

        return allPersonas;
    }

    @Override
    public boolean borrarPersona(String dni) {

        boolean borrado = false;

        String sql = "DELETE FROM personas WHERE personas.dni = ?";

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
    public boolean modificarPersona(Persona persona) {

        String[] datosPersona = getPersonaData(persona);

        boolean modificado = false;

        String sql = "UPDATE personas SET nombre = ?, apellidos = ?, dni = ?, fechaNacimiento = ?, telefono = ? WHERE personas.dni = ?";


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
            System.out.println("Error al realizar el update de " + persona.getNombre() + " " + e);
        }

        return modificado;
    }

}
