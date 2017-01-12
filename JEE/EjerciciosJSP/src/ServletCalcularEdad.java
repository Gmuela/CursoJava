import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "ServletCalcularEdad", urlPatterns = "/CalcularEdad")
public class ServletCalcularEdad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate today = LocalDate.now();

        LocalDate birthday = LocalDate.parse(request.getParameter("fechaNacimiento"));
        Period age = Period.between(birthday, today);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String formattedBirthday = birthday.format(formatter);

        request.setAttribute("age", String.valueOf(age.getYears()));
        request.setAttribute("date", formattedBirthday);

        /*TODO EJEMPLO CON FORWARD*/
        /*ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/nombre.jsp");
        rd.forward(request, response);*/

        /*TODO EJEMPLO CON SENDREDIRECT*/
        HttpSession session = request.getSession(false);
        session.setAttribute("nombre", request.getParameter("nombre"));
        session.setAttribute("age", String.valueOf(age.getYears()));
        session.setAttribute("date", formattedBirthday);
        response.sendRedirect("/nombre.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
