package Model.DAO.JPA;

import Beans.Usuario;
import Model.DAO.UsuarioDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

//@Repository("UsuarioDAOJPA")
public class UsuarioDAOJPA extends BasicDAOJPA<Usuario> implements UsuarioDAO {

    @Override
    public Usuario login(String nombre, String password) {
        String prepareQuery = "select usuario from Beans.Usuario usuario where usuario.nombre = :nombre and usuario.password = :password";
        Query query = manager.createQuery(prepareQuery);
        query.setParameter("nombre", nombre);
        query.setParameter("password", password);
        return (Usuario) query.getSingleResult();
    }
}
