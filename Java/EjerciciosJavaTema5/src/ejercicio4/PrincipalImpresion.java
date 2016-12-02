package ejercicio4;

import java.util.ArrayList;

public class PrincipalImpresion {

    public static void main(String[] args){

        ArrayList<Impresion> lista = new ArrayList<>();

        Impresion impresionPositiva = new Positivo();
        Impresion impresionNegativa = new Negativo();

        lista.add(impresionPositiva);
        lista.add(impresionNegativa);

        for (Impresion impresion : lista) {
            System.out.println(impresion.imprimir());
        }
    }
}
