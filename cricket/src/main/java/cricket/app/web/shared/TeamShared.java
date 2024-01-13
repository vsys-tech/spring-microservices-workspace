package cricket.app.web.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamShared {

    private String _id;
    private String captain;
    private String teamName;
    private Integer playersCount;
    private LocalDateTime createdDate;

}
