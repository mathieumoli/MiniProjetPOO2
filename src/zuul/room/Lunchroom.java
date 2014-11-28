package zuul.room;

import zuul.Game;
import zuul.person.Student;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Lunchroom extends Room {

	boolean playBabyFoot;

	public Lunchroom(String description) {
		super(description);
	}

	public void takeCoffee(Student gamer) {
		gamer.incrementEnergy(20);

	}

	@Override
	public boolean canEnter(Student student) {
		return true;
	}

	@Override
	public boolean enter(Student student) {
		
		int random = (int) (Math.random() * 10);
		playBabyFoot = (random > 7) ? true : false;
		
		if (playBabyFoot) {
			System.out.println(Game.res.getString("lunchroom.babyFoot"));
			student.decrementEnergy(30);
			student.removeItem();
			System.out.println(getExitString());
		}
		else
		System.out.println(getLongDescription());

		return true;

	}

	/**
	 * Lunchroom containing a table football (babyfoot) game. Entering this
	 * room, the student has some probability of playing table football; playing
	 * table football makes the student forget one (random) lecture. However,
	 * this is the only place where the student can drink coffee.
	 *
	 * Coffee. Drinking coffee increases your energy level. TO DO : enter()
	 */
}
