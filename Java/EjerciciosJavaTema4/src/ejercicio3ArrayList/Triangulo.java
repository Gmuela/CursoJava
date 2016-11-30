package ejercicio3ArrayList;

public class Triangulo {

    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo() {
    }

    public String toString() {

        return "Soy un triángulo isósceles de base " + this.base + " y altura " + this.altura;

    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String mostrarTodosDatos() {
        String info = "";

        double area = CalculosGeometricos.calcularArea(this);
        double perimetro = CalculosGeometricos.calcularPerimetro(this);

        info += "Triángulo isósceles de base " + this.base + ", altura " + this.altura + ", área " + area + " y perímetro " + perimetro;

        return info;
    }
}
