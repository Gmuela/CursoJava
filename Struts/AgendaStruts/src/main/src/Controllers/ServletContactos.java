package Controllers;

import Beans.Contacto;
import Beans.Usuario;
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
import java.util.ArrayList;

@WebServlet(name = "ServletContactos", urlPatterns = "/contactos")
public class ServletContactos extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String button = request.getParameter("button");
        String id = request.getParameter("idContacto");
        BasicDAO<Contacto> basicDAO = new ContactoDAOJPA();
        ContactoDAO contactoDAO = FactoryDAO.getContactoDAO();


        if (button.equalsIgnoreCase("remove")) {
            contactoDAO.deleteContactoBy(id);
            doGet(request, response);

        } else if (button.equalsIgnoreCase("update")) {
            Contacto contacto = contactoDAO.selectContactoBy(id);
            session.setAttribute("contactoModificar", contacto);
            response.sendRedirect("/modificarContacto");

        } else if (button.equalsIgnoreCase("add")) {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String dni = request.getParameter("dni");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String telefono = request.getParameter("telefono");
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            Contacto contacto = new Contacto(nombre, apellidos, dni, fechaNacimiento, telefono, usuario);
            basicDAO.insert(contacto);
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

        ContactoDAO contactoDAO = FactoryDAO.getContactoDAO();
        ArrayList<Contacto> contactos;
        if (session.getAttribute("mes").equals("00")) {
            contactos = contactoDAO.selectContactosOf(usuario);

        } else {
            contactos = contactoDAO.selectContactosFromMonth(usuario, (String) session.getAttribute("mes"));
        }

        session.setAttribute("listaContactos", contactos);
        response.sendRedirect("/Agenda/listaContactos.jsp");
    }
}
