import java.sql.*;

public class hola {


    public static void main(String[] args) {


        UtilDB db = new UtilDB();

        Connection con = db.getConnection();

        try {
            Statement st = con.createStatement();

            st.execute("CREATE TABLE Autores (id INT(11) PRIMARY KEY , nombre VARCHAR(64) UNIQUE)");
            st.execute("CREATE TABLE Libros (id INT(11) PRIMARY KEY, title VARCHAR(64), autor INT(64), CONSTRAINT FK_AUTOR FOREIGN KEY(autor) REFERENCES autores(id) ON UPDATE CASCADE ON  DELETE CASCADE);");

            st.execute("INSERT INTO autores(id, nombre) VALUES (1,'Paco')");
            st.execute("INSERT INTO autores(id, nombre) VALUES (2,'Pepe')");
            st.execute("INSERT INTO autores(id, nombre) VALUES (3,'Papapaco')");

            st.execute("INSERT INTO libros(id, title, autor) VALUES (1,'Libro de paco',1)");
            st.execute("INSERT INTO libros(id, title, autor) VALUES (2,'Libro de pepe',2)");
            st.execute("INSERT INTO libros(id, title, autor) VALUES (3,'Libro de papapaco',3)");

            ResultSet resultSet = st.executeQuery("SELECT title,autores.nombre FROM libros, autores WHERE libros.autor = autores.id");

            st.close();
            con.close();

            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
