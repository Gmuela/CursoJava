package ejercicio3;

public class Moto extends Vehiculo {

    private final Double PRECIO_POR_KILOMETRO = 0.6;
    private final Integer PRECIO_CASCO_INCLUIDO = 10;

    public Moto(String matricula, Double kilometraje, Boolean isAlquilado, Boolean incluyeCasco) {
        super(matricula, kilometraje, isAlquilado, incluyeCasco);
    }

    public Integer getPrecioSuplemento() {
        return PRECIO_CASCO_INCLUIDO;
    }

    public Double getPrecioPorKilometro() {
        return PRECIO_POR_KILOMETRO;
    }
}
