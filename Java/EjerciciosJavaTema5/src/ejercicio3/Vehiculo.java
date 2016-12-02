package ejercicio3;

public class Vehiculo implements InterfazVehiculo {

    protected Boolean extra;
    private String matricula;
    private Double kilometraje;
    private Boolean isAlquilado;
    private final Double PRECIO_POR_KILOMETRO = 0.0;

    public Vehiculo() {
        //Dafault
    }

    public Vehiculo(String matricula, Double kilometraje, Boolean isAlquilado, Boolean tieneExtra) {
        this.matricula = matricula;
        this.kilometraje = kilometraje;
        this.isAlquilado = isAlquilado;
        this.extra = tieneExtra;
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

    public void setAlquilado(Boolean alquilado) {
        isAlquilado = alquilado;
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

    public Double getPrecioPorKilometro() {
        return this.PRECIO_POR_KILOMETRO;
    }

    public Boolean isNotAlquilado() {
        return !this.isAlquilado;
    }

    public Boolean getExtra() {
        return extra;
    }
}
