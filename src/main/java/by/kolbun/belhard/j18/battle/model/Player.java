package by.kolbun.belhard.j18.battle.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Player {

	private int id;

	private String name;

	private int maxHp;

	public Player(Player player) {

		this.id = player.getId();
		this.name = player.getName();
		this.maxHp = player.getMaxHp();
	}
}
