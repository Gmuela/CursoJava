package ejercicio1ArrayListMenu;

public class Menu {

    private Agenda agenda;

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
                agenda.addPersona();
                break;
            case 2:
                agenda.deletePersona();
                break;
            case 3:
                agenda.searchPersona();
                break;
            case 4:
                agenda.showAgenda();
                break;
            case 5:
                agenda.showBirthdays();
                break;
            default:
                finished = true;
        }

        return finished;
    }

}
