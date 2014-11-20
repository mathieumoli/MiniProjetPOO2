package zuul.room;

import zuul.course.LectureItem;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LectureRoom extends StudySpace {
	
	
	public LectureRoom(String description) {
		super(description);
		//coursInThisRoom=lect;
	}

	/**
	 * Classrooms where a lecture is being taught. If the lecture is on OOP, the student must listen to the lecture.
	 * Listening to a lecture means not being able to leave the room until the lecture is finished.
	 * If it's some other course, the student may leave immediately :^)
	 *
	 * Listening to a lecture counts as picking up a lecture item.
	 *
	 *
	 * TO DO : enter(),
	 */

}
