import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String args[]) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(6789);
            while (true) {
                byte[] n = new byte[1000];
                DatagramPacket req = new DatagramPacket(n, n.length);
                socket.receive(req);
                DatagramPacket rep = new DatagramPacket(req.getData(), req.getLength(), req.getAddress(), req.getPort());
                System.out.println(new String(rep.getData()));
                socket.send(rep);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (socket != null) socket.close();
        }
    }
}
