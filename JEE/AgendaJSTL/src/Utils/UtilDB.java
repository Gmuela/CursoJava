package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDB {

    private static final String BBDD = "agendajpa";
    private static final String USER = "root";
    private static final String PASSWORD = "iesrey";
    private Connection connection;

    public UtilDB() {
        this.connection = createConnection();
    }

    private Connection createConnection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + BBDD + "?serverTimezone=UTC", USER, PASSWORD);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver JBDC no encontrado");
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            System.out.println("Error al conectarse a la BD");
            sqle.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error general");
            e.printStackTrace();
        }

        return connection;
    }

    public Connection getConnection() {
        return this.connection;

    }
}
