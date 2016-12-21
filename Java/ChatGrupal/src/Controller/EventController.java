package Controller;

import Vista.ChatUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventController implements ActionListener{

    private String nick;
    private String host;

    private CommunicationController communicationController;

    public EventController(String nick, String host) {
        this.nick = nick;
        this.host = host;
        this.communicationController = FactoryCommunicationController.getController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if button == login
        FactoryCommunicationController.initController(this.host);
        new ChatUI().openChat();
        System.out.println(nick);
        System.out.println(host);
        //if button == send
        this.communicationController.enviarMensaje("mensaje");
    }
}
