package ejercicio1;

public class Racional {

    private Integer numerador;
    private Integer denominador;

    public Racional() {
    }

    public Racional(Integer numerador, Integer denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Racional suma(Racional racional){

        Racional racionalResultado = new Racional();

        if(this.denominador == racional.getDenominador()){
            int sumaNumeradores = this.numerador + racional.getNumerador();
            racionalResultado.setNumerador(sumaNumeradores);
            racionalResultado.setDenominador(this.denominador);
        }

        else{

            int mcm = 0;
            int a = Math.max(this.denominador, racional.getDenominador());
            int b = Math.min(this.denominador, racional.getDenominador());
            mcm = (a/mcd(a, b))*b;
            return mcm;
        }

        return racionalResultado;
    }

    public Racional resta(Racional racional){
        return null;

    }

    public Racional multiplicacion(Racional racional){
        return null;
    }

    public Racional division(Racional racional){
        return null;
    }

    public Racional comparacion(Racional racional){

        return null;
    }

    public Integer getNumerador() {
        return numerador;
    }

    public void setNumerador(Integer numerador) {
        this.numerador = numerador;
    }

    public Integer getDenominador() {
        return denominador;
    }

    public void setDenominador(Integer denominador) {
        this.denominador = denominador;
    }
}
