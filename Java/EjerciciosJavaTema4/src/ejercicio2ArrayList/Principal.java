package ejercicio2ArrayList;

import java.util.ArrayList;

public class Principal {

    ArrayList<Viaje> viajes;

    public Principal(){
        this.viajes = crearViajes();
    }

    public static void main(String[] args){
        Principal principal = new Principal();
        ArrayList<Viaje> viajes = principal.getViajes();

        Viaje viajeFinal;

        try{

            for (int i = 0; i < viajes.size(); i++) {
                viajeFinal = viajes.get(i);
                Viaje nextViaje = viajes.get(i+1);
                viajeFinal = viajeFinal.uneViaje(nextViaje);
                System.out.println(viajeFinal.toString());
            }
        } catch (IndexOutOfBoundsException e){
        }

    }

    private ArrayList<Viaje> crearViajes() {

        ArrayList<Viaje> viajes = new ArrayList<>();

        Viaje viaje1 = new Viaje("Madrid", "Copacabana", 12567.9);
        Viaje viaje2 = new Viaje("Copacabana", "París", 13068.0);
        Viaje viaje3 = new Viaje("París", "Japón", 19890.0);
        Viaje viaje4 = new Viaje("Japón", "EEUU", 15999.8);
        Viaje viaje5 = new Viaje("EEUU", "Canadá", 15397.2);
        Viaje viaje6 = new Viaje("Canadá", "Miami", 10959.0);
        Viaje viaje7 = new Viaje("Miami", "Colombia", 5989.0);
        Viaje viaje8 = new Viaje("Colombia", "Oslo", 1009.0);
        Viaje viaje9 = new Viaje("Oslo", "Rusia", 10975.5);
        Viaje viaje10 = new Viaje("Rusia", "España", 199.8);

        viajes.add(viaje1);
        viajes.add(viaje2);
        viajes.add(viaje3);
        viajes.add(viaje4);
        viajes.add(viaje5);
        viajes.add(viaje6);
        viajes.add(viaje7);
        viajes.add(viaje8);
        viajes.add(viaje9);
        viajes.add(viaje10);

        return viajes;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }
}
