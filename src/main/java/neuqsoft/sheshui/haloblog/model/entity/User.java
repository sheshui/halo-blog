package neuqsoft.sheshui.haloblog.model.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String nickname;
    private String password;
    private String email;
    private String avatar;
}
