package CLienteServidorUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorUDP extends Thread{

    private DatagramSocket socket;

    public ServidorUDP() {
        this.socket = getDatagramSocket();
    }

    private DatagramSocket getDatagramSocket() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket =  new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return datagramSocket;
    }


    public void run() {
        this.servir();
    }

    public void servir(){
        while (true) {
            DatagramPacket request = recibirRequest();
            responderRequest(request);
        }
    }

    public DatagramPacket recibirRequest(){
        byte[] data = new byte[1000];
        DatagramPacket request = new DatagramPacket(data, data.length);
        try {
            System.out.println("escuchando");
            this.socket.receive(request);

                    
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }

    public void responderRequest(DatagramPacket request){
        try {
            this.socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        DatagramPacket response = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
        System.out.println("He recibido tu petición, gracias.");
        try {
            this.socket.send(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrar(){
        this.socket.close();
    }
}
