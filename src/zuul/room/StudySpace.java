package zuul.room;

import zuul.course.Item;

public abstract class StudySpace extends Room{
	protected Item coursInThisRoom;
	public StudySpace(String description) {
		super(description);
		coursInThisRoom= new Item();
	}

}
