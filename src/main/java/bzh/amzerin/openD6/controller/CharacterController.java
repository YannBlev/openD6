package bzh.amzerin.openD6.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bzh.amzerin.openD6.bo.Attribute;
import bzh.amzerin.openD6.bo.Character;
import bzh.amzerin.openD6.bo.Skill;
import bzh.amzerin.openD6.service.AttributeService;
import bzh.amzerin.openD6.service.CharacterService;
import bzh.amzerin.openD6.service.FileService;
import bzh.amzerin.openD6.service.GameService;
import bzh.amzerin.openD6.service.SkillService;
import bzh.amzerin.openD6.service.UniverseService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/openD6/characters")
public class CharacterController {

	UniverseService universeService;
	AttributeService attributeService;
	SkillService skillService;
	CharacterService characterService;
	FileService fileService;
	
	@ModelAttribute
	public void addAttributes(Model model) {
		List<Character> characters = characterService.getCharacters();
		List<Attribute> attributes = attributeService.getAttributes();
		List<Skill> skills = skillService.getSkills();
	    model.addAttribute("characters", characters);
	    model.addAttribute("attributes", attributes);
	    model.addAttribute("skills", skills);
	}
	
	@GetMapping
	public String getCharacters(Model model) {
		return "pages/characters";
	}

	@GetMapping("/{idCharacter}")
	public String getCharacterById(@PathVariable("idCharacter") int idCharacter, Model model) {
		Character character = characterService.getCharacterById(idCharacter);
		model.addAttribute("character", character);
		return "pages/detailCharacter";
	}
	
	@GetMapping("/new")
	public String getNewCharacter(Model model) {
		return "pages/newCharacter";
	}
	
	@PostMapping("/new")
	public String postNewCharacter(@RequestParam("name") String name) {

	    Character character = new Character();
	    character.setName(name);

	    //characterService.createCharacter(character);

	    return "redirect:/openD6/characters";
	}

	
}
