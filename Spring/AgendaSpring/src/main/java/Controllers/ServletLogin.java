package Controllers;

import Beans.Usuario;
import Business.UsuarioBusiness;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = "/login")
public class ServletLogin extends GenericServlet<UsuarioBusiness> {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");

        UsuarioBusiness usuarioBusiness = getBeanFromClass(UsuarioBusiness.class);

        Usuario usuario = usuarioBusiness.login(nombre, password);
        if(usuario != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario);
            session.setAttribute("mes", "00");
            response.sendRedirect("/contactos");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
