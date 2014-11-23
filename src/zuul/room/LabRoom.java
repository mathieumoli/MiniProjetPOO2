package zuul.room;

import java.util.ResourceBundle;

import zuul.course.LabItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LabRoom extends StudySpace {
	
	public LabRoom(String description,ResourceBundle reso) {
		super(description,reso);
		coursInThisRoom=new LabItem();
	}
	
	public LabRoom(String description,LabItem lab,ResourceBundle reso) {
		super(description,lab,reso);
	}
	
	public void attendLab(Student goodStudent) {
		System.out.println(res.getString("labroom.attendlab.part1") + coursInThisRoom.getModule() + res.getString("room.attend.part2")
				+ coursInThisRoom.getNumber() + res.getString("room.attend.part3"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println(res.getString("labroom.attendlab.part4"));
		goodStudent.decrementEnergy();
		goodStudent.addItem(coursInThisRoom);
		
	}
	
	/**
	 * Return a description of the room in the form: You are in the kitchen.
	 * Exits: north west
	 * 
	 * @return A long description of this room
	 */
	@Override
	public String getLongDescription() {
		return description
				+ coursInThisRoom.getModule() + " numero "
				+ coursInThisRoom.getNumberString()+ ".\n"
				+ res.getString("labroom.description2") + "\n"
				+ getExitString();
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
