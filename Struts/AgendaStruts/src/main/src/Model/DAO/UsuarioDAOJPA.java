package Model.DAO;

import Beans.Usuario;

import javax.persistence.*;

public class UsuarioDAOJPA implements UsuarioDAO, BasicDAO<Usuario> {

    @Override
    public Usuario login(String nombre, String password) {
        String prepareQuery = "select usuario from Beans.Usuario usuario where usuario.nombre = :nombre and usuario.password = :password";
        Query query = manager.createQuery(prepareQuery);
        query.setParameter("nombre", nombre);
        query.setParameter("password", password);
        Usuario usuario = (Usuario) query.getSingleResult();
        return usuario;
    }
}
