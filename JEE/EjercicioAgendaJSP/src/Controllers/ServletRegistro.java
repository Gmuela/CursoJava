package Controllers;

import Beans.Usuario;
import Model.Factories.FactoryDAO;
import Model.DAO.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletRegistro", urlPatterns = "/registro")
public class ServletRegistro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
        Usuario usuario = new Usuario(nombre,email,password);
        boolean success = usuarioDAO.registrarUsuario(usuario);

        if(success){
            response.sendRedirect("Agenda/login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
