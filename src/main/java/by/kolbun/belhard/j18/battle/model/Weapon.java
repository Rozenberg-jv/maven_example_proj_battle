package by.kolbun.belhard.j18.battle.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Weapon {

	private int id;

	private String title;

	private int minDmg;

	private int maxDmg;

	private int cooldown;

	public int calculateHitDamage() {

		return minDmg + (int) (Math.random() * (maxDmg - minDmg));
	}

}
