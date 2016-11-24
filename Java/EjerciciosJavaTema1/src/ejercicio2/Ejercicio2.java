package ejercicio2;

public class Ejercicio2 {

    private static final Float GRAVEDAD_DE_LA_TIERRA = 9.8F;
    private static final Float GRAVEDAD_DE_LA_LUNA = (GRAVEDAD_DE_LA_TIERRA*17/100);

    public static void main(String[] args){
        Float masa = Float.parseFloat(args[0])/GRAVEDAD_DE_LA_TIERRA;
        System.out.println(masa * GRAVEDAD_DE_LA_LUNA);
    }
}
