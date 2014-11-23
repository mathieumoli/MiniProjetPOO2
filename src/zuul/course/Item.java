package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class Item {
	protected String module;
	protected int number;
	
	public Item() {
		module = "default";
		number = 0;
	}
	
	public Item(String themodule,int thenumber){
		module=themodule;
		number=thenumber;
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
