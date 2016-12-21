package CLienteServidorUDP;

import java.io.IOException;
import java.net.*;

public class ClienteUDP implements UDPData {

    private DatagramSocket socket;

    public ClienteUDP() {
        this.socket = getDatagramSocket();
    }

    private DatagramSocket getDatagramSocket() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket =  new DatagramSocket(UDPData.PORT_RECEIVE);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return datagramSocket;
    }

    public void enviar(String mensaje, String persona, String destino){
        try {
            byte[] mensajeBytes = (persona+mensaje).getBytes();
            InetAddress host = InetAddress.getByName(destino);
            DatagramPacket mensajeEnviado = new DatagramPacket(mensajeBytes, mensajeBytes.length, host, UDPData.PORT_SEND);
            this.socket.send(mensajeEnviado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] recibir(){
        byte[] datos = new byte[1000];
        byte[] mensajeRecibidoData = null;
        try {
            DatagramPacket mensajeRecibido = new DatagramPacket(datos, datos.length);
            mensajeRecibidoData = mensajeRecibido.getData();
            this.socket.receive(mensajeRecibido);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mensajeRecibidoData;
    }

    public void cerrar(){
        this.socket.close();
    }
}
