package Ejercicios.Testigos;

import java.util.Calendar;
import java.util.Random;

public class CorredorTestigos implements Runnable {

    private String nombre;
    private int dorsal;
    private Testigo testigo;

    private double tiempo;

    public CorredorTestigos(String nombre, int dorsal) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.testigo = Testigo.getTestigo();
    }

    @Override
    public void run() {
        Random random = new Random();
        int tiempo = random.nextInt((11000 - 9000) + 1) + 9000;

        try {
            esperar();
            correr(tiempo);
            testigo.dar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void esperar() {
        System.out.println (this.nombre + " está esperando" );
        testigo.esperar();
    }

    private void correr(int tiempo) throws InterruptedException {
        double inicio = Calendar.getInstance().getTimeInMillis();
        System.out.println (this.nombre + " ha recibido el testigo. ¡Sale corriendo!");
        Thread.sleep(tiempo);
        double fin = Calendar.getInstance().getTimeInMillis();
        this.tiempo = (fin - inicio)/1000;
        System.out.println(this.nombre + " ha tardado " + this.tiempo + " segundos");
        testigo.sumar(this.tiempo);
    }
}
