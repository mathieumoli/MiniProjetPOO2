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

	/**
	 * The student takes a coffee which allows him to gain 20 points of energy
	 * @param gamer
	 */
	public void takeCoffee(Student gamer) {
		gamer.incrementEnergy(20);

	}

	/**
	 * This function determines if the student can enter the lunchroom or not
	 * @param student
	 * @return
	 */
	@Override
	public boolean canEnter(Student student) {
		return true;
	}

	/**
	 * This function determines what the student can do when he enters the room.
	 * Here, there is a probability that the student plays babyfoot
	 * @param student
	 * @return
	 */
	@Override
	public boolean enter(Student student) {
		
		int random = (int) (Math.random() * 10);
		playBabyFoot = random > 7;
		
		if (playBabyFoot) {
			System.out.println(Game.res.getString("lunchroom.babyFoot"));
			student.decrementEnergy(30);
			student.removeItem();
			System.out.println(getExitString());
		} else {
			System.out.println(getLongDescription());
		}

		return true;

	}
}
