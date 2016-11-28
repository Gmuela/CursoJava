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

    public Racional suma(Racional racional) {

        Racional racionalResultado = new Racional();

        if (this.denominador.equals(racional.getDenominador())) {
            Integer sumaNumeradores = this.numerador + racional.getNumerador();
            racionalResultado.setNumerador(sumaNumeradores);
            racionalResultado.setDenominador(this.denominador);
        } else {
            Integer minimoComunMultiploDenominadores = minimoComunMultiplo(this.denominador, racional.getDenominador());
            racionalResultado.setDenominador(minimoComunMultiploDenominadores);
            Integer sumaNumeradores = (this.numerador * (minimoComunMultiploDenominadores / this.denominador)) + (racional.getNumerador() * (minimoComunMultiploDenominadores / racional.getDenominador()));
            racionalResultado.setNumerador(sumaNumeradores);
        }

        return racionalResultado;
    }

    public Racional resta(Racional racional) {
        Racional racionalResultado = new Racional();

        if (this.denominador.equals(racional.getDenominador())) {
            Integer restaNumeradores = this.numerador - racional.getNumerador();
            racionalResultado.setNumerador(restaNumeradores);
            racionalResultado.setDenominador(this.denominador);
        } else {
            Integer minimoComunMultiploDenominadores = minimoComunMultiplo(this.denominador, racional.getDenominador());
            racionalResultado.setDenominador(minimoComunMultiploDenominadores);
            Integer restaNumeradores = (this.numerador * (minimoComunMultiploDenominadores / this.denominador)) - (racional.getNumerador() * (minimoComunMultiploDenominadores / racional.getDenominador()));
            racionalResultado.setNumerador(restaNumeradores);
        }

        return racionalResultado;

    }

    public Racional multiplicacion(Racional racional) {

        Racional racionalResultado = new Racional();

        Integer numeradorResultado = this.numerador * racional.getNumerador();
        Integer denominadorResultado = this.denominador * racional.getDenominador();

        racionalResultado.setNumerador(numeradorResultado);
        racionalResultado.setDenominador(denominadorResultado);

        return racionalResultado;
    }

    public Racional division(Racional racional) {

        Racional racionalResultado = new Racional();

        Integer numeradorResultado = this.numerador * racional.getDenominador();
        Integer denominadorResultado = this.denominador * racional.getNumerador();

        racionalResultado.setNumerador(numeradorResultado);
        racionalResultado.setDenominador(denominadorResultado);

        return racionalResultado;
    }

    public Boolean mayorQue(Racional racional) {

        Boolean resultado = false;

        Float thisFraccion = (float) this.numerador / (float) this.denominador;
        Float paramFraccion = (float) racional.getNumerador() / (float) racional.getDenominador();

        if (thisFraccion > paramFraccion) {
            resultado = true;
        }

        return resultado;
    }

    public static int maximoComunDivisor(Integer num1, Integer num2) {
        int mcd = 0;
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
        do {
            mcd = b;
            b = a % b;
            a = mcd;
        } while (b != 0);
        return mcd;
    }

    public static int minimoComunMultiplo(Integer num1, Integer num2) {
        int mcm = 0;
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
        mcm = (a / maximoComunDivisor(a, b)) * b;
        return mcm;
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
