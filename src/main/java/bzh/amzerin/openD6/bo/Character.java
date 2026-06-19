package bzh.amzerin.openD6.bo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {

	private int id;
	private String name;
	private Member player;
	private Game game;
	private List<AttributeForm> attributes;
	// TODO to decide to keep or not
	//private List<CharacterSkill> skills;
	
	public void performAnAction() {System.out.printf("%s perform an action.", this.name);}
	
	public void takeDamage(){System.out.printf("%s take damage.", this.name);}
}
