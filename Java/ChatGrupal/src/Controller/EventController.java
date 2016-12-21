package Controller;

import Vista.ChatUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventController implements ActionListener{

    private JTextField nick;
    private JTextField host;

    private CommunicationController communicationController;

    public EventController(JTextField nick, JTextField host) {
        this.nick = nick;
        this.host = host;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if button == login
        this.communicationController = new CommunicationController(host.getText());
        new ChatUI(host.getText(), nick.getText());
        //if button == send
        this.communicationController.enviarMensaje("mensaje");
    }
}
