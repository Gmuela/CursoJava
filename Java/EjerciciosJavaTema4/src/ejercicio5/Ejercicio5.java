package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args){
        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el DNI: ");
        String dni = scanner.nextLine();
        int dniNumero = Integer.parseInt(dni);
        System.out.println("Tu DNI: "+ dni+letras[dniNumero%23]);

    }

}
