package zuul.room;

import java.util.ResourceBundle;

import zuul.course.Item;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public abstract class StudySpace extends Room {
	protected Item coursInThisRoom;
	protected int nbRoom;
	protected boolean isAttend;
	
	public StudySpace(String description,int nbRoom) {
		super(description);
		coursInThisRoom = new Item();
		this.nbRoom=nbRoom;
	}
	
	public StudySpace(String description,Item itemInThisRoom) {
		super(description);
		coursInThisRoom = itemInThisRoom;
	}

	public abstract void randomizeCourses();

	/**
	 * @return the coursInThisRoom
	 */
	public Item getCoursInThisRoom() {
		return coursInThisRoom;
	}

	/**
	 * @param coursInThisRoom the coursInThisRoom to set
	 */
	public void setCoursInThisRoom(Item coursInThisRoom) {
		this.coursInThisRoom = coursInThisRoom;
	}

}
