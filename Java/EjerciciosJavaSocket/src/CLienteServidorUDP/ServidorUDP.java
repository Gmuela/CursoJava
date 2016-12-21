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
            datagramSocket =  new DatagramSocket(UDPData.PORT_SEND);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return datagramSocket;
    }

    public static void main(String[] args){
        new ServidorUDP().servir();
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
            this.socket.receive(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }

    public void responderRequest(DatagramPacket request){
        DatagramPacket response = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
        System.out.println(new String(request.getData()));
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
