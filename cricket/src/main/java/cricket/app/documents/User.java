package cricket.app.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {

    @MongoId
    private String _id;
    private String id;
    private String email;
    private String userName;
    private String phone;
}
