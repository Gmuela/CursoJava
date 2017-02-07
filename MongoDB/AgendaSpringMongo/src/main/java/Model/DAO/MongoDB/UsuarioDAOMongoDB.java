package Model.DAO.MongoDB;

import Beans.Usuario;
import Model.DAO.UsuarioDAO;
import Model.Factories.FactoryDAO;
import com.mongodb.client.MongoDatabase;

public class UsuarioDAOMongoDB implements UsuarioDAO {

    private MongoDatabase mongoDatabase = FactoryDAO.getMongoConnection();

    @Override
    public Usuario login(String nombre, String password) {
        return null;
    }
}
