package ejercicio1;

public class Ejercicio1 {

    private static final Integer CUATRO = 4;
    private static final Integer CUATROCIENTOS = 400;
    private static final Integer CIEN = 100;

    public static void main(String[] args) {

        comprobarAniosBisiestos(args[0]);
    }

    private static void comprobarAniosBisiestos(String arg) {

        Integer anio = Integer.parseInt(arg);

        if (isMultiploDeCuatro(anio)) {

            if (isMultiploDeCien(anio)) {
                if (isMultiploDeCuatrocientos(anio)) {

                    esBisiesto(anio);
                } else {

                    noEsBisiesto(anio);
                }
            } else {

                esBisiesto(anio);
            }
        } else {

            noEsBisiesto(anio);
        }
    }

    private static void noEsBisiesto(Integer anio) {

        System.out.println("El año " + anio + " no es bisiesto");
    }

    private static void esBisiesto(Integer anio) {

        System.out.println("El año " + anio + " es bisiesto");
    }

    private static Boolean isMultiploDeCuatro(Integer anio) {

        Boolean isMultiplo = false;

        if (anio % CUATRO == 0) {
            isMultiplo = true;
        }

        return isMultiplo;
    }

    private static Boolean isMultiploDeCuatrocientos(Integer anio) {

        Boolean isMultiplo = false;

        if (anio % CUATROCIENTOS == 0) {
            isMultiplo = true;
        }

        return isMultiplo;
    }

    private static Boolean isMultiploDeCien(Integer anio) {

        Boolean isMultiplo = false;

        if (anio % CIEN == 0) {
            isMultiplo = true;
        }

        return isMultiplo;
    }

}
