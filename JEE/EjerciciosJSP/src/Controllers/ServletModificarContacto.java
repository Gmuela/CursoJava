package Controllers;

import Beans.Contacto;
import Beans.Fecha;
import Model.DAO.ContactoDAO;
import Model.Factories.FactoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletModificarContacto", urlPatterns = "/modificarContacto")
public class ServletModificarContacto extends HttpServlet implements UtilHTML {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        ContactoDAO contactoDAO = FactoryDAO.getContactoDAO();

        Contacto contacto = (Contacto)session.getAttribute("contactoModificar");

        contacto.setNombre(request.getParameter("nombre"));
        contacto.setApellidos(request.getParameter("apellidos"));
        contacto.setDni(request.getParameter("dni"));
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        contacto.setFechaNacimiento(new Fecha(fechaNacimiento));
        contacto.setTelefono(request.getParameter("telefono"));

        contactoDAO.modificarContacto(contacto);

        response.sendRedirect("/contactos");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        ContactoDAO contactoDAO = FactoryDAO.getContactoDAO();

        String id = request.getParameter("idContacto");
        Contacto contacto = contactoDAO.recuperarContacto(id);
        session.setAttribute("contactoModificar", contacto);

        response.sendRedirect("/Agenda/modificarContacto.jsp");
    }
}
