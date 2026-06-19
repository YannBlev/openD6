package bzh.amzerin.openD6.service;

import java.util.List;

import bzh.amzerin.openD6.bo.Character;
import bzh.amzerin.openD6.bo.CharacterForm;
import bzh.amzerin.openD6.bo.Game;
import bzh.amzerin.openD6.bo.Member;

public interface CharacterService {

	List<Character> getCharacters();
	Character getCharacter(Game game, Member member);
	Character getCharacterById(int id);
	void createCharacter(CharacterForm form, Member member, Game game);
	void deleteCharacterById(int id);
	Character updateSkillsCharacter(Character character);
	boolean hasCharacter(Game game, Member member);
	boolean hasCharacterByGame(Game game);
	boolean hasCharacterByMember(Member member);
	
}
