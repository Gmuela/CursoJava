package Model.DAO;

import Beans.BeanTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository(value = "DAOTemplate")
public class DAOTemplate extends BasicDAO<BeanTemplate> {

    public void accesoDB(/*algo*/) {
        String prepareQuery = "select beanTemaplate from Beans.BeanTemplate beanTemplate"/*where beanTemplate.atributo = :algo*/;
        Query query = manager.createQuery(prepareQuery);
//        query.setParameter("algo", algo);
//        return (ArrayList<BeanTemplate>) query.getResultList();
//        return (BeanTemplate) query.getSingleResult();
    }
}
