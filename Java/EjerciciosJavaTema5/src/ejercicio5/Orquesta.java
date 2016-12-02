package ejercicio5;

import java.util.ArrayList;

public class Orquesta {
    public static String afinarLa440(Instrumento intrumento) {
        return "Afinando..." + intrumento.tocar() + " " + intrumento.getNombre();
    }

    public static String empezarConcierto() {
        return "EMPEZAMOS EL CONCIERTO";
    }

    public void concierto(ArrayList<Instrumento> instrumentos) {
        for (Instrumento instrumento : instrumentos) {
            System.out.println(instrumento.tocar() + " " + instrumento.getNombre());
        }
    }
}
