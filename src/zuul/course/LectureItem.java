package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LectureItem extends Item {
	
	public LectureItem(){
		super();
	}

	public LectureItem(String module, int number) {
		super(module, number);
	}
	
	@Override
	public boolean equals(Object object){
		boolean equality=false;
		if(object instanceof LectureItem)
		{
			if(this.module.equals(((LectureItem) object).module))
			{
				
					if(this.number==((LectureItem) object).number)
					{
						return true;
					}
				
			}
		}
		return equality;
	}
}
