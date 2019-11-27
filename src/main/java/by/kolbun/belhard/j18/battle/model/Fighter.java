package by.kolbun.belhard.j18.battle.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Fighter extends Player implements Runnable {

	private final Weapon weapon;

	private int currentHp;

	@Setter
	private Fighter target;

	public Fighter(Player player, Weapon weapon) {

		super(player);
		this.weapon = weapon;
		this.currentHp = player.getMaxHp();
	}

	@Override
	public void run() {

		try {
			while (currentHp > 0 && !target.isDead()) {
				Thread.sleep(weapon.getCooldown());
				if (!this.isDead())
					hit(target);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (currentHp <= 0)
			System.err.printf("%s is DEAD!\n", this.getName());
	}

	@Override
	public String toString() {

		return String.format("%s [%d/%d]", this.getName(), this.getCurrentHp(), this.getMaxHp());
	}

	public boolean isDead() {

		return currentHp <= 0;
	}

	public void hit(Fighter target) {

		int damage = weapon.calculateHitDamage();
		target.damage(damage);
		System.out.printf("%d :: %s hits %s with %d damage\n", System.currentTimeMillis() / 1000 % 100, this, target, damage);
	}

	private void damage(int damage) {

		currentHp -= damage;
	}

	public String info() {

		return toString() + " wearing " + weapon;
	}
}
