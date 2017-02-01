package AntiguosServlets;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

public class GenericServlet<T> extends HttpServlet {

    T getBeanFromClass(Class<T> classType){
        ServletContext servletContext = getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        return context.getBean(classType);
    }
}
