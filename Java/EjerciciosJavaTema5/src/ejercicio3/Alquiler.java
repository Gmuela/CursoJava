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
        return vehiculo.getKilometraje() * vehiculo.getPrecioPorKilometro();
    }

}
