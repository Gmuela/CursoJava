package Ejercicios.Testigos;

public class Testigo {

    private static Testigo testigo = new Testigo();

    private double tiempoTotal = 0;

    synchronized void esperar() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void dar() {
        notify();
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    public void sumar(double time){
        this.tiempoTotal += time;
    }

    public static Testigo getTestigo() {
        return testigo;
    }
}
