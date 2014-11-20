package zuul.room;

import zuul.course.LectureItem;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LectureRoom extends StudySpace {
	
	
	public LectureRoom(String description, LectureItem lect) {
		super(description);
		coursInThisRoom=lect;
	}

}
