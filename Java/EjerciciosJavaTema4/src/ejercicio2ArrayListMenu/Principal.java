package ejercicio2ArrayListMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args){

        Menu menu = new Menu();

        boolean finished;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Elige una opción:");
            System.out.println(menu.mostrarMenu());
            int opcion = scanner.nextInt();
            finished = menu.seleccionarOpcion(opcion);

        } while(!finished);


    }

}
