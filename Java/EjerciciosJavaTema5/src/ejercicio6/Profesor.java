package ejercicio6;

public class Profesor extends Empleado {

    private String departamento;

    public Profesor(String nombre, String apellidos, String dni, String estadoCivil, Integer anioIngreso, Integer numeroDespacho, String departamento) {
        super(nombre, apellidos, dni, estadoCivil, anioIngreso, numeroDespacho);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String toString() {

        String info = super.toString();

        String departamento = "Departamento: " + this.departamento;
        String separador = "\n";

        info += separador + departamento;

        return info;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
