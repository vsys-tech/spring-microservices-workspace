package cricket.app.web.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserShared {

    private String _id;
    private String id;
    private String email;
    private String userName;
    private String phone;
}
