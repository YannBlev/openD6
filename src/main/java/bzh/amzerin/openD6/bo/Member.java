package bzh.amzerin.openD6.bo;

import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private int id;
    private String pseudo;
    private String password;
    private boolean admin = false;

    public Member(int id, String pseudo, String password) {
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
    }

}