package ejercicio6;

public class PersonalServicio extends Empleado{

    private String seccionAsignada;

    public PersonalServicio() {
        //Default
    }

    public PersonalServicio(String nombre, String apellidos, String dni, String estadoCivil, Integer anioIngreso, Integer numeroDespacho, String seccionAsignada) {
        super(nombre, apellidos, dni, estadoCivil, anioIngreso, numeroDespacho);
        this.seccionAsignada = seccionAsignada;
    }

    public String toString() {

        String info = super.toString();

        String seccionAsignada = "Sección Asignada: " + this.seccionAsignada;
        String separador = "\n";

        info += separador + seccionAsignada;

        return info;
    }

    public String getSeccionAsignada() {
        return seccionAsignada;
    }

    public void setSeccionAsignada(String seccionAsignada) {
        this.seccionAsignada = seccionAsignada;
    }
}
