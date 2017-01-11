package Servlets;

import AgendaClasses.Contacto;
import AgendaClasses.Fecha;
import DAO.ContactoDAO;
import DAO.Factories.FactoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        ContactoDAO contactoDAO = FactoryDAO.getContactoDAO();

        Contacto contacto = (Contacto)session.getAttribute("contactoModificar");


        response.setContentType(TEXT_HTML);

        writer.print(DOCTYPE + HTML + HEAD + BODY);
        writer.print("<fieldset><legend>Modificar Contacto</legend><form action=\"/modificarContacto\" method=\"post\">\n" +
                "    <label for=\"nombre\">Nombre:</label><input type=\"text\" name=\"nombre\" id=\"nombre\" value='"+contacto.getNombre()+"'>\n" +
                "    <label for=\"apellidos\">Apellidos:</label><input type=\"text\" name=\"apellidos\" id=\"apellidos\" value='"+contacto.getApellidos()+"'>\n" +
                "    <label for=\"dni\">DNI:</label><input type=\"text\" name=\"dni\" id=\"dni\" value='"+contacto.getDni()+"'>\n" +
                "    <label for=\"fechaNacimiento\">FechaNacimiento:</label><input type=\"text\" name=\"fechaNacimiento\" id=\"fechaNacimiento\" value='"+contacto.getFechaNacimiento()+"'>\n" +
                "    <label for=\"telefono\">Teléfono:</label><input type=\"text\" name=\"telefono\" id=\"telefono\" value='"+contacto.getTelefono()+"'>\n" +
                "    <div class='botones'><button type='submit' class='myButton' name='button' value='add'>Modificar Contacto</button></div>\n" +
                "</form></fieldset>\n");
    }
}
