package zuul.room;

import zuul.course.Item;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public abstract class StudySpace extends Room{
	protected Item coursInThisRoom;
	public StudySpace(String description) {
		super(description);
		coursInThisRoom= new Item();
	}

}
