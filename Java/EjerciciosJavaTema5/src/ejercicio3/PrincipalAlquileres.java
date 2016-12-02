package ejercicio3;

import java.util.ArrayList;

public class PrincipalAlquileres {

    public static void main(String[] args){
        ListaVehiculos listaVehiculos = new ListaVehiculos();
        Alquiler alquiler = new Alquiler();
        ArrayList<Vehiculo> lista= listaVehiculos.getListaVehiculos();

        listaVehiculos.darAltaVehiculo();
        Vehiculo vehiculo = listaVehiculos.getVehiculoFromLista(0);

        System.out.println("===========Vehículo alquilado==============");
        alquiler.alquilarVehiculo(vehiculo);

        for (Vehiculo veh : lista) {
            System.out.println(veh.toString());
        }
        System.out.println("===========Vehículo devuelto==============");
        alquiler.devolverVehiculo(vehiculo);



        Double importe = alquiler.calcularImporteAlquiler(vehiculo);

        if(vehiculo.tieneSuplemento()){

            System.out.println("El importe total del vehículo son: "+importe+"€ ("+vehiculo.getPrecioSuplemento()+"€ incluidos)");
        }

        else{
            System.out.println("El importe total del vehículo son: "+importe+"€");
        }


        for (Vehiculo veh : lista) {
            System.out.println(veh.toString());
        }

    }

}
