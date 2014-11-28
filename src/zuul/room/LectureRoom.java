package zuul.room;

import 	java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import zuul.Game;
import zuul.course.LabItem;
import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LectureRoom extends StudySpace {
	private int nbRoom;

	public LectureRoom(String description, int nbRoom) {
		super(description);
		coursInThisRoom = new LectureItem();
		this.nbRoom = nbRoom;

	}

	@Override
	public boolean canEnter(Student student){
		return true;
	}

	public boolean mustEnter(Student student){
		if (coursInThisRoom.getModule().equals("OOP")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean enter(Student student){
		//test
		if (nbRoom == 1) coursInThisRoom = Game.lectures.get(0);
		else if (nbRoom == 2) coursInThisRoom = Game.lectures.get(3);
		else coursInThisRoom = Game.lectures.get(6);

		if (mustEnter(student)){
			attendLecture(student);
			System.out.println(getLongDescription());
		} else {
			System.out.println(getLongDescription());
		}
		return true;
	}

	@Override
	public void randomizeCourses(){
		int rand = (int) (Math.random() * Game.NB_COURSES);

		LectureItem lecture = Game.lectures.get(rand);
		coursInThisRoom = lecture;
	}

	private void doLecture(){
		if (nbRoom == 1){
			System.out.println(Game.res.getString("oop.lecture1"));
		} else if (nbRoom == 2) {
			System.out.println(Game.res.getString("oop.lecture2"));
		} else {
			System.out.println(Game.res.getString("oop.lecture3"));
		}
	}


	public void attendLecture(Student goodStudent) {
		System.out.println(Game.res.getString("lectureroom.attendlecture.part1")
				+ coursInThisRoom.getModule()
				+ Game.res.getString("room.attend.part2")
				+ coursInThisRoom.getNumber()
				+ Game.res.getString("room.attend.part3"));
		try {
			System.out.println(Game.res.getString("oop.lecture"));
			Thread.sleep(3000);
			doLecture();
			Thread.sleep(3000);
			System.out.println(Game.res.getString("oop.lectureend"));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Game.res.getString("lectureroom.attendlecture.part4"));
		goodStudent.decrementEnergy(10);
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
				+ Game.res.getString("lectureroom.description2")
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
