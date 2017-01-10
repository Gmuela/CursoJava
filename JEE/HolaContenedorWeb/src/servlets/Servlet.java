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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");

        LocalDate today = LocalDate.now();

        LocalDate birthday = LocalDate.parse(fecha);
        Period period = Period.between(birthday, today);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yy");
        String formattedBirthday = birthday.format(formatter);


        writer.print("<html><body>");
        writer.print("<b>Nombre:</b> " + nombre + "<br>");
        writer.print("<b>Fecha de nacimiento: </b>" + formattedBirthday + "<br>");
        writer.print("<b>Edad: </b>" + period.getYears() + " años, "+period.getMonths() + " meses y " + period.getDays() + " días");
        writer.print("</body></html>");
    }
}
