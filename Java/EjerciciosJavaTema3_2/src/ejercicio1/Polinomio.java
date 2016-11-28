package ejercicio1;

public class Polinomio {

    private Integer coeficienteA;
    private Integer coeficienteB;
    private Integer coeficienteC;
    private Double resultadoPolinomio;

    public Polinomio(){
        //Default constructor
    }

    public Polinomio(Integer coeficienteA, Integer coeficienteB, Integer coeficienteC) {

        this.coeficienteA = coeficienteA;
        this.coeficienteB = coeficienteB;
        this.coeficienteC = coeficienteC;
    }

    public void calcularValor(Double numero){

        double pow = Math.pow(numero, 2);
        this.resultadoPolinomio = coeficienteA + coeficienteB * numero + coeficienteC * pow;
    }

    public void escribir(Double numero){
        System.out.println("El polinomio de "+numero+" es "+this.resultadoPolinomio);
    }
}
