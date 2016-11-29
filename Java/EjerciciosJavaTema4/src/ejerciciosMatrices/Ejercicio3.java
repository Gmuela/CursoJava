package ejerciciosMatrices;

public class Ejercicio3 {
    public int[][] matrizEnteros = {
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, -3, 6},
            {1, 2, 14, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 8, 5, 6},
            {1, -5, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6}
    };

    int maximo = buscaMaximo(matrizEnteros);

    int minimo = buscaMinimo(matrizEnteros);

    public static void main(String[] args) {
        Ejercicio3 ej3 = new Ejercicio3();
        System.out.println("El máximo es: " + ej3.maximo);
        System.out.println("El mínimo es: " + ej3.minimo);

    }


    private int buscaMaximo(int[][] matrizEnteros) {

        int maximo = 0;

        for (int[] arrayEnteros : matrizEnteros) {
            for (int numero : arrayEnteros) {
                if (maximo < numero) {
                    maximo = numero;
                }
            }
        }

        return maximo;
    }

    private int buscaMinimo(int[][] matrizEnteros) {

        int minimo = 0;

        for (int[] arrayEnteros : matrizEnteros) {
            for (int numero : arrayEnteros) {
                if (minimo > numero) {
                    minimo = numero;
                }
            }
        }

        return minimo;
    }

}
