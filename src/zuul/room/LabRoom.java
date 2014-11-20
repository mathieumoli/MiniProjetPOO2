package zuul.room;

import zuul.course.LabItem;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LabRoom extends StudySpace {
	
	public LabRoom(String description) {
		super(description);
		//coursInThisRoom=lab;
	}

	/**
	 * Labs where lab sessions are running. If the lab is on OOP, the student must do the the lab session.
	 * Doing a lab session means not being able to leave the room until the lab session is finished.
	 * If it's some other course, the student may leave immediately :^) .
	 *
	 * Doing a lab session counts as picking up a lab session item. However, a lab session can only be
	 * done if the corresponding lecture has already been picked up.
	 * Forgetting a lecture means forgetting the corresponding lab session as well.
	 *
	 *
	 * TO DO : enter()
	 */


}
