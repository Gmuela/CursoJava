package Model.DAO.MongoDB;

import Beans.Usuario;
import Model.DAO.BasicDAO;
import Model.DAO.UsuarioDAO;
import Model.Factories.FactoryDAO;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository("UsuarioDAOMongo")
public class UsuarioDAOMongoDB implements UsuarioDAO, BasicDAO<Usuario> {

    private MongoDatabase database = FactoryDAO.getMongoConnection();

    @Override
    public Usuario login(String nombre, String password) {
        MongoCollection<Document> usuarios = database.getCollection("usuarios");
        Document where = new Document();
        where.put("nombre", nombre);
        where.put("password", password);
        FindIterable<Document> documents = usuarios.find(where);
        Document first = documents.first();
        ObjectId _id = first.get("_id", ObjectId.class);
        String nombreUsuario = first.get("nombre", String.class);
        String email = first.get("email", String.class);
        String passwordUsuario = first.get("password", String.class);
        return new Usuario(_id, nombreUsuario, email, passwordUsuario);
    }

    @Override
    public boolean insert(Usuario usuario) {
        MongoCollection<Document> usuarios = database.getCollection("usuarios");
        Document nuevoUsuario = usuario.getDocument();
        usuarios.insertOne(nuevoUsuario);
        return true;
    }

    @Override
    public boolean update(Usuario usuario) {
        //Not implemented yet
        return true;
    }
}
