package ejercicio3;

public class Furgoneta extends Vehiculo {

    private final Double PRECIO_POR_KILOMETRO = 0.5;
    private Double capacidadDeCarga;

    public Furgoneta(String matricula, Double kilometraje, Boolean isAlquilado, Double capacidadDeCarga) {
        super(matricula, kilometraje, isAlquilado);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    public Double getCapacidadDeCarga() {
        return capacidadDeCarga;
    }
}
