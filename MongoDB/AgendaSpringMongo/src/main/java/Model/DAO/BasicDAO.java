package Model.DAO;

import org.springframework.stereotype.Repository;

@Repository("BasicDAO")
public interface BasicDAO<T> {
    boolean insert(T object);
    boolean update(T object);
}
