package Model.DAO.MongoDB;

import Beans.Contacto;
import Beans.Usuario;
import Model.DAO.BasicDAO;
import Model.DAO.ContactoDAO;
import Model.Factories.FactoryDAO;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("ContactoDAOMongo")
public class ContactoDAOMongoDB implements ContactoDAO, BasicDAO<Contacto> {

    private MongoDatabase database = FactoryDAO.getMongoConnection();

    @Override
    public boolean insert(Contacto contacto) {
        MongoCollection<Document> contactos = database.getCollection("contactos");
        Document document = contacto.getDocument();
        contactos.insertOne(document);
        return true;
    }

    @Override
    public boolean update(Contacto contacto) {

        return false;
    }

    @Override
    public ArrayList<Contacto> selectAll() {
        return null;
    }

    @Override
    public Contacto selectContactoBy(String id) {
        return null;
    }

    @Override
    public ArrayList<Contacto> selectContactosOf(Usuario usuario) {
        MongoCollection<Document> usuarios = database.getCollection("usuarios");
        Document where = new Document();
        where.put("nombre", usuario.getNombre());
        where.put("password", usu);
        FindIterable<Document> documents = usuarios.find(where);
        Document first = documents.first();
        ObjectId _id = first.get("_id", ObjectId.class);
        String nombreUsuario = first.get("nombre", String.class);
        String email = first.get("email", String.class);
        String passwordUsuario = first.get("password", String.class);
        return new Usuario(_id, nombreUsuario, email, passwordUsuario);
    }

    @Override
    public ArrayList<Contacto> selectContactosFromMonth(Usuario usuario, String mes) {
        return null;
    }

    @Override
    public boolean deleteContactoBy(String id) {
        return false;
    }
}
