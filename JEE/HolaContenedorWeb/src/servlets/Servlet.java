package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    private static final String TEXT_HTML = "text/html";
    private static final String DOCTYPE = "<!DOCTYPE html>";
    private static final String HTML = "<html lang=\"en\">";
    private static final String TITLE = "<title>Fechas</title>";
    private static final String HEAD = "<head><meta charset=\"UTF-8\">" + TITLE + "</head>";
    private static final String BODY = "<body>";
    private static final String CLOSE_BODY = "</body>";
    private static final String CLOSE_HTML = "</html>";
    public static final String BR = "<br>";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");

        LocalDate today = LocalDate.now();

        LocalDate birthday = LocalDate.parse(fecha);
        Period age = Period.between(birthday, today);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String formattedBirthday = birthday.format(formatter);

        String anios = age.getYears() + " años";
        String meses = age.getMonths() + " meses";
        String dias = age.getDays() + " días";

        response.setContentType(TEXT_HTML);

        writer.print(DOCTYPE + HTML + HEAD + BODY);

        writer.print("<b>Nombre:</b> " + nombre + BR);
        writer.print("<b>Fecha de nacimiento: </b>" + formattedBirthday + BR);
        writer.print("<b>Edad: </b>" + anios + ", " + meses + " y " + dias);

        writer.print(CLOSE_BODY + CLOSE_HTML);
    }
}
