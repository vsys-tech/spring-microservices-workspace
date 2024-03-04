package schema.app.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbConfig {


    @Bean
    MongoClient mongoClient() {
        //mongodb://192.168.1.152:27017/cricket
        ConnectionString connectionString =
                new ConnectionString("mongodb://192.168.1.152:27017/test");
        //MongoClient client = MongoClients.create("mongodb://192.168.1.152:27017/");

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "test");
    }

    @Bean
    MongoDatabase mongoDatabase() {
        MongoDatabase mongoDatabase = mongoClient().getDatabase("test");
        return mongoDatabase;
    }


}
