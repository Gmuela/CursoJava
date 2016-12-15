package IOClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {

    private BufferedReader entrada;

    public Teclado() {
        InputStreamReader input = new InputStreamReader(System.in);
        this.entrada = new BufferedReader(input);
    }

    public String leerCadena() {
        String cadena = "";
        try {
            cadena = this.entrada.readLine();
        } catch (IOException e) {
            System.out.println("Error de I/O");
        }
        return cadena;
    }

    public Integer leerInt() {
        Integer integer = null;
        try {
            System.out.println("Escribe un número entero");
            integer = Integer.parseInt(this.entrada.readLine());
        } catch (IOException e) {
            System.out.println("Error de I/O");
        }
        return integer;
    }

    public Double leerDouble() {
        Double aDouble = null;
        try {
            System.out.println("Escribe un número con decimal");
            aDouble = Double.parseDouble(this.entrada.readLine());
        } catch (IOException e) {
            System.out.println("Error de I/O");
        }
        return aDouble;
    }

}
