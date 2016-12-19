package Ejemplos;

import javax.swing.*;

public class FormularioGUI {
    private JPanel panel1;
    private JLabel Nombre;
    private JTextField nombre;
    private JTextField textField1;
    private JCheckBox mayorDeEdadCheckBox;
    private JRadioButton solteroRadioButton;
    private JRadioButton casadoRadioButton;
    private JRadioButton parejaDeHechoRadioButton;
    private JRadioButton viudoRadioButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioGUI");
        frame.setContentPane(new FormularioGUI().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
