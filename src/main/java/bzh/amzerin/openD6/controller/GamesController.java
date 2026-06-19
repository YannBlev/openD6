package bzh.amzerin.openD6.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import bzh.amzerin.openD6.bo.Attribute;
import bzh.amzerin.openD6.bo.Character;
import bzh.amzerin.openD6.bo.CharacterForm;
import bzh.amzerin.openD6.bo.Game;
import bzh.amzerin.openD6.bo.Member;
import bzh.amzerin.openD6.bo.Skill;
import bzh.amzerin.openD6.bo.Universe;
import bzh.amzerin.openD6.security.UtilisateurSpringSecurity;
import bzh.amzerin.openD6.service.AttributeService;
import bzh.amzerin.openD6.service.CharacterFormFactory;
import bzh.amzerin.openD6.service.CharacterService;
import bzh.amzerin.openD6.service.GameService;
import bzh.amzerin.openD6.service.MemberService;
import bzh.amzerin.openD6.service.SkillService;
import bzh.amzerin.openD6.service.UniverseService;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/openD6/games")
@AllArgsConstructor
public class GamesController {

	GameService gameService;
	UniverseService universeService;
	AttributeService attributeService;
	SkillService skillService;
	MemberService memberService;
	CharacterService characterService;
	CharacterFormFactory characterFormFactory;
	
	@ModelAttribute
	public void addAttributes(Model model) {
		List<Attribute> attributes = attributeService.getAttributes();
		List<Skill> skills = skillService.getSkills();
	    model.addAttribute("attributes", attributes);
	    model.addAttribute("skills", skills);
	}
	
	@ModelAttribute("universes")
	public List<Universe> addAttributeModelUniverses(){
		return universeService.getUniverses();
	}
	
	@GetMapping
	public String getGames(Model model, @AuthenticationPrincipal UtilisateurSpringSecurity utilisateurConnecte) {

		Member player = getConnectedMember(utilisateurConnecte);
		List<Game> games = gameService.getGames();

		model.addAttribute("games", games);
		model.addAttribute("player", player);
		return "pages/games";
	}

	@GetMapping("/new")
	public String getNewGame(Model model) {
		List<Universe> universes = universeService.getUniverses();
		model.addAttribute("game", new Game());
		model.addAttribute("universes", universes);
		return "pages/newGame";
	}
	
	@PostMapping("/new")
	public String postNewGame(Game game, @AuthenticationPrincipal UtilisateurSpringSecurity utilisateurConnecte) {
		Member member = getConnectedMember(utilisateurConnecte);
		game.setGameMaster(member);
		gameService.createGame(game);
		return "redirect:/openD6/games";
	}
	
	@GetMapping("/{idGame}")
	public String getGame(@PathVariable("idGame") int idGame, Model model, @AuthenticationPrincipal UtilisateurSpringSecurity utilisateurConnecte) {
	    Game game = gameService.getGameById(idGame);

	    if (game == null) {
	        return "redirect:/openD6/games";
	    }

	    // Return a character 
	    Member player = getConnectedMember(utilisateurConnecte);
	    
	    boolean hasCharacter = characterService.hasCharacter(game, player);
	    
	    if (hasCharacter) {
	    	Character character = characterService.getCharacter(game, player);
	    	model.addAttribute("character", character);
	    }
	    
	    model.addAttribute("hasCharacter", hasCharacter);
	    model.addAttribute("game", game);
	    
	    return "pages/detailGame";
	}

	@GetMapping("/{idGame}/newCharacter")
	public String getGameNewCharacter(@PathVariable("idGame") int idGame, Model model,  @AuthenticationPrincipal UtilisateurSpringSecurity utilisateurConnecte) {
		
	    Game game = gameService.getGameById(idGame);
	    Member player =  getConnectedMember(utilisateurConnecte);
	    
	    if (game == null) {
	        return "redirect:/openD6/games";
	    }
	    
	    if (characterService.hasCharacter(game, player)) {
	    	return "redirect:/openD6/games";
	    }
	    
	    model.addAttribute("characterForm",characterFormFactory.build(game));
	    model.addAttribute("game", game);
	    
	    return "pages/gameNewCharacter";		
	}
	
	@PostMapping("/{idGame}/newCharacter")
	public String postGameNewCharacter(@PathVariable("idGame") int idGame, @ModelAttribute CharacterForm characterForm, @AuthenticationPrincipal UtilisateurSpringSecurity utilisateurConnecte) {

	    Member member = getConnectedMember(utilisateurConnecte);	    
	    Game game = gameService.getGameById(idGame);

	    if (game == null) {
	        return "redirect:/openD6/games";
	    }
	    
	    characterService.createCharacter(characterForm, member, game);
	    
	    return "redirect:/openD6/games/" + idGame;
	}
	

	@PostMapping("/{id}/newPlayer")
	public String postGameNewPlayer(@PathVariable("id") int id, @RequestParam("username") String username, RedirectAttributes redirectAttributes) {
		Member player = memberService.getMemberByPseudo(username);

		if (player == null) {
			redirectAttributes.addFlashAttribute("errorMessage", "You have to enter a username");
			return "redirect:/openD6/games/" + id;
		}

		List<Member> players = gameService.getGameById(id).getPlayers();
		if (players == null) {
			players = new ArrayList<>();
		}
		players.add(player);
		gameService.getGameById(id).setPlayers(players);
		return "redirect:/openD6/games/" + id;
	}
	

	@PostMapping("/{idGame}/deletePlayer")
	public String getDelete(@PathVariable("idGame") int idGame, int idPlayer) {
		gameService.getGameById(idGame).getPlayers().remove(memberService.getMemberById(idPlayer));
		return "redirect:/openD6/games/" + idGame;
	}
	
	
	private Member getConnectedMember(UtilisateurSpringSecurity utilisateurConnecte) {
	    return memberService.getMemberByPseudo(utilisateurConnecte.getUsername());
	}
	
}
