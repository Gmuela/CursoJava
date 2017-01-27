package Controllers;

import Beans.Contacto;
import Model.DAO.BasicDAO;
import Model.DAO.ContactoDAO;
import Model.DAO.ContactoDAOJPA;
import Model.Factories.FactoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletModificarContacto", urlPatterns = "/modificarContacto")
public class ServletModificarContacto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        BasicDAO<Contacto> contactoDAO = new ContactoDAOJPA();

        Contacto contacto = (Contacto)session.getAttribute("contactoModificar");

        contacto.setNombre(request.getParameter("nombre"));
        contacto.setApellidos(request.getParameter("apellidos"));
        contacto.setDni(request.getParameter("dni"));
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        contacto.setFechaNacimiento(fechaNacimiento);
        contacto.setTelefono(request.getParameter("telefono"));

        contactoDAO.update(contacto);

        response.sendRedirect("/contactos");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        ContactoDAO contactoDAO = FactoryDAO.getContactoDAO();

        String id = request.getParameter("idContacto");
        Contacto contacto = contactoDAO.selectContactoBy(id);
        session.setAttribute("contactoModificar", contacto);

        response.sendRedirect("/Agenda/modificarContacto.jsp");
    }
}
