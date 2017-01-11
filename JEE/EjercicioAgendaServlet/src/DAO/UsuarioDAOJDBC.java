package DAO;

import AgendaClasses.Usuario;
import Utils.UtilDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOJDBC extends UtilDAO implements UsuarioDAO {

    private Connection connectionDB;

    public UsuarioDAOJDBC() {
        UtilDB utilDB = new UtilDB();
        this.connectionDB = utilDB.getConnection();
    }

    @Override
    public Usuario getUsuario(String nombre, String password) {

        String sql = "SELECT * FROM usuarios WHERE usuarios.nombre = ?";

        Usuario usuarioRecuperado = new Usuario();

        try {
            PreparedStatement selectUsuario = this.connectionDB.prepareStatement(sql);

            selectUsuario.setString(1, nombre);

            ResultSet datosPersona = selectUsuario.executeQuery();

            String[] datosUsuarioEnString = new String[3];

            datosPersona.next();

            for (int i = 0; i <= 2; i++) {
                datosUsuarioEnString[i] = datosPersona.getString(i + 1);
            }

            if (datosUsuarioEnString[2].equalsIgnoreCase(password)) {
                usuarioRecuperado = crearUsuario(datosUsuarioEnString);
            } else {
                usuarioRecuperado = null;
            }

        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta del nombre " + nombre + " " + e);
        }

        return usuarioRecuperado;
    }

    @Override
    public boolean registrarUsuario(Usuario contacto) {

        boolean success = true;

        String[] datosPersona = getUsuarioData(contacto);

        String sql = "INSERT INTO usuarios(nombre, email, password) VALUES (?,?,?)";

        try {
            PreparedStatement insertPersona = this.connectionDB.prepareStatement(sql);

            String nombre = datosPersona[0];
            String email = datosPersona[1];
            String password = datosPersona[2];

            insertPersona.setString(1, nombre);
            insertPersona.setString(2, email);
            insertPersona.setString(3, password);

            insertPersona.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar la contacto " + contacto.getNombre() + " " + e);
            success = false;
        }

        return success;

    }
}
