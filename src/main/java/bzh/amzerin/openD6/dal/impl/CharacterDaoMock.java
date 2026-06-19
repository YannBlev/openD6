package bzh.amzerin.openD6.dal.impl;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import bzh.amzerin.openD6.bo.Character;
import bzh.amzerin.openD6.dal.CharacterDao;

@Repository
@Profile("mock")
public class CharacterDaoMock implements CharacterDao {

	private static List<Character> characters = new ArrayList<>();
	private static int indexCharacter = 1;

	@PostConstruct
	public void init() {
		if (characters.isEmpty()) {

		}
	}
	
	@Override
	public List<Character> getCharacters() {
		return characters;
	}
	
	@Override
	public Character getCharacterById(int id) {
		return characters.stream().filter(c -> c.getId()==id).findFirst().orElse(null);
	}
	
	@Override
	public void createCharacter(Character character) {
		character.setId(indexCharacter);
		characters.add(character);
		indexCharacter++;
	}
	
	@Override
	public void deleteCharacterById(int id) {
		characters.remove(id);
	}
	
}