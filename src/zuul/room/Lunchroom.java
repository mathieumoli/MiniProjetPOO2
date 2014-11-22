package zuul.room;

import zuul.person.Student;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Lunchroom extends Room {
    public Lunchroom(String description){
        super(description);
    }

	public void takeCoffee(Student gamer) {
		gamer.incrementEnergy();
		
	}

    /**
     * Lunchroom containing a table football (babyfoot) game. Entering this room, the student has some probability
     * of playing table football; playing table football makes the student forget one (random) lecture.
     * However, this is the only place where the student can drink coffee.
     *
     * Coffee. Drinking coffee increases your energy level.
     * TO DO : enter()
     */
}
