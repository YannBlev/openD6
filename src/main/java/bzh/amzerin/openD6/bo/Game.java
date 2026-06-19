package bzh.amzerin.openD6.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
	
	private int id;
	private String name;
	private Universe universe;
	private String summary;
	private Member gameMaster;
	private List<Member> players = new ArrayList<>();
	private List<Character> characters = new ArrayList<>();

	public Game(int id, String name, Universe universe, String summary, Member gameMaster, List<Member> players) {
		this.id = id;
		this.name = name;
		this.universe = universe;
		this.summary = summary;
		this.gameMaster = gameMaster;
		this.players = players;
	}
}
