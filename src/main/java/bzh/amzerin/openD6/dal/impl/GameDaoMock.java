package bzh.amzerin.openD6.dal.impl;

import java.util.ArrayList;
import java.util.List;

import bzh.amzerin.openD6.bo.Member;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import bzh.amzerin.openD6.bo.Game;
import bzh.amzerin.openD6.dal.GameDao;

@Repository
@AllArgsConstructor
@Profile("mock")
public class GameDaoMock implements GameDao{

	private static final List<Game> games = new ArrayList<>();
	private static int indexGame = 1;
	private UniverseDaoMock universeDaoMock;
	private MemberDaoMock memberDaoMock;

	@PostConstruct
	public void init() {
		if (games.isEmpty()) {
			List<Member> players = new ArrayList<>();
			players.add(memberDaoMock.getMemberById(2));

			Game game = new Game(
					indexGame ++,
					"The dark side",
					universeDaoMock.getUniverseById(1),
					"Welcome in the dark",
					memberDaoMock.getMemberById(1),
					players
			);

			games.add(game);

		}
	}

	@Override
	public List<Game> getGames() {
		return games;
	}

	@Override
	public Game getGameById(int id) {
	    return games.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);
	}

	@Override
	public void createGame(Game game) {
		game.setId(indexGame);
		games.add(game);
		indexGame++;
	}

	@Override
	public void deleteGameById(int id) {
		games.remove(id);
	}

}
