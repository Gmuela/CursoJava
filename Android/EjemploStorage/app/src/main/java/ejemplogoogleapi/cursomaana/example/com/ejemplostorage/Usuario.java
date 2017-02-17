package ejemplogoogleapi.cursomaana.example.com.ejemplostorage;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String password;
    private String email;

    public Usuario(String nombre, String password, String email) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
