package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LectureItem extends Item {

	@Override
	public boolean equals(Object object){
		boolean equality=false;
		if(object instanceof LabItem)
		{
			if(this.module.equals(((LabItem) object).module))
			{
				
					if(this.number==((LabItem) object).number)
					{
						return true;
					}
				
			}
		}
		return equality;
	}
}
