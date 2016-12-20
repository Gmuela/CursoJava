package Calculadora;

import javax.swing.*;

public class Calculadora {
    private JPanel panel1;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    private JButton buttonIgual;
    private JButton buttonClear;
    private JButton buttonSumar;
    private JButton buttonRestar;
    private JButton buttonMultiplicar;
    private JButton buttonDividir;

    private JTextField numeros;
    private JTextField resultados;
    private JButton buttonNeg;
    private JButton buttonDot;

    public Calculadora() {
        CalculatorEventController eventController = new CalculatorEventController(this.resultados,this.numeros);
        initButtonsController(eventController);
        setNames();
        this.resultados.setEditable(false);
    }

    private void initButtonsController(CalculatorEventController eventController) {
        this.button0.addActionListener(eventController);
        this.button1.addActionListener(eventController);
        this.button2.addActionListener(eventController);
        this.button3.addActionListener(eventController);
        this.button4.addActionListener(eventController);
        this.button5.addActionListener(eventController);
        this.button6.addActionListener(eventController);
        this.button7.addActionListener(eventController);
        this.button8.addActionListener(eventController);
        this.button9.addActionListener(eventController);

        this.buttonSumar.addActionListener(eventController);
        this.buttonRestar.addActionListener(eventController);
        this.buttonMultiplicar.addActionListener(eventController);
        this.buttonDividir.addActionListener(eventController);
        this.buttonIgual.addActionListener(eventController);

        this.buttonClear.addActionListener(eventController);
        this.buttonDot.addActionListener(eventController);
        this.buttonNeg.addActionListener(eventController);
    }

    private void setNames() {
        this.button0.setName(BotonesCalculadora.botonNumero);
        this.button1.setName(BotonesCalculadora.botonNumero);
        this.button2.setName(BotonesCalculadora.botonNumero);
        this.button3.setName(BotonesCalculadora.botonNumero);
        this.button4.setName(BotonesCalculadora.botonNumero);
        this.button5.setName(BotonesCalculadora.botonNumero);
        this.button6.setName(BotonesCalculadora.botonNumero);
        this.button7.setName(BotonesCalculadora.botonNumero);
        this.button8.setName(BotonesCalculadora.botonNumero);
        this.button9.setName(BotonesCalculadora.botonNumero);

        this.buttonSumar.setName(BotonesCalculadora.botonSumar);
        this.buttonRestar.setName(BotonesCalculadora.botonRestar);
        this.buttonMultiplicar.setName(BotonesCalculadora.botonMultiplicar);
        this.buttonDividir.setName(BotonesCalculadora.botonDividir);
        this.buttonIgual.setName(BotonesCalculadora.botonIgual);

        this.buttonClear.setName(BotonesCalculadora.botonClear);
        this.buttonNeg.setName(BotonesCalculadora.botonNegar);
        this.buttonDot.setName(BotonesCalculadora.botonPunto);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new Calculadora().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
