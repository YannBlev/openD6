package bzh.amzerin.openD6.dal;

import java.util.List;

import bzh.amzerin.openD6.bo.Character;

public interface CharacterDao {

	List<Character> getCharacters();
	Character getCharacterById(int id);
	void createCharacter(Character character);
	void deleteCharacterById(int id);
	
}
