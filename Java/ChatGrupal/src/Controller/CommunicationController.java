package Controller;

import Model.ClientReceiver;
import Model.ClientTransmitter;
import Model.FactoryClient;

import javax.swing.*;

public class CommunicationController {

    private ClientReceiver clientReceiver;
    private ClientTransmitter clientTransmitter;

    JTextArea chat;

    public CommunicationController(String host) {
        this.clientReceiver = FactoryClient.createClientReceiver(host);
        this.clientTransmitter = FactoryClient.createClientTransmitter(host);
    }

    public void initChat(JTextArea textAreaMensajes) {
        this.chat = textAreaMensajes;
        System.out.println(this.chat.getText());
    }

    public void enviarMensaje(String mensaje) {
        clientTransmitter.enviarMensaje(mensaje);
    }

    public void recibirMensaje() {
    }
}
