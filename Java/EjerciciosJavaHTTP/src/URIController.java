import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class URIController implements HttpHandler {

    private static final String INDEX_HTML = "/index.html";
    private static final String IMAGEN_JPG = "/imagen.jpg";
    private static final String IMAGEN_ROUTE = "https://media-cdn.tripadvisor.com/media/photo-o/02/51/d0/db/sunrise-at-playa-bonita.jpg";

    @Override
    public void handle(HttpExchange httpExchange) {
        URI requestURI = httpExchange.getRequestURI();
        String URIString = requestURI.toString();
        if (URIString.equalsIgnoreCase(INDEX_HTML)) {
            String message = "<h1>Hola que tal!</h1>";
            String textLink = "Imagen";
            String response = getResponse(message, IMAGEN_JPG, textLink);
            sendOutputStream(httpExchange, response);

        } else if (URIString.equalsIgnoreCase(IMAGEN_JPG)) {
            String message = "<img src='" + IMAGEN_ROUTE + "'/>";
            String textLink = "Index";
            String response = getResponse(message, INDEX_HTML, textLink);
            sendOutputStream(httpExchange, response);

        } else {
            String message = "<h1>Error 404</h1>";
            String textLink = "Volver al index";
            String response = getResponse(message, INDEX_HTML, textLink);
            sendOutputStream(httpExchange, response);
        }
    }

    private String getResponse(String message, String route, String textLink) {

        String begin = "<html><body>";
        String separador = "<br>";
        String link = "<a href='" + route + "'>" + textLink + "</a>";
        String end = "</body></html>";

        return begin + message + separador + link + end;
    }

    private void sendOutputStream(HttpExchange httpExchange, String response) {
        try {
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
