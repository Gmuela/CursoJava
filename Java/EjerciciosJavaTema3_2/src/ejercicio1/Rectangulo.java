package ejercicio1;

public class Rectangulo {

    private Punto superiorIzquierdo;
    private Punto superiorDerecho;
    private Punto inferiorIzquierdo;
    private Punto inferiorDerecho;
    private Double base;
    private Double altura;
    private Double area;

    public Rectangulo(Punto inferiorIzquierdo, Punto superiorIzquierdo, Punto superiorDerecho, Punto inferiorDerecho) {
        this.superiorIzquierdo = superiorIzquierdo;
        this.superiorDerecho = superiorDerecho;
        this.inferiorIzquierdo = inferiorIzquierdo;
        this.inferiorDerecho = inferiorDerecho;
    }

    public Rectangulo(Punto superiorIzquierdo, Punto superiorDerecho, Punto inferiorDerecho) {
        this.superiorIzquierdo = superiorIzquierdo;
        this.superiorDerecho = superiorDerecho;
        this.inferiorDerecho = inferiorDerecho;
        this.inferiorIzquierdo = new Punto(0.0);
    }

    public void calcularArea() {
        this.area = (base * altura);
    }

    public void calcularAltura() {

        this.altura = this.superiorDerecho.getSituacion() - this.inferiorDerecho.getSituacion();

    }

    public void calcularBase() {

        this.base = this.inferiorDerecho.getSituacion() - this.inferiorIzquierdo.getSituacion();

    }

    public void escribir() {
        System.out.println("Rectángulo: \nPunto Inferior Izquierdo: "+this.inferiorIzquierdo.getSituacion());
        System.out.println("Punto Superior Izquierdo: "+this.superiorIzquierdo.getSituacion());
        System.out.println("Punto Superior Derecho: "+this.superiorDerecho.getSituacion());
        System.out.println("Punto Inferior Derecho: "+this.inferiorDerecho.getSituacion());
        System.out.println("Base: "+this.base);
        System.out.println("Altura: "+this.altura);
        System.out.println("Área: "+this.area);
    }
}
