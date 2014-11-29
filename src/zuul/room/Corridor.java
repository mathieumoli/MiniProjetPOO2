package zuul.room;

import zuul.Game;
import zuul.foundobject.Cheatsheet;
import zuul.foundobject.Tablet;
import zuul.person.Student;

import java.util.Random;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class Corridor extends Room {
	private boolean lights, tablet, cheatsheet;
	private Tablet tabletInTheCorridor;
	private Cheatsheet cheatsheetInTheCorridor;

	public Corridor(String description) {
		super(description);
		Random randomLight = new Random();
		randomLight.nextBoolean();

		lights = (randomLight.nextBoolean()) ? true : false;

	}

	public void appearObject() {
		int chance1 = (int) (Math.random() * 20);
		tablet = (chance1 > 14) ? true : false;
		int chance2 = (int) (Math.random() * 20);
		cheatsheet = (chance2 > 17) ? true : false;

	}

	@Override
	public boolean canEnter(Student student) {
		return true;
	}

	@Override
	public boolean enter(Student student) {
		if (isLights()) {
			appearObject();
			if (tablet) {
				tabletInTheCorridor = new Tablet();
				System.out.println(Game.res.getString("corridor.tablet"));
			}
			if (cheatsheet) {
				cheatsheetInTheCorridor = new Cheatsheet();
				System.out.println(Game.res.getString("corridor.cheatsheet"));
			}
			System.out.println(getLongDescription());
		} else {
			System.out.println(Game.res.getString("corridor.dark"));
			System.out.println(getExitString());
		}

		return true;
	}

	public void useTablet(Student student) {
		if(tablet){
			tabletInTheCorridor.useObject(student);
			tablet = false;
		} else {
			System.out.println(Game.res.getString("corridor.notablet"));
		}
		System.out.println(this.getLongDescription());
	}

	public void useCheatsheet(Student student) {
		if(cheatsheet){
			cheatsheetInTheCorridor.useObject(student);
			cheatsheet = false;
		} else{
			System.out.println(Game.res.getString("corridor.nocheatsheet"));
		}
		System.out.println(this.getLongDescription());
	}

	/**
	 * Corridors which give access to some rooms. Switches turn lights on an
	 * off. Things can't be seen in unlit corridors and so can't be picked up.
	 *
	 * Tablets. Reading a tablet opens (randomly): an on-line lecture or lab
	 * session which allows you to pick up the equivalent lesson or lab session
	 * without having to attend the class. But the course still has to come
	 * before the lab session. a video game which makes the student forget one
	 * (random) lecture. Unless the game is World of Zuul.
	 *
	 * Cheat sheets containing the answers to the exam questions (probably found
	 * on a photocopier).
	 *
	 * TO DO : turnLightsOn(),
	 */

	public void turnLightsOn() {
		lights = true;
	}

	/**
	 * @return the lights
	 */
	public boolean isLights() {
		return lights;
	}

	/**
	 * @param lights
	 *            the lights to set
	 */
	public void setLights(boolean lights) {
		this.lights = lights;
	}
}
