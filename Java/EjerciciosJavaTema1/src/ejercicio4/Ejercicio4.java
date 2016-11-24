package ejercicio4;

public class Ejercicio4 {

    private static final Float EQUIVALENCIA_PIES_PULGADAS = 12F;
    private static final Float EQUIVALENCIA_PULGADAS_CM = 2.54F;
    private static final Float EQUIVALENCIA_YARDAS_CM = 91.44F;

    public static void main(String[] args) {

        try {
            Float pies = Float.parseFloat(args[0]);
            hacerCalculos(pies);

        } catch (NumberFormatException e) {
            System.out.println("Eso no es un número");
        }



    }

    private static void hacerCalculos(Float pies) {
        System.out.println("Pies: " + pies);

        Float pulgadas = pies * EQUIVALENCIA_PIES_PULGADAS;
        System.out.println("Pulgadas: " + pulgadas);

        Float centimetros = pulgadas * EQUIVALENCIA_PULGADAS_CM;
        System.out.println("Centímetros: " + centimetros);

        Float metros = centimetros / 100;
        System.out.println("Metros: " + metros);

        Float yardas = centimetros / EQUIVALENCIA_YARDAS_CM;
        System.out.println("Yardas: " + yardas);
    }


}
