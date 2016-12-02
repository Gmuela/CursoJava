package ejercicio5;

import ejercicio5.intrumentos.Flauta;
import ejercicio5.intrumentos.Timbal;
import ejercicio5.intrumentos.Violin;

import java.util.ArrayList;

public class Auditorio {

    public static void main(String[] args){
        Instrumento flauta = new Flauta("flauta");
        Instrumento timbal = new Timbal("timbal");
        Instrumento violin = new Violin("violin");

        System.out.println(Orquesta.afinarLa440(flauta));
        System.out.println(Orquesta.afinarLa440(timbal));
        System.out.println(Orquesta.afinarLa440(violin));

        System.out.println(Orquesta.empezarConcierto());

        ArrayList<Instrumento> instrumentos = new ArrayList<>();

        instrumentos.add(flauta);
        instrumentos.add(timbal);
        instrumentos.add(violin);

        Orquesta orquesta = new Orquesta();
        orquesta.concierto(instrumentos);

    }
}
