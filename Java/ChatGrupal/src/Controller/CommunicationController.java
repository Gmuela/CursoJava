package Controller;

import Model.ClientFactory;
import Model.ClientReceiver;
import Model.ClientTransmitter;

public class CommunicationController {

    private ClientReceiver clientReceiver;
    private ClientTransmitter clientTransmitter;

    public CommunicationController(String host) {
        this.clientReceiver = ClientFactory.createClientReceiver();
        this.clientTransmitter = ClientFactory.createClientTransmitter(host);
    }

    public void enviarMensaje(String mensaje){
        clientTransmitter.enviarMensaje(mensaje);
    }
}
