package Model.DAO.MongoDB;

import Beans.Usuario;
import Model.Factories.FactoryDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;

@Repository("BasicDAO")
public class BasicDAOMongo{

    private MongoDatabase database = FactoryDAO.getMongoConnection();

    public boolean insert(Usuario usuario) {
        MongoCollection<Document> usuarios = database.getCollection("usuarios");
        Document nuevoUsuario = new Document();
        nuevoUsuario.put("nombre", usuario.getNombre());
        nuevoUsuario.put("email", usuario.getEmail());
        nuevoUsuario.put("password", usuario.getPassword());
        usuarios.insertOne(nuevoUsuario);
        return true;
    }

    public boolean update(Usuario usuario) {
        MongoCollection<Document> usuarios = database.getCollection("usuarios");

        return true;
    }

}
