package schema.app.controller;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ValidationOptions;
import org.bson.BsonType;
import org.bson.conversions.Bson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schema")
public class SchemaController {

    private final MongoClient mongoClient;

    private final MongoDatabase mongoDatabase;

    public SchemaController(MongoClient mongoClient, MongoDatabase mongoDatabase) {
        this.mongoClient = mongoClient;
        this.mongoDatabase = mongoDatabase;
    }


    @GetMapping("/connect")
    public String connectToDb() {
        try {
            Bson username = Filters.type("username", BsonType.STRING);
            Bson email = Filters.regex("email", "@*.*$");
            Bson password = Filters.type("password", BsonType.STRING);
            Bson validator = Filters.and(username, email, password);
            ValidationOptions validationOptions = new ValidationOptions()
                    .validator(validator);
            this.mongoDatabase.createCollection("accounts", new CreateCollectionOptions()
                    .validationOptions(validationOptions));

        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        return "executed";

    }


}
