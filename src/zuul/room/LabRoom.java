package zuul.room;

import zuul.course.LabItem;

public class LabRoom extends StudySpace {
	
	public LabRoom(String description,LabItem lab) {
		super(description);
		coursInThisRoom=lab;
	}


}
