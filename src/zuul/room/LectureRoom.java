package zuul.room;

import java.util.ResourceBundle;

import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LectureRoom extends StudySpace {
	LectureItem lecture;

	public LectureRoom(String description) {
		super(description);
		lecture = new LectureItem();

	}

	public LectureRoom(String description, LectureItem cours) {
		super(description);
		lecture = cours;

	}

	public void attendLecture(Student goodStudent,ResourceBundle res) {
		System.out.println(res.getString("lectureroom.attendlecture.part1") + lecture.getModule() + res.getString("room.attend.part2")
				+ lecture.getNumber() + res.getString("room.attend.part3"));
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
		goodStudent.addItem(lecture);
		
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
