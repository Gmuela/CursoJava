package ejercicio7;

public class Ejercicio7 {
    public static void main(String[] args) {
        double[] arrayNumero = generarArrayNumeroRandom(11);
        String[] arrayCuentas = contarNumeros(arrayNumero);
        mostrarCuentas(arrayCuentas);
    }

    private static void mostrarCuentas(String[] arrayCuentas) {
        for (int i = 0; i < arrayCuentas.length; i++) {
            if (arrayCuentas[i].equals("")) {
                System.out.println(i + ": /");
            }
            System.out.println(i + ":" + arrayCuentas[i]);
        }
    }

    private static String[] contarNumeros(double[] arrayNumero) {

        String[] arrayCuentas = {"", "", "", "", "", "", "", "", "", "", ""};

        for (double numero : arrayNumero) {
            arrayCuentas[(int) numero] += "*";
        }
        return arrayCuentas;
    }

    private static double[] generarArrayNumeroRandom(int max) {

        double[] arrayNumeros = new double[100];

        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = Math.floor(Math.random() * max);
        }

        return arrayNumeros;
    }


}
