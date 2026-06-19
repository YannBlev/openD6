package bzh.amzerin.openD6.bo;

import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterAttribute {

	private Attribute attribute;
	private List<CharacterSkill> skills;
	@Size(max=15)
	private int pip = 3;
}
