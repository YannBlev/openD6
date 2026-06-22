package bzh.amzerin.openD6.bo;

import lombok.*;

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