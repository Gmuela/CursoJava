package ejercicio1;

import java.util.IntSummaryStatistics;

public class Principal {

    public static void main(String[] args){

        Integer numerador1 = Integer.parseInt(args[0]);
        Integer denominador1 = Integer.parseInt(args[1]);

        Integer numerador2 = Integer.parseInt(args[2]);
        Integer denominador2 = Integer.parseInt(args[3]);

        Racional racional1 = new Racional(numerador1,denominador1);
        Racional racional2 = new Racional(numerador2, denominador2);

        Racional racionalSumado = racional1.suma(racional2);

        Racional racionalRestado = racional1.resta(racional2);

        Racional racionalMultiplicado = racional1.multiplicacion(racional2);

        Racional racionalDividido = racional1.division(racional2);

        Boolean mayorQue = racional1.mayorQue(racional2);

        String fraccionUno = racional1.getNumerador() + "/" + racional1.getDenominador();
        String fraccionDos = racional2.getNumerador() + "/" + racional2.getDenominador();

        String fraccionResultadoSuma = racionalSumado.getNumerador() + "/" + racionalSumado.getDenominador();
        String fraccionResultadoResta = racionalRestado.getNumerador() + "/" + racionalRestado.getDenominador();
        String fraccionResultadoMultiplicacion = racionalMultiplicado.getNumerador() + "/" + racionalMultiplicado.getDenominador();
        String fraccionResultadoDividido = racionalDividido.getNumerador() + "/" + racionalDividido.getDenominador();

        System.out.println("La suma de " + fraccionUno + " y " + fraccionDos + " es " + fraccionResultadoSuma);
        System.out.println("La resta de " + fraccionUno + " y " + fraccionDos + " es " + fraccionResultadoResta);
        System.out.println("La multiplicación de " + fraccionUno + " y " + fraccionDos + " es " + fraccionResultadoMultiplicacion);
        System.out.println("La división de " + fraccionUno + " y " + fraccionDos + " es " + fraccionResultadoDividido);
        if(mayorQue){

            System.out.println("La fracción " + fraccionUno + " es mayor que " + fraccionDos);
        }

        else{

            System.out.println("La fracción " + fraccionUno + " es menor que " + fraccionDos);
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");

        Polinomio polinomio = new Polinomio(2,3,5);
        polinomio.calcularValor((double)3);
        polinomio.escribir((double)3);

        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");

        Circulo circulo = new Circulo(3.012,-56.009,6.0);
        circulo.mostrarResultados();

        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");

        Punto inferiorIzquierdo = new Punto(4.0);
        Punto superiorIzquierdo = new Punto(12.0);
        Punto superiorDerecho = new Punto(23.0);
        Punto inferiorDerecho = new Punto(6.0);


        Rectangulo rectangulo = new Rectangulo(inferiorIzquierdo,superiorIzquierdo,superiorDerecho,inferiorDerecho);
        rectangulo.calcularBase();
        rectangulo.calcularAltura();
        rectangulo.calcularArea();
        rectangulo.escribir();

        Rectangulo rectangulo2 = new Rectangulo(superiorIzquierdo,superiorDerecho,inferiorDerecho);
        rectangulo2.calcularBase();
        rectangulo2.calcularAltura();
        rectangulo2.calcularArea();
        rectangulo2.escribir();

    }
}
