package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        double[] arrayNumeros = new double[10];

        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = Math.floor(Math.random() * 100);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige la posición del 0 al 10 que deseas ver");
        int posicion = scanner.nextInt();

        try {

            System.out.println("El número de la posición " + posicion + " es " + arrayNumeros[posicion]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("La posición indicada no existe");
        }
    }
}
