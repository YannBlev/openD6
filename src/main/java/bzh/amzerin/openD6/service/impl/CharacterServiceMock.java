package bzh.amzerin.openD6.service.impl;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import bzh.amzerin.openD6.bo.AttributeForm;
import bzh.amzerin.openD6.bo.Character;
import bzh.amzerin.openD6.bo.CharacterForm;
import bzh.amzerin.openD6.bo.Game;
import bzh.amzerin.openD6.bo.Member;
import bzh.amzerin.openD6.dal.CharacterDao;
import bzh.amzerin.openD6.service.CharacterService;
import lombok.AllArgsConstructor;

@Service
@Profile("mock")
@AllArgsConstructor
public class CharacterServiceMock implements CharacterService {

	CharacterDao characterDao;
	
	@Override
	public List<Character> getCharacters() {
		return characterDao.getCharacters();
	}

	@Override
	public Character getCharacterById(int id) {
		return characterDao.getCharacterById(id);
	}
	
	@Override
	public Character getCharacter(Game game, Member member) {
		List<Character> characters = getCharacters();
		return characters.stream()
			.filter(c -> c.getGame().equals(game) && c.getPlayer().equals(member))
			.findFirst()
			.orElse(null);
	}
	
	@Override
	public void createCharacter(CharacterForm form, Member member, Game game) {
	    Character character = new Character();
	    character.setPlayer(member);
	    character.setName(form.getCharacterName());
	    character.setGame(game);
	    character.setAttributes(form.getAttributes());
		characterDao.createCharacter(character);
	}

	@Override
	public void deleteCharacterById(int id) {
		characterDao.deleteCharacterById(id);
	}

	@Override
	public Character updateSkillsCharacter(Character character) {
		List<AttributeForm> attributes = character.getAttributes();
		attributes.stream().forEach(a -> a.getSkills().stream().forEach(s -> s.setPipValue(a.getPipValue() + s.getPipValue())));
		character.setAttributes(attributes);
		return character;
	}

	@Override
	public boolean hasCharacter(Game game, Member member) {
		return hasCharacterByGame(game) && hasCharacterByMember(member);
	}

	@Override
	public boolean hasCharacterByGame(Game game) {
		return getCharacters().stream().anyMatch(c -> c.getGame().equals(game));
	}

	@Override
	public boolean hasCharacterByMember(Member member) {
		return getCharacters().stream().anyMatch( c -> c.getPlayer().equals(member));
	}
	
}
