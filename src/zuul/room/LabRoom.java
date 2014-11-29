package zuul.room;

import java.util.ResourceBundle;

import zuul.Game;
import zuul.course.LabItem;
import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LabRoom extends StudySpace {

	public LabRoom(String description, int nbRoom) {
		super(description,nbRoom);
		coursInThisRoom = new LabItem();
		
	}

	public LabRoom(String description, LabItem lab) {
		super(description, lab);
	}

	/**
	 * the student can't enter if he didn't attend the respective lecture
	 * 
	 * @param student
	 * @return
	 */
	@Override
	public boolean canEnter(Student student) {
		if (!student.alreadyListenedLecture(new LectureItem(coursInThisRoom
				.getModule(), coursInThisRoom.getNumber()))) {
			String string = new String(Game.res.getString("labroom.noattend1")
					+ coursInThisRoom.getModule()
					+ Game.res.getString("labroom.noattend2")
					+ coursInThisRoom.getNumberString());
			System.out.println(string);
			return false;
		}
		return true;
	}

	public boolean mustEnter(Student student) {
		if (coursInThisRoom.getModule().equals("OOP")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean enter(Student student) {
		if (nbRoom == 1) coursInThisRoom = Game.labs.get(0);
		else if (nbRoom == 2) coursInThisRoom = Game.labs.get(3);
		else coursInThisRoom = Game.labs.get(6);
		
		isAttend = false;
		if (canEnter(student)) {
			if (mustEnter(student)) {
				attendLab(student);
				System.out.println(getLongDescription());

			}
			return true;
		} else
			return false;
	}

	@Override
	public void randomizeCourses() {
		int rand = (int) (Math.random() * Game.NB_COURSES);

		LabItem lab = Game.labs.get(rand);
		coursInThisRoom = lab;
	}

	public void attendLab(Student goodStudent) {
		System.out.println(Game.res.getString("labroom.attendlab.part1")
				+ coursInThisRoom.getModule()
				+ Game.res.getString("room.attend.part2")
				+ coursInThisRoom.getNumber()
				+ Game.res.getString("room.attend.part3"));
		try {
			Thread.sleep(3000);
			System.out.println("...");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		isAttend = true;
		System.out.println(Game.res.getString("labroom.attendlab.part4"));
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
		if (isAttend = true) {
			return getExitString();
		} else
			return description + coursInThisRoom.getModule() + " numero "
					+ coursInThisRoom.getNumberString() + ".\n"
					+ Game.res.getString("labroom.description2") + "\n"
					+ getExitString();
	}

	/**
	 * Labs where lab sessions are running. If the lab is on OOP, the student
	 * must do the the lab session. Doing a lab session means not being able to
	 * leave the room until the lab session is finished. If it's some other
	 * course, the student may leave immediately :^) .
	 *
	 * Doing a lab session counts as picking up a lab session item. However, a
	 * lab session can only be done if the corresponding lecture has already
	 * been picked up. Forgetting a lecture means forgetting the corresponding
	 * lab session as well.
	 *
	 *
	 * TO DO : enter()
	 */
}
