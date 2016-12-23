import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class ServidorHttp {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/index.html", new URIController());
        server.createContext("/imagen.jpg", new URIController());
        server.createContext("/", new URIController());
        server.setExecutor(null);
        server.start();
    }
}