package PrimerosEjercicios;

import java.io.IOException;
import java.util.Scanner;

public class MiClase {

    private String msg;

    private Integer numero;
    private static final String[] ARRAY_OPERACIONES = new String[]{"suma", "resta", "multiplicacion", "division", "exponente"};

    public MiClase(String msg, Integer numero) {
        this.msg = msg;
        this.numero = numero;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe un número: ");
        Integer numero = scanner.nextInt();

        MiClase miObjeto = new MiClase("nena", numero);

        System.out.println("Escribe otro número:");
        Integer operador = scanner.nextInt();

        imprimirResultados(operador, miObjeto.getNumero());
    }

    private static void imprimirResultados(Integer operador, Integer numero) {

        for (String operacion : ARRAY_OPERACIONES) {
            System.out.println(operacion + "(" + numero + " y " + operador + ") = " + hacerOperacion(operacion, numero, operador));
        }
    }

    public static Number hacerOperacion(String operando, Integer numero, Integer operador) {

        Number result = 0;

        if (operando.equalsIgnoreCase("multiplicacion")) {
            result = numero * operador;
        }

        if (operando.equalsIgnoreCase("suma")) {
            result = numero + operador;
        }

        if (operando.equalsIgnoreCase("resta")) {
            result = numero - operador;
        }

        if (operando.equalsIgnoreCase("division")) {
            result = numero / operador;
        }
        if (operando.equalsIgnoreCase("exponente")) {
            result = Math.pow(numero.doubleValue(),operador.doubleValue());
        }

        return result;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
