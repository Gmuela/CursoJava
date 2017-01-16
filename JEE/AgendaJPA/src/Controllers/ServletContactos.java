package Controllers;

import Beans.Contacto;
import Model.DAO.ContactoDAO;
import Model.Factories.FactoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletContactos", urlPatterns = "/contactos")
public class ServletContactos extends HttpServlet implements UtilHTML {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String button = request.getParameter("button");
        String id = request.getParameter("idContacto");
        ContactoDAO contactoDAO = FactoryDAO.getContactoDAO();

        if (button.equalsIgnoreCase("remove")) {
            contactoDAO.borrarContacto(id);
            doGet(request,response);

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
            List<String> errorNombre = ValidationController.validateOnlyLetters(nombre);
            if(errorNombre.size() != 0){
                System.out.println(errorNombre.get(0));
            }
            List<String> errorApellido = ValidationController.validateOnlyLetters(apellidos);
            if(errorApellido.size() != 0){

                System.out.println(errorApellido.get(0));
            }
            List<String> errorDni = ValidationController.validateDniFormat(dni);
            if(errorDni.size() != 0){
                System.out.println(errorDni.get(0));
            }
            List<String> errorTelephone = ValidationController.validateTelephoneFormat(telefono);
            if(errorTelephone.size() != 0){
                System.out.println(errorTelephone.get(0));
            }
            Contacto contacto = new Contacto(nombre, apellidos, dni, LocalDate.parse(fechaNacimiento), telefono, nombreUsuario);
            contactoDAO.guardarContacto(contacto);
            doGet(request,response);

        } else if (button.equalsIgnoreCase("filter")) {
            session.removeAttribute("mes");
            session.setAttribute("mes", request.getParameter("mes"));
            doGet(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");

        ContactoDAO contactoDAO = FactoryDAO.getContactoDAO();
        ArrayList<Contacto> contactos;
        if (session.getAttribute("mes").equals("/00/")) {
            contactos = contactoDAO.getContactosOf(nombreUsuario);

        } else {
            contactos = contactoDAO.getContactosFromMonth(nombreUsuario, (String) session.getAttribute("mes"));
        }

        session.setAttribute("listaContactos", contactos);
        response.sendRedirect("/Agenda/listaContactos.jsp");
    }
}
