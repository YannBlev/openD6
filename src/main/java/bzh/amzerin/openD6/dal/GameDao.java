package bzh.amzerin.openD6.dal;

import java.util.List;

import bzh.amzerin.openD6.bo.Game;

public interface GameDao {

	List<Game> getGames();
	Game getGameById(int id);
	void createGame(Game game);
	void deleteGameById(int id);
}
