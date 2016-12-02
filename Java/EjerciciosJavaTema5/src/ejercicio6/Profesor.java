package ejercicio6;

public class Profesor extends Empleado {

    private String departamento;

    public Profesor(String nombre, String apellidos, String dni, String estadoCivil, String anioIngreso, Integer numeroDespacho, String departamento) {
        super(nombre, apellidos, dni, estadoCivil, anioIngreso, numeroDespacho);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
}
