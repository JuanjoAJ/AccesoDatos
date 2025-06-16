import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Entrada {
    public static void main(String[] args) {
        String connectionString = "mongodbConexion"; //mongodb+srv://ue:ue@cluster0.zdk8c7y.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();


        MongoClient mongoClient= MongoClients.create(settings);

        MongoDatabase db= mongoClient.getDatabase("centro_estudios");
        MongoCollection collection = db.getCollection("profesores");




    }

}
