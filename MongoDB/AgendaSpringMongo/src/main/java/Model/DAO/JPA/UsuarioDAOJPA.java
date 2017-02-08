package Model.DAO.JPA;

import Beans.Usuario;
import Model.DAO.BasicDAO;
import Model.DAO.UsuarioDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//@Repository("UsuarioDAOJPA")
public class UsuarioDAOJPA implements UsuarioDAO, BasicDAO<Usuario> {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public boolean insert(Usuario usuario){
        manager.persist(usuario);
        return true;
    }

    @Override
    public boolean update(Usuario usuario) {
        manager.merge(usuario);
        return true;
    }

    @Override
    public Usuario login(String nombre, String password) {
        String prepareQuery = "select usuario from Beans.Usuario usuario where usuario.nombre = :nombre and usuario.password = :password";
        Query query = manager.createQuery(prepareQuery);
        query.setParameter("nombre", nombre);
        query.setParameter("password", password);
        return (Usuario) query.getSingleResult();
    }
}
