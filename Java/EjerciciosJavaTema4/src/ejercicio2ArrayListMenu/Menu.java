package ejercicio2ArrayListMenu;

public class Menu {

    private ListaCoches listaCoches;

    public Menu() {
        this.listaCoches = new ListaCoches();
    }

    private final String OPTION_ADD = "1.Ver todos los coches";
    private final String OPTION_DELETE = "2.Ver todos los coches de una marca";
    private final String OPTION_SEARCH = "3.Ver todos los coches con más de X kilómetros";
    private final String OPTION_SHOW_AGENDA = "4.Ver el coche con mayor número de kilómetros";
    private final String OPTION_SHOW_BIRTHDAYS = "5.Ver todos los coches ordenados por número de kilómetros";
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
                listaCoches.listarCoches();
                break;
            case 2:
                listaCoches.listarCochesDeMarca();
                break;
            case 3:
                listaCoches.listarCochesConMenosDe();
                break;
            case 4:
                listaCoches.verCocheConMayorKilometros();
                break;
            case 5:
                listaCoches.listarCochesOrdenadosPorKilometros();
                break;
            default:
                finished = true;
        }

        return finished;
    }

}
