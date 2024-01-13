package cricket.app.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @MongoId
    private String _id;

    private String captain;
    private String teamName;
    private Integer playersCount;
    private LocalDateTime createdDate;

}
