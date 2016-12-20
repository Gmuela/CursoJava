package Calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEventController implements ActionListener {

    private JTextField resultados;
    private JTextField numeros;

    private Calculos calculos;

    private Double primerNumero;
    private Double segundoNumero;

    private Double resultado;
    private String lastOperation;

    public CalculatorEventController(JTextField resultados, JTextField numeros) {
        this.resultados = resultados;
        this.numeros = numeros;
        this.calculos = new Calculos();
        resetNumbers();
        this.resultado = 0.0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String type = button.getName();
        switch (type) {
            case (BotonesCalculadora.botonSumar):
                if (resultadoIsZero()) {
                    if (primerNumeroIsZero()) {
                        Double numberFromCalculator = getNumberFromCalculator();
                        doTheFirstOperation(button, numberFromCalculator);
                    } else if (isSegundoNumeroZero()) {
                        Double numberFromCalculator = getNumberFromCalculator();
                        if(numberFromCalculatorIsNull(numberFromCalculator)){
                            this.segundoNumero = numberFromCalculator;
                            this.resultado = calculos.sumar(this.primerNumero, this.segundoNumero);
                            endOfOperation();
                        } else{
                            saveLastOperation(button);
                        }
                    }
                } else {
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.sumar(this.resultado, this.segundoNumero);
                        saveLastOperation(button);
                        endOfOperation();
                    } else{
                        saveLastOperation(button);
                    }
                }
                break;
            case (BotonesCalculadora.botonRestar):
                if (resultadoIsZero()) {
                    if (primerNumeroIsZero()) {
                        Double numberFromCalculator = getNumberFromCalculator();
                        doTheFirstOperation(button, numberFromCalculator);
                    } else if (isSegundoNumeroZero()) {
                        Double numberFromCalculator = getNumberFromCalculator();
                        if(numberFromCalculatorIsNull(numberFromCalculator)){
                            this.segundoNumero = numberFromCalculator;
                            this.resultado = calculos.restar(this.primerNumero, this.segundoNumero);
                            endOfOperation();
                        } else{
                            saveLastOperation(button);
                        }
                    }
                } else {
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.restar(this.resultado, this.segundoNumero);
                        saveLastOperation(button);
                        endOfOperation();
                    } else{
                        saveLastOperation(button);
                    }
                }
                break;
            case (BotonesCalculadora.botonMultiplicar):
                if (resultadoIsZero()) {
                    if (primerNumeroIsZero()) {
                        Double numberFromCalculator = getNumberFromCalculator();
                        doTheFirstOperation(button, numberFromCalculator);
                    } else if (isSegundoNumeroZero()) {
                        Double numberFromCalculator = getNumberFromCalculator();
                        if(numberFromCalculatorIsNull(numberFromCalculator)){
                            this.segundoNumero = numberFromCalculator;
                            this.resultado = calculos.multiplicar(this.primerNumero, this.segundoNumero);
                            endOfOperation();
                        } else{
                            saveLastOperation(button);
                        }
                    }
                } else {
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.multiplicar(this.resultado, this.segundoNumero);
                        saveLastOperation(button);
                        endOfOperation();
                    } else{
                        saveLastOperation(button);
                    }
                }
                break;
            case (BotonesCalculadora.botonDividir):
                if (resultadoIsZero()) {
                    if (primerNumeroIsZero()) {
                        Double numberFromCalculator = getNumberFromCalculator();
                        doTheFirstOperation(button, numberFromCalculator);
                    } else if (isSegundoNumeroZero()) {
                        Double numberFromCalculator = getNumberFromCalculator();
                        if(numberFromCalculatorIsNull(numberFromCalculator)){
                            this.segundoNumero = numberFromCalculator;
                            this.resultado = calculos.dividir(this.primerNumero, this.segundoNumero);
                            endOfOperation();
                        } else{
                            saveLastOperation(button);
                        }
                    }
                } else {
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.dividir(this.resultado, this.segundoNumero);
                        saveLastOperation(button);
                        endOfOperation();
                    } else{
                        saveLastOperation(button);
                    }
                }
                break;
            case (BotonesCalculadora.botonClear):
                clearAllCalculator();
                break;
            case (BotonesCalculadora.botonNumero):
                numeros.setText(numeros.getText() + button.getText());
                break;
            case (BotonesCalculadora.botonIgual):
                doLastOperation();
                showResult();
                break;
            case (BotonesCalculadora.botonNegar):
                numeros.setText("-" + numeros.getText());
                break;
            case (BotonesCalculadora.botonPunto):
                numeros.setText(numeros.getText() + ".");
                break;
        }

    }

    private void doTheFirstOperation(JButton button, Double numberFromCalculator) {
        if(numberFromCalculatorIsNull(numberFromCalculator)){
            this.primerNumero = numberFromCalculator;
            this.resultados.setText(primerNumero.toString());
            saveLastOperation(button);
            clear();
        } else{
            saveLastOperation(button);
        }
    }

    private boolean numberFromCalculatorIsNull(Double numberFromCalculator) {
        return numberFromCalculator != null;
    }

    private boolean isSegundoNumeroZero() {
        return this.segundoNumero == 0.0;
    }

    private boolean primerNumeroIsZero() {
        return this.primerNumero == 0.0;
    }

    private boolean resultadoIsZero() {
        return this.resultado == 0.0;
    }

    private void doLastOperation() {
        switch (this.lastOperation) {
            case (BotonesCalculadora.botonSumar):
                if(resultadoIsZero()){
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.sumar(this.primerNumero, this.segundoNumero);
                        endOfOperation();
                    }
                } else{
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.sumar(this.resultado, this.segundoNumero);
                        endOfOperation();
                    }
                }
                break;
            case (BotonesCalculadora.botonRestar):
                if(resultadoIsZero()){
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.restar(this.primerNumero, this.segundoNumero);
                        endOfOperation();
                    }
                } else{
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.restar(this.resultado, this.segundoNumero);
                        endOfOperation();
                    }
                }
                break;
            case (BotonesCalculadora.botonMultiplicar):
                if(resultadoIsZero()){
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.multiplicar(this.primerNumero, this.segundoNumero);
                        endOfOperation();
                    }
                } else{
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.multiplicar(this.resultado, this.segundoNumero);
                        endOfOperation();
                    }
                }
                break;
            case (BotonesCalculadora.botonDividir):
                if(resultadoIsZero()){
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.dividir(this.primerNumero, this.segundoNumero);
                        endOfOperation();
                    }
                } else{
                    Double numberFromCalculator = getNumberFromCalculator();
                    if(numberFromCalculatorIsNull(numberFromCalculator)){
                        this.segundoNumero = numberFromCalculator;
                        this.resultado = calculos.dividir(this.resultado, this.segundoNumero);
                        resetNumbers();
                    }
                    showResult();
                    clear();
                }
                break;
        }
    }

    private void endOfOperation() {
        resetNumbers();
        showResult();
        clear();
    }

    private void saveLastOperation(JButton button) {
        this.lastOperation = button.getName();
    }

    private void clearAllCalculator() {
        clear();
        resetNumbers();
        this.resultados.setText("0");
        this.resultado = 0.0;
    }

    private void resetNumbers() {
        this.primerNumero = 0.0;
        this.segundoNumero = 0.0;
    }

    private void clear() {
        numeros.setText("");
    }

    private void showResult() {
        resultados.setText(this.resultado.toString());
    }

    private Double getNumberFromCalculator() {

        String numberString = numeros.getText();
        Double number = null;

        if(!numberString.isEmpty()){
            number = Double.parseDouble(numberString);
        }

        return number;
    }
}
