package Model;

import Controller.CommunicationController;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceiver extends Thread implements ClientInterface {

    private Socket socket;
    private DataInputStream flujoEntrada;
    private CommunicationController communicationController;

    public ClientReceiver(String host) {
        init(host);
    }

    private void init(String host) {
        try {
            this.socket = new Socket(host, PUERTO);
            this.flujoEntrada = new DataInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

    }

    public String recibirRespuesta() {
        return null;
    }

    public void cerrar() {
    }

}
