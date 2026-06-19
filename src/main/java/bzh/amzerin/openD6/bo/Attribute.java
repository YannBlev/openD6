package bzh.amzerin.openD6.bo;

import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {

	private int id;
	private String name;
	private List<Skill> skills;

		
}
