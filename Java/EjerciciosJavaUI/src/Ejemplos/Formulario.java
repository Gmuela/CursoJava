package Ejemplos;

import javax.swing.*;
import java.awt.*;

public class Formulario {

    private static final int OPERATION = WindowConstants.EXIT_ON_CLOSE;
    private static final Component LOCATION = null;

    public static void main(String[] args) {

        Formulario formulario = new Formulario();
        JPanel panelGeneral = new JPanel();
        BorderLayout externalLayout = new BorderLayout();
        panelGeneral.setLayout(externalLayout);

        JPanel panelCamposTexto = new JPanel();
        panelCamposTexto.setLayout(new GridLayout(5,0,0,10));
        formulario.setCampoNombre(panelCamposTexto);
        formulario.setCampoNIF(panelCamposTexto);
        formulario.setCheckBoxEdad(panelCamposTexto);
        formulario.setCampoEstadoCivil(panelCamposTexto);
        panelGeneral.add(panelCamposTexto,BorderLayout.NORTH);

        formulario.createFrame(panelGeneral);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void createFrame(JPanel panel) {
        JFrame frame = new JFrame("Formulario");
        int width = 400;
        int height = 500;

        frame.setSize(width, height);
        frame.setLocationRelativeTo(LOCATION);
        frame.setDefaultCloseOperation(OPERATION);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private void setCampoNombre(JPanel panel) {
        JLabel labelCampoNombre = new JLabel("Nombre");
        JTextField campoNombre = new JTextField();
        campoNombre.setColumns(20);
        panel.add(labelCampoNombre);
        panel.add(campoNombre);
    }

    private void setCheckBoxEdad(JPanel panel) {
        JLabel labelCheckboxEdad = new JLabel("¿Mayor de edad?");
        JCheckBox checkBoxEdad = new JCheckBox();

        panel.add(labelCheckboxEdad);
        panel.add(checkBoxEdad);
    }

    private void setCampoNIF(JPanel panel) {
        JLabel labelNIF = new JLabel("NIF");
        JTextField nif = new JTextField(20);

        panel.add(labelNIF);
        panel.add(nif);
    }

    private void setCampoEstadoCivil(JPanel panel) {
        ButtonGroup estadoCivil = new ButtonGroup();
        JRadioButton radioCasado = new JRadioButton("Casado");
        JRadioButton radioSoltero = new JRadioButton("Soltero");
        JRadioButton radioViudo = new JRadioButton("Viudo");
        JRadioButton radioPareja = new JRadioButton("Pareja de hecho");

        estadoCivil.add(radioCasado);
        estadoCivil.add(radioSoltero);
        estadoCivil.add(radioViudo);
        estadoCivil.add(radioPareja);

        panel.add(radioCasado);
        panel.add(radioSoltero);
        panel.add(radioViudo);
        panel.add(radioPareja);
    }
}
