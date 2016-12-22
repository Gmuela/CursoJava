package Controller;

import Vista.ChatUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventController implements ActionListener{

    private JTextField nick;
    private JTextField host;

    private CommunicationController communicationController;

    public EventController() {
        this.communicationController = FactoryCommunicationController.getController();
    }

    public void initFields(JTextField nick, JTextField host) {
        this.nick = nick;
        this.host = host;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getName();
        if(buttonName.equalsIgnoreCase("login")){
            FactoryCommunicationController.initController(this.host.getText());
            new ChatUI().openChat();
            System.out.println("En la clase event controller----");
            System.out.println(nick.getText());
            System.out.println(host.getText());
        } else if(buttonName.equalsIgnoreCase("send")){
            this.communicationController.enviarMensaje("mensaje");
        }
    }
}
