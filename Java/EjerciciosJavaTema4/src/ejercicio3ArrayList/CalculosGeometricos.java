package ejercicio3ArrayList;

public class CalculosGeometricos {

    public static double calcularPerimetro(Triangulo triangulo) {

        return (2 * triangulo.getAltura()) + triangulo.getBase();

    }

    public static double calcularArea(Triangulo triangulo) {

        return (triangulo.getBase() * triangulo.getAltura()) / 2;

    }

}
