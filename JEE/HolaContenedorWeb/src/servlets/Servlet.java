package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");
        String[] datosFecha = fecha.split("-");
        LocalDate today = LocalDate.now();

        int thisYear = today.getYear();

        LocalDate date = LocalDate.parse(fecha);

        Integer edadInteger = thisYear - date.getYear();
        String edad = String.valueOf(edadInteger);

        writer.println("Nombre: " + nombre);
        writer.println("Fecha de nacimiento: " + date.toString());
        writer.println("Edad: " + edad);
    }
}
