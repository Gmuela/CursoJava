package Ejercicio;

import javax.swing.*;

public class EjercicioEventos {

    public JButton button;
    public JFrame frame;

    public static void main(String[] args){

        EjercicioEventos ejercicioEventos = new EjercicioEventos();

        ejercicioEventos.frame = new JFrame("MyFrame");
        ejercicioEventos.frame.setSize(400, 300);
        ejercicioEventos.frame.setLocationRelativeTo(null);
        ejercicioEventos.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        ejercicioEventos.frame.add(panel);

        ejercicioEventos.button = new JButton("Soy un botón");
        ejercicioEventos.button.setName(TiposBoton.tipoBotonCambiarTitle);
        ejercicioEventos.button.addActionListener(new ClickController(ejercicioEventos));
        panel.add(ejercicioEventos.button);

        ejercicioEventos.frame.setVisible(true);
    }
}
