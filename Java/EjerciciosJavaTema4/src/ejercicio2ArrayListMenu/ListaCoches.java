package ejercicio2ArrayListMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaCoches extends Object {

    private ArrayList<Coche> coches;

    public ListaCoches() {
        this.coches = new ArrayList<>();

        addCoches();
    }

    private void addCoches() {
        Coche coche1 = new Coche("0000AAA", "Opel", "Astra", 20000);
        Coche coche2 = new Coche("0000BBB", "Mercedes", "SLK", 63000);
        Coche coche3 = new Coche("0000CCC", "Citroen", "Berlingo", 145000);
        Coche coche4 = new Coche("0000DDD", "Fiat", "Panda", 101000);
        Coche coche5 = new Coche("0000EEE", "Porsche", "Cayenne", 45000);

        this.coches.add(coche1);
        this.coches.add(coche2);
        this.coches.add(coche3);
        this.coches.add(coche4);
        this.coches.add(coche5);
    }

    public void listarCoches() {
        for (Coche coche : this.coches) {
            System.out.println(coche.toString());
        }
    }

    public void listarCochesDeMarca() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe la marca de los coches que deseas buscar");
        String marca = scanner.nextLine();

        for (Coche coche : this.coches) {
            String marcaCoche = coche.getMarca();
            if (marcaCoche.equalsIgnoreCase(marca)) {
                System.out.println(coche.toString());
            }
        }
    }

    public void listarCochesConMenosDe() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el mínimo de kilómetros de los coches que deseas buscar");
        int kilometros = scanner.nextInt();

        for (Coche coche : this.coches) {
            int cocheKilometros = coche.getKilometros();
            if (cocheKilometros >= (kilometros)) {
                System.out.println(coche.toString());
            }
        }
    }

    public void verCocheConMayorKilometros() {
        int kilometros = 0;
        Coche cocheConMayorKilometros = new Coche();

        for (Coche coche : this.coches) {
            int cocheKilometros = coche.getKilometros();
            if (cocheKilometros > (kilometros)) {
                cocheConMayorKilometros = coche;
                kilometros = cocheKilometros;
            }
        }

        System.out.println(cocheConMayorKilometros.toString());
    }

    public void listarCochesOrdenadosPorKilometros() {

        //TODO por alguien que tenga más paciencia
        System.out.println("Me duele la puta cabeza y paso de hacerlo");

    }
}
