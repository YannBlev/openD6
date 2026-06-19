package bzh.amzerin.openD6.service.impl;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import bzh.amzerin.openD6.bo.Game;
import bzh.amzerin.openD6.bo.Member;
import bzh.amzerin.openD6.dal.GameDao;
import bzh.amzerin.openD6.security.UtilisateurSpringSecurity;
import bzh.amzerin.openD6.service.GameService;
import lombok.AllArgsConstructor;

@Service
@Profile("mock")
@AllArgsConstructor
public class GameServiceMock implements GameService{
	
	private GameDao gameDao;
	
	@Override
	public List<Game> getGames() {
		return gameDao.getGames();
	}

	@Override
	public Game getGameById(int id) {
		return gameDao.getGameById(id);
	}

	@Override
	public void createGame(Game game) {
		gameDao.createGame(game);
	}

	@Override
	public void deleteGameById(int id) {
		gameDao.deleteGameById(id);
	}

}
