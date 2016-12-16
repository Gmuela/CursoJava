package Ejercicios.CienMetro;

import java.util.Calendar;
import java.util.Random;

public class CorredorCienMetros implements Runnable {

    private String nombre;
    private int dorsal;
    private double tiempo;
    private Pistoletazo pistoletazo;

    public CorredorCienMetros(String nombre, int dorsal) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.pistoletazo = Pistoletazo.getPistoletazo();
    }

    @Override
    public void run() {
        Random random = new Random();
        int tiempo = random.nextInt((12000 - 9000) + 1) + 9000;

        try {
            esperarPistoletazo();
            correr(tiempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void esperarPistoletazo() {
        System.out.println(this.nombre + " está esperando");
        pistoletazo.esperar();
    }

    private void correr(int tiempo) throws InterruptedException {
        double inicio = Calendar.getInstance().getTimeInMillis();
        if (this.nombre.equalsIgnoreCase("tu padre")) {
            System.out.println("¡" + this.nombre + " sale corriendo como un cabrón!");
        } else {
            System.out.println("¡" + this.nombre + " sale corriendo!");
        }

        Thread.sleep(tiempo);

        double fin = Calendar.getInstance().getTimeInMillis();
        this.tiempo = (fin - inicio) / 1000;

        System.out.println(this.nombre + " con dorsal " + this.dorsal + " ha tardado " + this.tiempo + " segundos");

    }

    public double getTiempo() {
        return tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDorsal() {
        return dorsal;
    }
}
