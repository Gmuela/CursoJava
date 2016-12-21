package Model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientTransmitter implements ClientInterface {

    private Socket socket;
    private DataOutputStream flujoSalida;

    public ClientTransmitter(String host) {
        init(host);
    }

    private void init(String host) {
        try {
            this.socket = new Socket(host, PUERTO);
            this.flujoSalida = new DataOutputStream(this.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviarMensaje(String mensaje){

    }
}
