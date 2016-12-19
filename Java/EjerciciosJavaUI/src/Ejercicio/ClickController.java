package Ejercicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickController implements ActionListener {

    private EjercicioEventos ejercicioEventos;

    public ClickController(EjercicioEventos ejercicioEventos){
        this.ejercicioEventos = ejercicioEventos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = ejercicioEventos.button;
        JFrame frame = ejercicioEventos.frame;
        String type = button.getName();
        if(type.equalsIgnoreCase(TiposBoton.tipoBotonCambiarText)){
            /*button.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
            frame.setTitle("Nuevo título");*/
            button.setText("Nuevo Texto");
        }
        if(type.equalsIgnoreCase(TiposBoton.tipoBotonCambiarTitle)){
            //button.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
            frame.setTitle("Nuevo título");
            //button.setText("Nuevo Texto");
        }
    }
}
