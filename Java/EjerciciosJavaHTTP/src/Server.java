import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final String HTTP_200 = "HTTP/1.1 200 OK\r\n\r\n";
    private static final String HTTP_404 = "HTTP/1.1 404 OK\r\n\r\n";
    private static final String INDEX_HTML = "/index.html";
    private static final String IMAGEN_JPG = "/imagen.jpg";
    private static final String IMAGEN_ROUTE = "https://media-cdn.tripadvisor.com/media/photo-o/02/51/d0/db/sunrise-at-playa-bonita.jpg";


    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(8081);
        System.out.println("Listening for connection on port 8081 ....");
        while (true) {
            try (Socket client = server.accept()) {
                InputStreamReader headers = new InputStreamReader(client.getInputStream());
                BufferedReader reader = new BufferedReader(headers);
                String line = reader.readLine();
                String[] data = line.split(" ");
                System.out.println(data[1]);
                if (data[1].equalsIgnoreCase(INDEX_HTML)) {
                    sendIndex(client);
                } else if (data[1].equalsIgnoreCase(IMAGEN_JPG)) {
                    sendImage(client);
                } else {
                    sendError(client);
                }
                client.close();
            }
        }
    }

    private static void sendIndex(Socket client) throws IOException {
        String message = "<h1>Hola que tal!</h1>";
        String textLink = "Imagen";
        String response = HTTP_200 + getResponse(message, IMAGEN_JPG, textLink);
        client.getOutputStream().write(response.getBytes("UTF-8"));
    }

    private static void sendImage(Socket client) throws IOException {
        String message = "<img src='" + IMAGEN_ROUTE + "'/>";
        String textLink = "Index";
        String response = HTTP_200 + getResponse(message, INDEX_HTML, textLink);
        client.getOutputStream().write(response.getBytes("UTF-8"));
    }

    private static void sendError(Socket client) throws IOException {
        client.getOutputStream().write(HTTP_404.getBytes("UTF-8"));
    }

    private static String getResponse(String message, String route, String textLink) {

        String begin = "<html><body>";
        String separador = "<br>";
        String link = "<a href='" + route + "'>" + textLink + "</a>";
        String end = "</body></html>\r";

        return begin + message + separador + link + end;
    }
}
