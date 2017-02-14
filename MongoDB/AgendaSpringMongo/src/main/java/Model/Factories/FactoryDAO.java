package Model.Factories;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Repository;

@Repository
public class FactoryDAO {

    public static MongoDatabase getMongoConnection(){
        MongoClient mongoClient = new MongoClient();
        return mongoClient.getDatabase("AgendaSpringMongo");
    }
}
