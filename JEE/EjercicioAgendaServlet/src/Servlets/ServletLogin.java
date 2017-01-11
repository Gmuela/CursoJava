package Servlets;

import AgendaClasses.Usuario;
import DAO.Factories.FactoryDAO;
import DAO.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
        Usuario usuario = usuarioDAO.getUsuario(nombre, password);
        if(usuario != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("nombreUsuario", usuario.getNombre());
            session.setAttribute("mes", "/00/");
            response.sendRedirect("/contactos");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
