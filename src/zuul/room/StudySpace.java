package zuul.room;

import java.util.ResourceBundle;

import zuul.course.Item;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public abstract class StudySpace extends Room{
	protected Item coursInThisRoom;
	protected ResourceBundle res;
	
	public StudySpace(String description,ResourceBundle reso) {
		super(description);
		coursInThisRoom= new Item();
		res=reso;
	}
	
	public StudySpace(String description,Item itemInThisRoom,ResourceBundle reso) {
		super(description);
		coursInThisRoom= itemInThisRoom;
		res=reso;
	}

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
