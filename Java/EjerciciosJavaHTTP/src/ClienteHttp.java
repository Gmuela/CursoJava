import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClienteHttp {
    public ClienteHttp() {
        String peticion;
        DataOutputStream salida;
        DataInputStream entrada;
        String cad = "";
        byte datosBytes[] = new byte[256];
        int leido = 0;
        try {
            Socket conexion = new Socket("localhost", 8081);
            System.out.println("Conectando");
            peticion = "GET /index.html HTTP/1.1\n";
            peticion += "Accept: */*\n";
            peticion += "Accept-Language: es\n";
            peticion += "Accept-Encoding: gzip, deflate\n";
            peticion += "User-Agent: Mozilla/4.0 (compatible; MSIE 5.01; Windows NT)\n";
            peticion += "Host: 127.0.0.1\n";
            peticion += "Connection: close\n\n";
            salida = new DataOutputStream(conexion.getOutputStream());
            salida.write(peticion.getBytes()); //Vemos lo que nos envía el Servidor
            entrada = new DataInputStream(conexion.getInputStream());
            while ((leido = entrada.read(datosBytes, 0, 255)) != -1)
                if (leido > 0){
                    System.out.println(new String(datosBytes, 0, (leido)));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ClienteHttp s = new ClienteHttp();
    }
}