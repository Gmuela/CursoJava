package ejercicio3;

public class Alquiler {

    public void alquilarVehiculo(Vehiculo vehiculo){

        Boolean isAlquilado = true;

        if(vehiculo.isNotAlquilado()){
            vehiculo.setAlquilado(isAlquilado);
        }
    }

    public void devolverVehiculo(Vehiculo vehiculo){

        Boolean isAlquilado = false;

        if(vehiculo.isAlquilado()){
            vehiculo.setAlquilado(isAlquilado);
        }
    }

    public Double calcularImporteAlquiler(Vehiculo vehiculo){
        double precio = vehiculo.getKilometraje() * vehiculo.getPrecioPorKilometro();
        if(vehiculo.tieneSuplemento()){
            precio += vehiculo.getPrecioSuplemento();
        }
        return precio;
    }

}
