package ejercicio3;

public class Vehiculo implements InterfazVehiculo {

    private String matricula;
    private Double kilometraje;
    private Boolean isAlquilado;

    public Vehiculo(String matricula, Double kilometraje, Boolean isAlquilado) {
        this.matricula = matricula;
        this.kilometraje = kilometraje;
        this.isAlquilado = isAlquilado;
    }

    public String toString() {
        String info;

        String matricula = "Matrícula: " + this.matricula;
        String kilometraje = "Kilometraje: " + this.kilometraje;
        String compruebaAlquildo = this.isAlquilado ? "Sí" : "No";
        String alquilado = "Alquilado: " + compruebaAlquildo;

        String separador = "\n";

        info = matricula + separador + kilometraje + separador + alquilado;

        return info;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public Double getKilometraje() {
        return this.kilometraje;
    }

    public Boolean isAlquilado() {
        return this.isAlquilado;
    }
}
