package ejercicio6;

public class Persona implements InterfazPersona {

    private String nombre;
    private String apellidos;
    private String dni;
    private String estadoCivil;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String dni, String estadoCivil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
}
