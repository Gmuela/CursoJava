package Model.DAO.JPA;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Repository(value = "BasicDAO")
public class BasicDAOJPA<T> {

    @PersistenceContext
    EntityManager manager;

    public boolean insert(T object) {
        manager.persist(object);
        return true;
    }

    public boolean update(T object) {
        manager.merge(object);
        return true;
    }
}
