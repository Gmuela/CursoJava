package Controllers;

import Beans.Usuario;
import Business.UsuarioBusiness;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletRegistro", urlPatterns = "/registro")
public class ServletRegistro extends GenericServlet<UsuarioBusiness> {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsuarioBusiness usuarioBusiness = getBeanFromClass(UsuarioBusiness.class);

        Usuario usuario = new Usuario(nombre,email,password);
        boolean success = usuarioBusiness.registrarUsuario(usuario);

        if(success){
            response.sendRedirect("Agenda/login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
