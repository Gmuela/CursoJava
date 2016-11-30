package ejercicio2ArrayList;

public class Viaje {

    public String origen;
    public String destino;
    public double distancia;

    public Viaje() {
    }

    public Viaje(String origen, String destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Viaje uneViaje(Viaje viaje){

        Viaje escala = new Viaje();

        if(compruebaOrigenDestino(viaje)){
            escala.setOrigen(this.getOrigen());
            escala.setDestino(viaje.getDestino());
            double resultadoDistancia = sumaDistancias(viaje);
            escala.setDistancia(resultadoDistancia);
        } else{
            escala.setOrigen(null);
            escala.setDestino(null);
            escala.setDistancia(-1);
        }

        return escala;
    }

    private double sumaDistancias(Viaje viaje) {

        return viaje.getDistancia() + this.getDistancia();

    }

    private boolean compruebaOrigenDestino(Viaje viaje) {

        boolean esOrigenIgualDestino = false;

        String origen = viaje.getOrigen();
        String destino = this.getDestino();

        if(destino.equalsIgnoreCase(origen)){
            esOrigenIgualDestino = true;
        }

        return esOrigenIgualDestino;
    }

    public String toString() {
        String info = "";

        info += "Origen: " +this.getOrigen() + " | Destino: " + this.getDestino() + " | Distancia: " + this.getDistancia();

        return info;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
