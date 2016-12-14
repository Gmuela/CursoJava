package Views;

import AgendaClasses.Agenda;
import AgendaClasses.Fecha;
import IOClasses.Teclado;

import java.util.Scanner;

public class Menu {

    private Agenda agenda;
    private Teclado teclado = new Teclado();

    public Menu() {
        this.agenda = new Agenda();
    }

    private final String OPTION_ADD = "1.Añadir Persona";
    private final String OPTION_DELETE = "2.Borrar Persona(Buscar por DNI)";
    private final String OPTION_SEARCH = "3.Buscar Persona(Buscar por DNI)";
    private final String OPTION_SHOW_AGENDA = "4.Mostrar agenda";
    private final String OPTION_SHOW_BIRTHDAYS = "5.Mostrar Cumpleaños";
    private final String OPTION_EXIT = "0.Escribe cualquier otro número para salir";

    public String mostrarMenu() {

        String menu;

        String separador = "\n";

        menu = OPTION_ADD +
                separador +
                OPTION_DELETE +
                separador +
                OPTION_SEARCH +
                separador +
                OPTION_SHOW_AGENDA +
                separador +
                OPTION_SHOW_BIRTHDAYS +
                separador +
                OPTION_EXIT;

        return menu;

    }

    public boolean seleccionarOpcion(int opcion) {

        boolean finished = false;

        switch (opcion) {
            case 1:
               this.optionAdd();
                break;
            case 2:
                this.optionDelete();
                break;
            case 3:
                this.optionSearch();
                break;
            case 4:
                this.optionList();
                break;
            case 5:
                this.optionListBirthdays();
                break;
            default:
                finished = true;
        }

        return finished;
    }

    public void optionAdd() {

        System.out.println("Escribe el nombre");
        String nombre = teclado.leerCadena();

        System.out.println("Escribe los apellidos");
        String apellidos = teclado.leerCadena();

        System.out.println("Escribe el dni");
        String dni = teclado.leerCadena();

        System.out.println("Escribe la fecha de nacimiento");
        String stringFecha = teclado.leerCadena();
        Fecha fecha = new Fecha(stringFecha);

        System.out.println("Escribe el teléfono");
        String telefono = teclado.leerCadena();

        agenda.insertarPersona(nombre, apellidos, dni, fecha, telefono);
    }

    public void optionSearch() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el DNI de la persona que deseas buscar");
        String dni = scanner.nextLine();

        String informacionPersona = agenda.buscarPersona(dni);

        System.out.println(informacionPersona);
    }

    public void optionDelete() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el DNI de la persona que deseas buscar");
        String dni = scanner.nextLine();

        agenda.borrarPersona(dni);
    }

    public void optionList() {
        agenda.listarPersonas();
    }

    public void optionListBirthdays() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el mes del cumpleaños de la persona");
        String mes = scanner.nextLine();

        agenda.listarCumpleanios(mes);
    }
}
