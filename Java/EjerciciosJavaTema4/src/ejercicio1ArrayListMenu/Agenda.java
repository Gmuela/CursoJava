package ejercicio1ArrayListMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    private static ArrayList<Persona> contactos = new ArrayList<Persona>();

    public static ArrayList<Persona> getContactos() {

        return contactos;
    }


    public static void addPersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el nombre");
        String nombre  = scanner.nextLine();

        System.out.println("Escribe los apellidos");
        String apellidos  = scanner.nextLine();

        System.out.println("Escribe el dni");
        String dni  = scanner.nextLine();

        System.out.println("Escribe la fecha de nacimiento");
        String stringFecha  = scanner.nextLine();
        Fecha fecha = new Fecha(stringFecha);

        System.out.println("Escribe el teléfono");
        String telefono  = scanner.nextLine();

        Persona personaNueva = new Persona(nombre,apellidos,dni,fecha,telefono);

        contactos.add(personaNueva);
    }

    public static void searchPersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el DNI de la persona que deseas buscar");
        String dni = scanner.nextLine();

        for (Persona contacto : contactos) {
            String contactoDni = contacto.getDni();
            if (contactoDni.equalsIgnoreCase(dni)) {
                System.out.println(contacto.toString());
            }
        }
    }

    public static void deletePersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el DNI de la persona que deseas buscar");
        String dni = scanner.nextLine();

        for (Persona contacto : contactos) {
            String contactoDni = contacto.getDni();
            if (contactoDni.equalsIgnoreCase(dni)) {
                contactos.remove(contacto);
            }
        }
    }

    public static void showAgenda() {
        for (Persona contacto : contactos) {
            System.out.println(contacto.toString());
        }
    }

    public static void showBirthdays() {

    }
}
