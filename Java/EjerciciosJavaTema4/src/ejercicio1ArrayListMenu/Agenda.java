package ejercicio1ArrayListMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    private ArrayList<Persona> contactos = new ArrayList<Persona>();

    public ArrayList<Persona> getContactos() {

        return this.contactos;
    }


    public void addPersona() {
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

        this.contactos.add(personaNueva);
    }

    public void searchPersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el DNI de la persona que deseas buscar");
        String dni = scanner.nextLine();

        for (Persona contacto : this.contactos) {
            String contactoDni = contacto.getDni();
            if (contactoDni.equalsIgnoreCase(dni)) {
                System.out.println(contacto.toString());
            }
        }
    }

    public void deletePersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el DNI de la persona que deseas buscar");
        String dni = scanner.nextLine();

        Persona pesonaToRemove = new Persona();

        for (Persona contacto : this.contactos) {
            String contactoDni = contacto.getDni();
            if (contactoDni.equalsIgnoreCase(dni)) {
                pesonaToRemove = contacto;
            }
        }

        contactos.remove(pesonaToRemove);
    }

    public void showAgenda() {
        for (Persona contacto : this.contactos) {
            System.out.println(contacto.toString());
        }
    }

    public void showBirthdays() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el mes del cumpleaños de la persona");
        String mes = scanner.nextLine();

        for (Persona contacto : this.contactos) {
            Fecha fechaNacimiento = contacto.getFechaNacimiento();
            String contactoMes = fechaNacimiento.getMes();
            if (contactoMes.equalsIgnoreCase(mes)) {
                System.out.println(contacto.toString());
            }
        }
    }
}
