package Controller;

import Model.FactoryClient;
import Model.ClientReceiver;
import Model.ClientTransmitter;

public class CommunicationController {

    private ClientReceiver clientReceiver;
    private ClientTransmitter clientTransmitter;

    public CommunicationController(String host) {
        this.clientReceiver = FactoryClient.createClientReceiver(host);
        this.clientTransmitter = FactoryClient.createClientTransmitter(host);
    }

    public void enviarMensaje(String mensaje){
        clientTransmitter.enviarMensaje(mensaje);
    }
}
