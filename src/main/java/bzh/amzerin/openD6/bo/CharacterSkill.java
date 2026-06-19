package bzh.amzerin.openD6.bo;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterSkill {

    private Skill skill;
    @Size(max=15)
    private int pip;
	
}
