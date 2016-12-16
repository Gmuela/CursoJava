package Ejercicios.CienMetro;

import Ejercicios.Carrera;

import java.util.ArrayList;

public class CarreraCienMetros implements Carrera {

    private static Pistoletazo pistoletazo = Pistoletazo.getPistoletazo();

    private static Thread thread1;
    private static Thread thread2;
    private static Thread thread3;
    private static Thread thread4;
    private static Thread thread5;
    private static Thread thread6;
    private static Thread thread7;
    private static Thread thread8;
    ArrayList<CorredorCienMetros> corredores = new ArrayList<>();

    public static void main(String[] args) {

        CarreraCienMetros carrera = new CarreraCienMetros();

        carrera.traerAtletas();
        carrera.megafonia("¡En sus marcas!", 2000);
        carrera.posicionarAtletas();
        carrera.megafonia("¡Listos!", 2000);
        carrera.prepararAtletas();
        carrera.megafonia("¡Ya!", 500);
        carrera.empezarCarrera();
        System.out.println(carrera.elGanadorEs());
    }

    public String elGanadorEs() {
        double tiempoGanador = 20;
        CorredorCienMetros ganador = new CorredorCienMetros(null, 0);
        for (CorredorCienMetros corredor : corredores) {
            if (corredor.getTiempo() < tiempoGanador) {
                tiempoGanador = corredor.getTiempo();
                ganador = corredor;
            }
        }

        String mensaje;

        if (ganador.getNombre().equalsIgnoreCase("tu padre")) {
            mensaje = ganador.getNombre() + " se ha marcado un 'deal with it' tardando " + ganador.getTiempo() + " segundos. ¡El puto amo!";
        } else {
            mensaje = "El ganador ha sido " + ganador.getNombre() + " con el dorsal " + ganador.getDorsal() + " y tiempo de " + ganador.getTiempo();
        }
        return mensaje;
    }

    public void traerAtletas() {
        corredores.add(new CorredorCienMetros("Pepe", 1));
        corredores.add(new CorredorCienMetros("Paco", 2));
        corredores.add(new CorredorCienMetros("Luis", 3));
        corredores.add(new CorredorCienMetros("Kevin", 4));
        corredores.add(new CorredorCienMetros("Jorge", 5));
        corredores.add(new CorredorCienMetros("Carlos", 6));
        corredores.add(new CorredorCienMetros("Guillermo", 7));
        corredores.add(new CorredorCienMetros("Tu padre", 8));

        thread1 = new Thread(corredores.get(0));
        thread2 = new Thread(corredores.get(1));
        thread3 = new Thread(corredores.get(2));
        thread4 = new Thread(corredores.get(3));
        thread5 = new Thread(corredores.get(4));
        thread6 = new Thread(corredores.get(5));
        thread7 = new Thread(corredores.get(6));
        thread8 = new Thread(corredores.get(7));
    }

    public void posicionarAtletas() {
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
    }

    public void prepararAtletas() {
        pistoletazo.bang();
    }

    @Override
    public void empezarCarrera() {
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void megafonia(String mensaje, int tiempo) {
        System.out.println(mensaje);
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
