package ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaVehiculos {

    public static final double KILOMETRAJE = 156.47;
    private ArrayList<Vehiculo> listaVehiculos;

    public ListaVehiculos() {
        this.listaVehiculos = new ArrayList<>();
    }

    public void darAltaVehiculo() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe la matrícula del vehículo");
        String matricula = scanner.nextLine();

        System.out.println("¿Qué tipo vehículo es? Coche, Moto o Furgoneta");
        String tipoVehiculo = scanner.nextLine();

        Vehiculo vehiculo = darAlta(matricula, tipoVehiculo);

        this.listaVehiculos.add(vehiculo);
    }

    public Vehiculo getVehiculoFromLista(int index) {
        return this.listaVehiculos.get(index);
    }

    private Vehiculo darAlta(String matricula, String tipoVehiculo) {

        Vehiculo vehiculo = null;

        if (tipoVehiculo.equalsIgnoreCase("coche")) {

            vehiculo = darAltaCoche(matricula);

        } else if (tipoVehiculo.equalsIgnoreCase("moto")) {

            vehiculo = darAltaMoto(matricula);

        } else if (tipoVehiculo.equalsIgnoreCase("furgoneta")) {

            vehiculo = darAltaFurgoneta(matricula);
        }
        return vehiculo;
    }

    private Vehiculo darAltaFurgoneta(String matricula) {
        System.out.println("¿Capacidad de carga de la furgoneta?");
        Scanner scanner = new Scanner(System.in);
        Double capacidadDeCarga = scanner.nextDouble();

        return new Furgoneta(matricula, KILOMETRAJE, false, capacidadDeCarga);
    }

    private Vehiculo darAltaMoto(String matricula) {
        System.out.println("¿La moto incluye casco?");
        Scanner scanner = new Scanner(System.in);
        String repuesta = scanner.nextLine();

        Boolean tieneCasco = false;

        if (repuesta.equalsIgnoreCase("si")) {
            tieneCasco = true;
        }

        return new Moto(matricula, KILOMETRAJE, false, tieneCasco);
    }

    private Vehiculo darAltaCoche(String matricula) {
        System.out.println("¿El coche tiene extras?");
        Scanner scanner = new Scanner(System.in);
        String repuesta = scanner.nextLine();

        Boolean tieneExtras = false;

        if (repuesta.equalsIgnoreCase("si")) {
            tieneExtras = true;
        }

        return new Coche(matricula, KILOMETRAJE, false, tieneExtras);
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
}
