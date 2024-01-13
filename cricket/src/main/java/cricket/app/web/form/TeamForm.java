package cricket.app.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeamForm {

    private String _id;
    private String captain;
    private String teamName;
    private Integer playersCount;
    private LocalDateTime createdDate;

}
