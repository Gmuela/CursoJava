package Ejercicios.Testigos;

import Ejercicios.Carrera;

public class CarreraTestigos implements Carrera {

    private static Testigo testigo = Testigo.getTestigo();
    private static Thread thread1;
    private static Thread thread2;
    private static Thread thread3;
    private static Thread thread4;

    public static void main(String[] args) {

        Carrera carrera = new CarreraTestigos();

        carrera.traerAtletas();
        carrera.megafonia("¡En sus marcas!", 1000);
        carrera.posicionarAtletas();
        carrera.megafonia("¡Listos!", 1000);
        carrera.prepararAtletas();
        carrera.megafonia("¡Ya!", 100);
        carrera.empezarCarrera();

        System.out.println("Tiempo total de la carrera: "+testigo.getTiempoTotal()+" segundos");
    }

    public void traerAtletas() {
        CorredorTestigos corredorTestigosNum1 = new CorredorTestigos("Pepe",1);
        CorredorTestigos corredorTestigosNum2 = new CorredorTestigos("Kevin", 2);
        CorredorTestigos corredorTestigosNum3 = new CorredorTestigos("Carlos", 3);
        CorredorTestigos corredorTestigosNum4 = new CorredorTestigos("Paco",4);

        thread1 = new Thread(corredorTestigosNum1);
        thread2 = new Thread(corredorTestigosNum2);
        thread3 = new Thread(corredorTestigosNum3);
        thread4 = new Thread(corredorTestigosNum4);
    }

    public void posicionarAtletas() {
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public void prepararAtletas() {
        testigo.dar();
    }

    @Override
    public void empezarCarrera() {
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
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
