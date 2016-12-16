package Ejercicios.CienMetro;

public class Pistoletazo {

    private static Pistoletazo pistoletazo = new Pistoletazo();

    synchronized void esperar() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void bang() {
        notifyAll();
    }

    public static Pistoletazo getPistoletazo() {
        return pistoletazo;
    }
}
