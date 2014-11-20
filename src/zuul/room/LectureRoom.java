package zuul.room;

import zuul.course.LectureItem;

public class LectureRoom extends StudySpace {
	
	
	public LectureRoom(String description, LectureItem lect) {
		super(description);
		coursInThisRoom=lect;
	}

}
