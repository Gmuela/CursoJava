package Model.DAO;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository(value = "BasicDAO")
public class BasicDAO<T> {

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
