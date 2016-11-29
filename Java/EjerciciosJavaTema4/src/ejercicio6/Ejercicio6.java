package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {
        String numero = pedirNumero();
        Boolean esCapicua = comprobarNumeroCapicua(numero);
        mostrarMensaje(esCapicua, numero);

    }

    private static void mostrarMensaje(Boolean esCapicua, String numero) {
        if (esCapicua) {
            System.out.println("El número " + numero + " es capicúa");
        } else {
            System.out.println("El número " + numero + " no es capicúa");
        }
    }

    private static Boolean comprobarNumeroCapicua(String numero) {
        Boolean esCapicua = true;
        char[] arrayNumeros = numero.toCharArray();
        int index = arrayNumeros.length-1;
        for (char arrayNumero : arrayNumeros) {
            if (arrayNumero != arrayNumeros[index]) {
                esCapicua = false;
            }
            index--;
        }
        return esCapicua;
    }

    private static String pedirNumero() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe un número:");

        return scanner.nextLine();
    }

}
