package by.kolbun.belhard.j18.battle;

import by.kolbun.belhard.j18.battle.model.Battle;
import by.kolbun.belhard.j18.battle.model.Fighter;
import by.kolbun.belhard.j18.battle.model.Player;
import by.kolbun.belhard.j18.battle.model.Weapon;
import by.kolbun.belhard.j18.battle.repository.ConnectionManager;
import by.kolbun.belhard.j18.battle.repository.PlayersRepository;
import by.kolbun.belhard.j18.battle.repository.WeaponRepository;
import by.kolbun.belhard.j18.battle.service.io.ConsoleService;

import java.util.List;

public class GameApp {

	private Battle battle;

	private final PlayersRepository playersRepository;
	private final WeaponRepository weaponRepository;

	private List<Player> players;
	private List<Weapon> weapons;

	private final ConsoleService consoleService;

	public GameApp() {

		this.consoleService = new ConsoleService();
		this.playersRepository = new PlayersRepository();
		this.weaponRepository = new WeaponRepository();

	}

	public void runApplication() {

		prepareApplication();

		consoleService.printWelcomeMessage();

		battle = new Battle();

		while (true) {

			if (battle.isDone())
				battle = new Battle();

			consoleService.printMainLegend(battle);
			switch (consoleService.getInput()) {
			case "1":
				Fighter fighter1 = consoleService.chooseFigther(players, weapons);
				battle.setFighter1(fighter1);
				break;
			case "2":
				Fighter fighter2 = consoleService.chooseFigther(players, weapons);
				battle.setFighter2(fighter2);
				break;
			case "3":
				//				consoleService.printStatistics(battleRepository.getStatistics());
				break;
			case "4":
				if (battle.isReady())
					resultsPrintAndSave(battle.fight());
				else
					System.out.println("Choose fighters before!");
				break;
			default:
				System.out.println("Wrong input");
				break;
			}
		}

	}

	private void resultsPrintAndSave(Fighter winner) {

		System.out.printf("%s wins this battle!\n", winner != null ? winner : "Nobody ");
	}

	private void prepareApplication() {

		new ConnectionManager();

		this.players = playersRepository.getAllPlayers();

		this.weapons = weaponRepository.getAllWeapons();
	}

}
