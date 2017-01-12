package Controllers;

import AgendaClasses.Contacto;
import AgendaClasses.Fecha;
import Model.DAO.ContactoDAO;
import Model.Factories.FactoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ServletContactos", urlPatterns = "/contactos")
public class ServletContactos extends HttpServlet implements UtilHTML {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String button = request.getParameter("button");
        String id = request.getParameter("idContacto");
        ContactoDAO contactoDAO = FactoryDAO.getContactoDAO();

        if (button.equalsIgnoreCase("remove")) {
            contactoDAO.borrarContacto(id);
            response.sendRedirect("/contactos");

        } else if (button.equalsIgnoreCase("update")) {
            Contacto contacto = contactoDAO.recuperarContacto(id);
            session.setAttribute("contactoModificar", contacto);
            response.sendRedirect("/modificarContacto");

        } else if (button.equalsIgnoreCase("add")) {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String dni = request.getParameter("dni");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String telefono = request.getParameter("telefono");
            String nombreUsuario = (String) session.getAttribute("nombreUsuario");
            Contacto contacto = new Contacto(nombre, apellidos, dni, new Fecha(fechaNacimiento), telefono, nombreUsuario);
            contactoDAO.guardarContacto(contacto);

        } else if (button.equalsIgnoreCase("filter")) {
            session.removeAttribute("mes");
            session.setAttribute("mes", request.getParameter("mes"));
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");

        ContactoDAO contactoDAO = FactoryDAO.getContactoDAO();
        ArrayList<Contacto> contactos;
        if (session.getAttribute("mes").equals("/00/")) {
            contactos = contactoDAO.getContactosOf(nombreUsuario);

        } else {
            contactos = contactoDAO.getContactosFromMonth(nombreUsuario, (String) session.getAttribute("mes"));
        }

        response.setContentType(TEXT_HTML);

        writer.print(DOCTYPE + HTML + HEAD + BODY);

        writer.print("<b>Usuario: </b>" + nombreUsuario + BR);
        writer.print("<div class='registerLink'><a href='/logout'>Logout</a></div>");
        writer.print(SELECT_MONTH);
        writer.print(TABLE);
        for (Contacto contacto : contactos) {
            String inputHidden = "<input type='hidden' name='idContacto' value='" + contacto.getId() + "'/>";
            writer.print(TR + TD);
            writer.print(contacto.getNombre());
            writer.print(CLOSE_TD + TD);
            writer.print(contacto.getApellidos());
            writer.print(CLOSE_TD + TD);
            writer.print(contacto.getDni());
            writer.print(CLOSE_TD + TD);
            writer.print(contacto.getFechaNacimiento());
            writer.print(CLOSE_TD + TD);
            writer.print(contacto.getTelefono());
            writer.print(CLOSE_TD + TD);
            writer.print(FORM_UPDATE_REMOVE + BUTTON_UPDATE + inputHidden + CLOSE_FORM);
            writer.print(CLOSE_TD + TD);
            writer.print(FORM_UPDATE_REMOVE + BUTTON_REMOVE + inputHidden + CLOSE_FORM);
            writer.print(CLOSE_TD + CLOSE_TR);
        }
        writer.print(CLOSE_TABLE);
        writer.print(BUTTON_ADD);
        writer.print(CLOSE_BODY + CLOSE_HTML);
    }
}
