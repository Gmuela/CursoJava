package ejercicio6;

public class Empleado extends Persona {

    private String anioIngreso;
    private Integer numeroDespacho;

    public Empleado() {
    }

    public Empleado(String nombre, String apellidos, String dni, String estadoCivil, String anioIngreso, Integer numeroDespacho) {
        super(nombre, apellidos, dni, estadoCivil);
        this.anioIngreso = anioIngreso;
        this.numeroDespacho = numeroDespacho;
    }

    public String getAnioIngreso() {
        return anioIngreso;
    }

    public Integer getNumeroDespacho() {
        return numeroDespacho;
    }
}
