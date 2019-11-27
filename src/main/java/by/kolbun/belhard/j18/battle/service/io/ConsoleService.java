package by.kolbun.belhard.j18.battle.service.io;

import by.kolbun.belhard.j18.battle.model.Battle;
import by.kolbun.belhard.j18.battle.model.Fighter;
import by.kolbun.belhard.j18.battle.model.Player;
import by.kolbun.belhard.j18.battle.model.Weapon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleService {

	private static final String WELCOME_MESSAGE =
			"\n" +
					"##################################\n" +
					"#### !WELCOME TO BATTLE GAME! ####\n" +
					"############ continue ############\n" +
					"##################################\n\n";

	private static final String MAIN_LEGEND =
			"\n" +
					"1) choose 1st fighter: #1\n" +
					"2) choose 2nd fighter: #2\n" +
					"3) see statistics\n" +
					"4) FIGHT!\n";

	private static final BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));

	public void printWelcomeMessage() {

		System.out.println(WELCOME_MESSAGE);
	}

	public void printMainLegend(Battle battle) {

		System.out.println(
				MAIN_LEGEND
						.replaceFirst("#1", battle.getFighter1() != null ? battle.getFighter1().info() : "none")
						.replaceFirst("#2", battle.getFighter2() != null ? battle.getFighter2().info() : "none")
		);
	}

	public String getInput() {

		String input = null;
		try {
			input = rdr.readLine();
		} catch (IOException e) {
			System.err.println("Error while input");
			e.printStackTrace();
		}

		return input;
	}

	public int getInputInteger() {

		return Integer.parseInt(getInput());
	}

	public Fighter chooseFigther(List<Player> players, List<Weapon> weapons) {

		System.out.println("Choose fighter:");
		int chosenPlayer = makeChoice(players);

		System.out.println("Choose weapon:");
		int chosenWeapon = makeChoice(weapons);

		return new Fighter(players.get(chosenPlayer), weapons.get(chosenWeapon));
	}

	private int makeChoice(List items) {

		for (int i = 0; i < items.size(); i++)
			System.out.printf("%d) %s\n", i + 1, items.get(i));

		return getInputInteger() - 1;
	}
}
