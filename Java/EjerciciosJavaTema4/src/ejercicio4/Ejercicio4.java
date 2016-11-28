package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el tamaño del array");
        int size = scanner.nextInt();

        int[] arrayNumeros = new int[size];

        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = (int)Math.floor(Math.random() * 300);
        }

        System.out.println("Lo números a guardar, ¿en qué dígito acaban?");
        int digit = scanner.nextInt();

        int[] arrayNumerosFiltrados = new int[arrayNumeros.length];

        for (int i = 0; i < arrayNumeros.length; i++) {
            if(arrayNumeros[i]%10 == digit){
                arrayNumerosFiltrados[i] = arrayNumeros[i];
            }
        }

        System.out.println("Array 1:");
        for (int numero:arrayNumeros) {
            System.out.print(numero+",");
        }

        System.out.println("\nArray 2:");
        for (int numero:arrayNumerosFiltrados) {
            if(numero !=0){
                System.out.print(numero+",");
            }
        }
    }
}
