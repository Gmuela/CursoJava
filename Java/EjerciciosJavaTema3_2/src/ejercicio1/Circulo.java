package ejercicio1;

public class Circulo {

    private Double coordenadaX;
    private Double coordenadaY;
    private Double radio;


    public Circulo(){
        //Default constructor
    }

    public Circulo(Double radio) {

        this.radio = radio;
    }

    public Circulo(Double coordenadaX, Double coordenadaY, Double radio) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.radio = radio;
    }

    public Double calcularArea(){

        return Math.PI *Math.pow(radio,2);
    }

    public Double calcularLongitud(){
        return 2* Math.PI *radio;
    }

    public void mostrarResultados(){
        System.out.println("Coordenadas: X = "+this.coordenadaX + " | Y = "+this.coordenadaY);
        System.out.println("Radio: "+ this.radio);
        System.out.println("Área: "+ calcularArea());
        System.out.println("Longitud: "+ calcularLongitud());
    }

}
