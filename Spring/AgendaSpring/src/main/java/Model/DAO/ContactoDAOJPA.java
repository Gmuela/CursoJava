package Model.DAO;

import Beans.Contacto;
import Beans.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;

@Repository(value = "ContactoDAOJPA")
public class ContactoDAOJPA extends BasicDAO<Contacto> implements ContactoDAO {

    @Override
    public ArrayList<Contacto> selectAll() {
        String prepareQuery = "select contacto from Beans.Contacto contacto";
        Query query = manager.createQuery(prepareQuery);
        return (ArrayList<Contacto>) query.getResultList();
    }

    @Override
    public Contacto selectContactoBy(String id) {
        Integer idInteger = Integer.parseInt(id);
        String prepareQuery = "select contacto from Beans.Contacto contacto where id = :id";
        Query query = manager.createQuery(prepareQuery);
        query.setParameter("id", idInteger);
        return (Contacto) query.getSingleResult();
    }

    @Override
    public ArrayList<Contacto> selectContactosOf(Usuario usuario) {
        String prepareQuery = "select contacto from Beans.Contacto contacto where contacto.usuario = :usuario";
        Query query = manager.createQuery(prepareQuery);
        query.setParameter("usuario", usuario);
        return (ArrayList<Contacto>) query.getResultList();
    }

    @Override
    public ArrayList<Contacto> selectContactosFromMonth(Usuario usuario, String mes) {
        Integer mesInteger = Integer.parseInt(mes);
        String prepareQuery = "select contacto from Beans.Contacto contacto where contacto.usuario = :usuario and MONTH(contacto.fechaNacimiento) = :mes";
        Query query = manager.createQuery(prepareQuery);
        query.setParameter("usuario", usuario);
        query.setParameter("mes", mesInteger);
        return (ArrayList<Contacto>) query.getResultList();
    }

    @Override
    public boolean deleteContactoBy(String id) {
        Integer idInteger = Integer.parseInt(id);
        Contacto contacto = manager.find(Contacto.class, idInteger);
        manager.remove(contacto);
        return true;
    }
}
