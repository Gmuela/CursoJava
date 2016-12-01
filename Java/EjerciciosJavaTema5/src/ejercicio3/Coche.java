package ejercicio3;

public class Coche extends Vehiculo {

    private final Double PRECIO_POR_KILOMETRO = 0.4;
    private final Integer PRECIO_CON_EXTRAS = 20;
    private Boolean tieneExtras;

    public Coche(String matricula, Double kilometraje, Boolean isAlquilado, Boolean tieneExtras) {
        super(matricula, kilometraje, isAlquilado);
        this.tieneExtras = tieneExtras;
    }

    public Boolean getTieneExtras() {
        return tieneExtras;
    }
}
