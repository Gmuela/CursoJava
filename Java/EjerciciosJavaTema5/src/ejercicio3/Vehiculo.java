package ejercicio3;

public class Vehiculo implements InterfazVehiculo {

    private Boolean tieneSuplemento;
    private String matricula;
    private Double kilometraje;
    private Boolean isAlquilado;
    private Double precioPorKilometro;
    private Integer precioSuplemento;

    public Vehiculo() {
        //Dafault
    }

    public Vehiculo(String matricula, Double kilometraje, Boolean isAlquilado, Boolean tieneSuplemento) {
        this.matricula = matricula;
        this.kilometraje = kilometraje;
        this.isAlquilado = isAlquilado;
        this.tieneSuplemento = tieneSuplemento;
        this.precioPorKilometro = 0.0;
        this.precioSuplemento = 0;
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
        return this.precioPorKilometro;
    }

    public Boolean isNotAlquilado() {
        return !this.isAlquilado;
    }

    public Boolean tieneSuplemento() {
        return tieneSuplemento;
    }


    public Integer getPrecioSuplemento() {
        return this.precioSuplemento;
    }

}
