package ejercicio3ArrayList;

import java.util.ArrayList;

public class Principal {

    private ArrayList<Triangulo> triangulos;

    public Principal() {
        this.triangulos = crearTriangulos();
    }

    public static void main(String[] args){
        Principal principal = new Principal();

        Triangulo trianguloMayorArea = principal.getTrianguloMayorArea();
        Triangulo trianguloMenorPerimetro = principal.getTrianguloMenorPerimetro();

        System.out.println(trianguloMayorArea.toString() + " y tengo el mayor área");
        System.out.println(trianguloMenorPerimetro.toString() + " y tengo el menos perímetro");

        int indiceTriangulo = 2;

        ArrayList<Triangulo> listaTriangulos = principal.getTriangulos();
        Triangulo triangulo = listaTriangulos.get(indiceTriangulo);

        System.out.println(triangulo.mostrarTodosDatos());

        for (Triangulo esteTriangulo : listaTriangulos) {

            System.out.println(esteTriangulo.mostrarTodosDatos());
        }
    }

    private Triangulo getTrianguloMenorPerimetro() {

        Triangulo trianguloMenorPerimetro = new Triangulo();
        Double menorPerimetro = null;

        for (Triangulo triangulo : this.triangulos) {

            double perimetro = CalculosGeometricos.calcularPerimetro(triangulo);

            if(menorPerimetro == null){
                menorPerimetro = perimetro;
            }
            if(menorPerimetro > perimetro){
                menorPerimetro = perimetro;
                trianguloMenorPerimetro = triangulo;
            }
        }

        return trianguloMenorPerimetro;

    }

    private Triangulo getTrianguloMayorArea() {

        Triangulo trianguloMayorArea = new Triangulo();
        double mayorArea = 0;

        for (Triangulo triangulo : this.triangulos) {
            double area = CalculosGeometricos.calcularArea(triangulo);
            if(mayorArea < area){
                mayorArea = area;
                trianguloMayorArea = triangulo;
            }
        }

        return trianguloMayorArea;
    }


    private ArrayList<Triangulo> crearTriangulos() {

        ArrayList<Triangulo> triangulos = new ArrayList<>();

        triangulos.add(new Triangulo(2,5));
        triangulos.add(new Triangulo(5,8));
        triangulos.add(new Triangulo(1,3));
        triangulos.add(new Triangulo(8,12));

        return triangulos;
    }

    public ArrayList<Triangulo> getTriangulos() {
        return triangulos;
    }
}
