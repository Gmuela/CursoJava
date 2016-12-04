package ejercicio6;

public class Empleado extends Persona {

    private Integer anioIngreso;
    private Integer numeroDespacho;

    public Empleado() {
    }

    public Empleado(String nombre, String apellidos, String dni, String estadoCivil, Integer anioIngreso, Integer numeroDespacho) {
        super(nombre, apellidos, dni, estadoCivil);
        this.anioIngreso = anioIngreso;
        this.numeroDespacho = numeroDespacho;
    }

    public String toString() {

        String info = super.toString();

        String numDespacho = "Número de despacho: " + this.numeroDespacho;
        String anioIngreso = "Año de ingreso: " + this.anioIngreso;

        String separador = "\n";
        info += separador + anioIngreso + separador + numDespacho;

        return info;
    }

    public Integer getAnioIngreso() {
        return anioIngreso;
    }

    public Integer getNumeroDespacho() {
        return numeroDespacho;
    }

    public void setNumeroDespacho(Integer numeroDespacho) {
        this.numeroDespacho = numeroDespacho;
    }
}
