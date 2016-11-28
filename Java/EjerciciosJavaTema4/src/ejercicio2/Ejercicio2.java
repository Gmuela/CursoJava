package ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args){
        Integer[] arrayNumeros = new Integer[100];
        for (int i = 0 ; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = i+1;
        }

        for (int i = 0; i < arrayNumeros.length; i++) {
            System.out.println(arrayNumeros[i]);
        }
    }
}
