package ejercicio3;

public class PrincipalAlquileres {

    public static void main(String[] args){
        ListaVehiculos listaVehiculos = new ListaVehiculos();
        Alquiler alquiler = new Alquiler();

        listaVehiculos.darAltaVehiculo();
        Vehiculo vehiculo = listaVehiculos.getVehiculoFromLista(0);
        alquiler.alquilarVehiculo(vehiculo);
        alquiler.devolverVehiculo(vehiculo);
        Double importe = alquiler.calcularImporteAlquiler(vehiculo);

    }

}
