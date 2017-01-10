package AgendaClasses;

public class Contacto {

    private String nombre;
    private String apellidos;
    private String dni;
    private Fecha fechaNacimiento;
    private String telefono;

    public Contacto() {
        //Dafault constructor
    }

    public Contacto(String nombre, String apellidos, String dni, Fecha fechaNacimiento, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public String toString() {

        String info;

        String nombre = "Nombre: " + this.nombre;
        String apellidos = "Apellidos: " + this.apellidos;
        String dni = "DNI: " + this.dni;
        String fecha = "Fecha: " + this.fechaNacimiento.toString();
        String telefono = "Teléfono: " + this.telefono;

        String separadorVertical = "\n";

        info = nombre + separadorVertical + apellidos + separadorVertical + dni + separadorVertical + fecha + separadorVertical + telefono;
        return info;
    }

    public String returnData() {

        String info;

        String nombre = this.nombre;
        String apellidos = this.apellidos;
        String dni = this.dni;
        String fecha = this.fechaNacimiento.toString();
        String telefono = this.telefono;

        String separadorVertical = " ";

        info = nombre + separadorVertical + apellidos + separadorVertical + dni + separadorVertical + fecha + separadorVertical + telefono;
        return info;
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

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
