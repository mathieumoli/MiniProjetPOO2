package zuul.room;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class Corridor extends Room {
	private boolean lights;

	public Corridor(String description) {
		super(description);
		// pour commencer on met la lumiere eteinte on verra par la suite si on
		// fait un random pour que la lumiere soit ouverte ou éteinte
		lights = false;
	}

	/**
	 * Corridors which give access to some rooms. Switches turn lights on an off.
	 * Things can't be seen in  unlit corridors and so can't be picked up.
	 *
	 * Tablets. Reading a tablet opens (randomly):
	 * an on-line lecture or lab session which allows you to pick up the equivalent lesson or lab session
	 * without having to attend the class. But the course still has to come before the lab session.
	 * a video game which makes the student forget one (random) lecture. Unless the game is World of Zuul.
	 *
	 * Cheat sheets containing the answers to the exam questions (probably found on a photocopier).
	 *
	 * TO DO : turnLightsOn(),
	 */

}
