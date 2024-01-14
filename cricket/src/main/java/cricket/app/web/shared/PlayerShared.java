package cricket.app.web.shared;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerShared {


    private String _id;
    private String teamId;
    private String firstName;
    private String lastName;
    private LocalDateTime dob;
    private Integer age;
    private String isCaptain;
    private String isWicketKeeper;
    private String skill;

}
