package ejercicio2;

public class Empleado {

    private String nombre;
    private String nif;
    private Integer edad;
    private Boolean isCasado;
    private Double salario;

    public Empleado() {
        //Default constructor
    }

    public Empleado(String nombre, String nif, Integer edad, Boolean isCasado, Double salario) {
        this.nombre = nombre;
        this.nif = nif;
        this.edad = edad;
        this.isCasado = isCasado;
        this.salario = salario;
    }

    public String mostrarCategoria() {

        String categoria = "";

        if (this.edad <= 21) {
            categoria = "Principiante";
        }
        if (this.edad >= 22 && this.edad <= 35) {
            categoria = "Intermedio";
        }
        if (this.edad > 35) {
            categoria = "Senior";
        }

        return categoria;
    }

    public String toString() {
        String infoEmpleado;

        String separador = "\n";

        String nombre = "Nombre: " + this.nombre;
        String nif = "NIF: " + this.nif;
        String edad = "Edad: " + this.edad;
        String compruebaCasado = this.isCasado ? "Sí" : "No";
        String isCasado = "Casado: " + compruebaCasado;
        String salario = "Salario: " + this.salario;

        infoEmpleado = nombre + separador + nif + separador + edad + separador + isCasado + separador + salario;

        return infoEmpleado;
    }

    public void aumentarSalario(Double porcentaje){
        this.salario = this.salario + ((this.salario * porcentaje)/100);
    }

    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }

    public Integer getEdad() {
        return edad;
    }

    public Boolean getCasado() {
        return isCasado;
    }

    public Double getSalario() {
        return salario;
    }
}
