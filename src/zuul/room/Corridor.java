package zuul.room;

import java.util.Random;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class Corridor extends Room {
	private boolean lights;
	

	public Corridor(String description) {
		super(description);
		 Random random = new Random();
		 random.nextBoolean();
		 
		if(random.nextBoolean()==true)
			lights=true;
		else
			lights=false;
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
	
	public void turnLightsOn(){
		lights=true;
	}

	/**
	 * @return the lights
	 */
	public boolean isLights() {
		return lights;
	}

	/**
	 * @param lights the lights to set
	 */
	public void setLights(boolean lights) {
		this.lights = lights;
	}
	

    
    
}
