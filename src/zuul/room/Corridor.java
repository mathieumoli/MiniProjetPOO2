package zuul.room;

public class Corridor extends Room {
	private boolean switchTheLight;

	public Corridor(String description) {
		super(description);
		// pour commencer on met la lumiere eteinte on verra par la suite si on
		// fait un random pour que la lumiere soit ouverte ou éteinte
		switchTheLight = false;
	}

}
