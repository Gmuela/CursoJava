package Controllers;

import Beans.Contacto;
import Business.ContactoBusiness;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ServletModificarContacto", urlPatterns = "/modificarContacto")
public class ServletModificarContacto extends GenericServlet<ContactoBusiness> {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        ContactoBusiness contactoBusiness = getBeanFromClass(ContactoBusiness.class);

        Contacto contacto = (Contacto)session.getAttribute("contactoModificar");

        contacto.setNombre(request.getParameter("nombre"));
        contacto.setApellidos(request.getParameter("apellidos"));
        contacto.setDni(request.getParameter("dni"));
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        contacto.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
        contacto.setTelefono(request.getParameter("telefono"));

        contactoBusiness.modifyContacto(contacto);

        response.sendRedirect("/contactos");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        ContactoBusiness contactoBusiness = getBeanFromClass(ContactoBusiness.class);

        String id = request.getParameter("idContacto");
        Contacto contacto = contactoBusiness.getContactoWithId(id);
        session.setAttribute("contactoModificar", contacto);

        response.sendRedirect("/Agenda/modificarContacto.jsp");
    }
}
