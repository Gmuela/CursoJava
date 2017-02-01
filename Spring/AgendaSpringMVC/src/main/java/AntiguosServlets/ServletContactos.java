package AntiguosServlets;

import Beans.Contacto;
import Beans.Usuario;
import Business.ContactoBusiness;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@Component
@WebServlet(name = "ServletContactos", urlPatterns = "/contactos")
public class ServletContactos extends GenericServlet<ContactoBusiness> {

    /*@Autowired
    @Qualifier("ContactoBusiness")
    private ContactoBusiness contactoBusiness;*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String button = request.getParameter("button");
        String id = request.getParameter("idContacto");

        ContactoBusiness contactoBusiness = getBeanFromClass(ContactoBusiness.class);

        if (button.equalsIgnoreCase("remove")) {
            contactoBusiness.removeContacto(id);
            doGet(request, response);

        } else if (button.equalsIgnoreCase("update")) {
            Contacto contacto = contactoBusiness.getContactoWithId(id);
            session.setAttribute("contactoModificar", contacto);
            response.sendRedirect("/modificarContacto");

        } else if (button.equalsIgnoreCase("add")) {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String dni = request.getParameter("dni");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String[] fechaSeparada = fechaNacimiento.split("/");
            int year = 2;
            int month = 1;
            int day = 0;
            fechaNacimiento = fechaSeparada[year] + "-" + fechaSeparada[month] + "-" + fechaSeparada[day];
            String telefono = request.getParameter("telefono");
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            Contacto contacto = new Contacto(nombre, apellidos, dni, LocalDate.parse(fechaNacimiento), telefono, usuario);
            contactoBusiness.createContacto(contacto);
            doGet(request, response);

        } else if (button.equalsIgnoreCase("filter")) {
            session.removeAttribute("mes");
            session.setAttribute("mes", request.getParameter("mes"));
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        ContactoBusiness contactoBusiness = getBeanFromClass(ContactoBusiness.class);

        ArrayList<Contacto> contactos;
        if (session.getAttribute("mes").equals("00")) {
            contactos = contactoBusiness.getContactosOf(usuario);

        } else {
            contactos = contactoBusiness.getContactosWithMonth(usuario, (String) session.getAttribute("mes"));
        }

        session.setAttribute("listaContactos", contactos);
        response.sendRedirect("/Agenda/listaContactos.jsp");
    }
}
