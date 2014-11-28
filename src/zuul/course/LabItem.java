package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */

public class LabItem extends Item {
	
	public LabItem(){
		super();
	}

	public LabItem(String module, int number) {
		super(module, number);
	}

	@Override
	public boolean equals(Object object) {
		boolean equality = false;
		if (object instanceof LabItem) {
			if (this.module.equals(((LabItem) object).getModule())) {

				if (this.number == ((LabItem) object).getNumber()) {
					equality=true;
				}
			}
		}
		return equality;
	}

}
