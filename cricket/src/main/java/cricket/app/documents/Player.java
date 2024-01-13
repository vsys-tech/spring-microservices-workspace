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

public class Player {

    @MongoId
    private String _id;
    private String teamId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String isCaptain;
    private String isWicketKeeper;
    private String skill;
}
