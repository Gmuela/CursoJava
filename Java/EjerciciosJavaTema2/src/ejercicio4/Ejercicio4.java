package ejercicio4;

public class Ejercicio4 {
    public static void main(String[] args) {

        Integer maxSerie = Integer.parseInt(args[0]);

        Integer fibbo;
        Integer guardaUno = 1;
        Integer guardaDos = 1;

        for (int i = 1; i <= maxSerie; i++) {

            fibbo = guardaUno;
            guardaUno = guardaDos;
            guardaDos = fibbo + guardaUno;

            System.out.print(fibbo + " ");
        }
    }
}
