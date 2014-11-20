package zuul.room;

import zuul.course.LabItem;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LabRoom extends StudySpace {
	
	public LabRoom(String description,LabItem lab) {
		super(description);
		coursInThisRoom=lab;
	}


}
