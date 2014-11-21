package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class Item {
	protected String name;
	protected String module;
	protected int number;
	
	public Item() {
		name = "default";
		module = "default";
		number = 0;
	}
	
	public Item(String thename,String themodule,int thenumber){
		name=thename;
		module=themodule;
		number=thenumber;
		}
	
	
}
