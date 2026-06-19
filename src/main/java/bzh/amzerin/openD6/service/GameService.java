package bzh.amzerin.openD6.service;

import java.util.List;

import bzh.amzerin.openD6.bo.Game;
import bzh.amzerin.openD6.bo.Member;
import bzh.amzerin.openD6.security.UtilisateurSpringSecurity;

public interface GameService {
	List<Game> getGames();
	Game getGameById(int id);
	void createGame(Game game);
	void deleteGameById(int id);
}
