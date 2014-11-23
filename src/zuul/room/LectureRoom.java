package zuul.room;

import java.util.ResourceBundle;

import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LectureRoom extends StudySpace {

	public LectureRoom(String description,ResourceBundle reso) {
		super(description,reso);
		coursInThisRoom = new LectureItem();

	}

	public LectureRoom(String description, LectureItem cours,ResourceBundle reso) {
		super(description, cours,reso);

	}

	public void attendLecture(Student goodStudent) {
		System.out.println(res.getString("lectureroom.attendlecture.part1")
				+ coursInThisRoom.getModule()
				+ res.getString("room.attend.part2")
				+ coursInThisRoom.getNumber()
				+ res.getString("room.attend.part3"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println(res.getString("lectureroom.attendlecture.part4"));
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
				+ res.getString("lectureroom.description2")
				+ getExitString();
	}
	/**
	 * Classrooms where a lecture is being taught. If the lecture is on OOP, the
	 * student must listen to the lecture. Listening to a lecture means not
	 * being able to leave the room until the lecture is finished. If it's some
	 * other course, the student may leave immediately :^)
	 *
	 * Listening to a lecture counts as picking up a lecture item.
	 *
	 *
	 * TO DO : enter(),
	 */

}
