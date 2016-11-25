package ejercicio2;

public class Ejercicio2 {

    private static final Integer CUATRO = 4;
    private static final Integer CUATROCIENTOS = 400;
    private static final Integer CIEN = 100;

    public static void main(String[] args) {
        Integer dia = Integer.parseInt(args[0]);
        Integer mes = Integer.parseInt(args[1]);
        Integer anio = Integer.parseInt(args[2]);

        if (fechaEsCorrecta(anio, mes, dia)) {

            dia += 1;

            if (mesTieneTreinta(mes + 1)) {
                if (dia > 30) {
                    dia = 1;
                    mes += 1;
                    if (mes > 12) {
                        mes = 1;
                        anio += 1;
                    }
                }
            } else {
                if (dia > 31) {
                    dia = 1;
                    mes += 1;
                    if (mes > 12) {
                        mes = 1;
                        anio += 1;
                    }
                }
            }

            System.out.println("El día siguiente es el " + dia + " del " + mes + " de " + anio);

        } else {
            System.out.println("Introduce una fecha correcta");
        }
    }

    private static boolean fechaEsCorrecta(Integer anio, Integer mes, Integer dia) {

        Boolean esCorrecta = false;

        Boolean isBisiesto = comprobarAniosBisiestos(anio);

        if (mesEsCorrecto(mes) && anioEsCorrecto(anio)) {
            if (esFebrero(mes)) {

                if (isBisiesto) {

                    if (esFebreroCorrectoEnBisiesto(mes, dia)) {
                        esCorrecta = true;
                    }
                } else {

                    if (esFebreroCorrecto(mes, dia)) {
                        esCorrecta = true;
                    }
                }
            }

            if (mesTieneTreintaiuno(mes)) {
                if (comprobarDiaTreintaiuno(dia)) {
                    esCorrecta = true;
                }
            } else {
                if (mesTieneTreinta(mes)) {
                    if (comprobarDiaTreinta(dia)) {
                        esCorrecta = true;
                    }
                }
            }
        }

        return esCorrecta;
    }

    private static boolean comprobarDiaTreinta(Integer dia) {
        return dia > 0 && dia <= 30;
    }

    private static boolean comprobarDiaTreintaiuno(Integer dia) {
        return dia > 0 && dia <= 31;
    }

    private static boolean mesTieneTreinta(Integer mes) {
        return mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11;
    }

    private static boolean mesTieneTreintaiuno(Integer mes) {
        return mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12;
    }

    private static boolean esFebrero(Integer mes) {
        return mes == 2;
    }

    private static boolean esFebreroCorrecto(Integer mes, Integer dia) {
        return mes == 2 && dia <= 28;
    }

    private static boolean esFebreroCorrectoEnBisiesto(Integer mes, Integer dia) {
        return mes == 2 && dia <= 29;
    }

    private static boolean anioEsCorrecto(Integer anio) {
        return anio > 0;
    }

    private static boolean mesEsCorrecto(Integer mes) {
        return mes >= 1 || mes <= 12;
    }

    private static Boolean comprobarAniosBisiestos(Integer anio) {

        Boolean isBisiesto = false;

        if (isMultiploDeCuatro(anio)) {

            if (isMultiploDeCien(anio)) {
                if (isMultiploDeCuatrocientos(anio)) {

                    isBisiesto = esBisiesto();
                } else {

                    isBisiesto = noEsBisiesto();
                }
            } else {

                isBisiesto = esBisiesto();
            }
        } else {

            isBisiesto = noEsBisiesto();
        }

        return isBisiesto;
    }

    private static Boolean noEsBisiesto() {

        return false;
    }

    private static Boolean esBisiesto() {

        return true;
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
