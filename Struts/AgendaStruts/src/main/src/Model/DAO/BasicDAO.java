package Model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public interface BasicDAO<T> {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AgendaJPA");
    EntityManager manager = entityManagerFactory.createEntityManager();

    default boolean insert(T object) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(object);
        transaction.commit();
        return true;
    }

    default boolean update(T object) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(object);
        transaction.commit();
        return true;
    }
}
