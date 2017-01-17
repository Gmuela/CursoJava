package Model.DAO;

import Beans.Contacto;
import Beans.Usuario;

import javax.persistence.*;
import java.util.ArrayList;

public class ContactoDAOJPA implements ContactoDAO, BasicDAO<Contacto> {

    @Override
    public ArrayList<Contacto> selectAll() {
        String prepareQuery = "select contacto from Beans.Contacto contacto";
        Query query = manager.createQuery(prepareQuery);
        ArrayList<Contacto> resultList = (ArrayList<Contacto>) query.getResultList();
        return resultList;
    }

    @Override
    public Contacto selectContactoBy(String id) {
        Integer idInteger = Integer.parseInt(id);
        String prepareQuery = "select contacto from Beans.Contacto contacto where id = :id";
        Query query = manager.createQuery(prepareQuery);
        query.setParameter("id", idInteger);
        Contacto contacto = (Contacto) query.getSingleResult();
        return contacto;
    }

    @Override
    public ArrayList<Contacto> selectContactosOf(Usuario usuario) {
        String prepareQuery = "select contacto from Beans.Contacto contacto where contacto.usuario = :usuario";
        Query query = manager.createQuery(prepareQuery);
        query.setParameter("usuario", usuario);
        ArrayList<Contacto> resultList = (ArrayList<Contacto>) query.getResultList();
        return resultList;
    }

    @Override
    public ArrayList<Contacto> selectContactosFromMonth(Usuario usuario, String mes) {
        Integer mesInteger = Integer.parseInt(mes);
        String prepareQuery = "select contacto from Beans.Contacto contacto where contacto.usuario = :usuario and MONTH(contacto.fechaNacimiento) = :mes";
        Query query = manager.createQuery(prepareQuery);
        query.setParameter("usuario", usuario);
        query.setParameter("mes", mesInteger);
        ArrayList<Contacto> resultList = (ArrayList<Contacto>) query.getResultList();
        return resultList;
    }

    @Override
    public boolean deleteContactoBy(String id) {
        EntityTransaction transaction = manager.getTransaction();
        Integer idInteger = Integer.parseInt(id);
        Contacto contacto = manager.find(Contacto.class, idInteger);
        transaction.begin();
        manager.remove(contacto);
        transaction.commit();
        return true;
    }
}
