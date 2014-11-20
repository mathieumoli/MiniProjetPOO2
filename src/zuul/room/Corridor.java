package zuul.room;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class Corridor extends Room {
	private boolean switchTheLight;

	public Corridor(String description) {
		super(description);
		// pour commencer on met la lumiere eteinte on verra par la suite si on
		// fait un random pour que la lumiere soit ouverte ou éteinte
		switchTheLight = false;
	}

}
