package ejercicio3;

public class Ejercicio3 {

    private static final Float EQUIVALENCIA_GALONES_LITROS = 3.7854F;

    public static void main(String[] args) {
        Float galones = Float.parseFloat(args[0]);
        System.out.println(galones * EQUIVALENCIA_GALONES_LITROS);
    }
}
