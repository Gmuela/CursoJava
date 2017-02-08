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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        MongoCollection<Document> contactos = database.getCollection("contactos");
        Document where = new Document();
        where.put("_id", contacto.get_id());
        contactos.updateOne(where, contacto.getDocument());
        return true;
    }

    @Override
    public ArrayList<Contacto> selectAll() {
        return null;
    }

    @Override
    public Contacto selectContactoBy(String id) {
        MongoCollection<Document> contactos = database.getCollection("contactos");

        Document where = new Document();
        where.put("_id", new ObjectId(id));

        FindIterable<Document> documents = contactos.find(where);
        Document first = documents.first();

        ObjectId _id = first.get("_id", ObjectId.class);
        String nombre = first.get("nombre", String.class);
        String apellidos = first.get("apellidos", String.class);
        String dni = first.get("dni", String.class);
        LocalDate fechaNacimiento = LocalDate.parse(first.get("fechaNacimiento", String.class));
        String telefono = first.get("telefono", String.class);

        List<Document> usuarios = first.get("usuario", List.class);

        List<Usuario> listaUsuarios = new ArrayList<>();

        for (Document usuario : usuarios) {
            ObjectId objectId = usuario.get("_id", ObjectId.class);
            String nombreUsuario = usuario.get("nombre", String.class);
            String email = usuario.get("email", String.class);
            String password = usuario.get("password", String.class);

            listaUsuarios.add(new Usuario(objectId, nombreUsuario, email, password));
        }

        return new Contacto(_id, nombre, apellidos, dni, fechaNacimiento, telefono, listaUsuarios);
    }

    @Override
    public ArrayList<Contacto> selectContactosOf(Usuario usuario) {
        MongoCollection<Document> contactos = database.getCollection("contactos");
        Document where = new Document();
        where.put("usuario", usuario.getDocument());
        FindIterable<Document> documents = contactos.find(where);
        ArrayList<Contacto> listaContactos = new ArrayList<>();
        for (Document document : documents) {
            ObjectId _id = document.get("_id", ObjectId.class);
            String nombre = document.get("nombre", String.class);
            String apellidos = document.get("apellidos", String.class);
            String dni = document.get("dni", String.class);
            LocalDate fechaNacimiento = LocalDate.parse(document.get("fechaNacimiento", String.class));
            String telefono = document.get("telefono", String.class);
            listaContactos.add(new Contacto(_id, nombre, apellidos, dni, fechaNacimiento, telefono, null));
        }
        return listaContactos;
    }

    @Override
    public ArrayList<Contacto> selectContactosFromMonth(Usuario usuario, String mes) {
        return null;
    }

    @Override
    public boolean deleteContactoBy(String id) {
        MongoCollection<Document> contactos = database.getCollection("contactos");
        Document where = new Document();
        where.put("_id", new ObjectId(id));
        contactos.deleteOne(where);
        return true;
    }
}
