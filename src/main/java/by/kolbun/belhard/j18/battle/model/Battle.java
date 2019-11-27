package by.kolbun.belhard.j18.battle.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Battle {

	private boolean done = false;

	private Fighter fighter1;
	private Fighter fighter2;

	public Fighter fight() {

		fighter1.setTarget(fighter2);
		fighter2.setTarget(fighter1);

		Thread f1 = new Thread(fighter1);
		Thread f2 = new Thread(fighter2);

		f1.start();
		f2.start();

		try {
			f1.join();
			f2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		done = true;

		return (fighter1.isDead() & fighter2.isDead()) ? null : fighter1.isDead() ? fighter2 : fighter1;
	}

	public boolean isReady() {

		return fighter1 != null && fighter2 != null;
	}
}
