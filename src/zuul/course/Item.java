package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class Item {
	protected String module;
	protected int number;
	protected String bundleKey;
	
	/**
	 * @return the bundleKey
	 */
	public String getBundleKey() {
		return bundleKey;
	}

	/**
	 * @param bundleKey the bundleKey to set
	 */
	public void setBundleKey(String bundleKey) {
		this.bundleKey = bundleKey;
	}

	public Item() {
		module = "default";
		number = 0;
		bundleKey="room.nothing";
	}
	
	public Item(String themodule, int thenumber){
		module = themodule;
		number = thenumber;
	}

	public Item(String themodule, int thenumber, String key){
		module = themodule;
		number = thenumber;
		bundleKey=key;
	} 
	
	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * @return the number in String format
	 */
	public String getNumberString() {
		return Integer.toString(number);
	}
	

	
	
}
