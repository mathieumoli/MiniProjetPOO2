package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */

public class LabItem extends Item {

	@Override
	public boolean equals(Object object){
		boolean equality=false;
		if(object instanceOf LabItem)
		{
			if(this.module.equals(object.module))
			{
				if(this.name.equals(object.name)
				{
					if(this.number==object.number)
					{
						return true;
					}
				}
			}
		}
		return equality;
	}
	
}
