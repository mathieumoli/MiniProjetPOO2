package zuul.room;

import zuul.Game;
import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 2014.11.30
 * 
 *          Class to create a LabRoom
 */
public class LectureRoom extends StudySpace {
	private int nbRoom;

	/***
	 * 
	 * Constructor to create a LectureRoom
	 * 
	 * @param description
	 *            the description of the lectureroom
	 * @param nbRoom
	 *            the integer which defines the courses in this lectureroom
	 * 
	 ***/
	public LectureRoom(String description, int nbRoom) {
		super(description, nbRoom);
		coursInThisRoom = new LectureItem();
		this.nbRoom = nbRoom;

	}

	/**
	 * This function determines if the student can enter the lectureroom or not
	 * 
	 * @param student
	 *            who wants enter in the labroom
	 * @return true if the student can enter and false if he can't
	 */
	@Override
	public boolean canEnter(Student student) {
		return true;
	}

	/**
	 * This function determines if the student must enter in the lectureroom (if
	 * the lectureroom contains an OOP lecture) or not the student may enter if
	 * he wants
	 * 
	 * @param student
	 *            the Student who wants enter in this LabRoom
	 * @return true if the student must enter and false if he mustn't
	 */
	public boolean mustEnter(Student student) {
		return super.mustEnter(student);
	}

	/***
	 * 
	 * Method to enter in this lectureroom
	 * 
	 * @param student
	 *            the student who wants to go in
	 * @return true 
	 * 
	 ***/
	@Override
	public boolean enter(Student student) {
		randomizeCourses();
		isAttend = false;
		if (mustEnter(student)) {
			attendLecture(student);
			System.out.println(getLongDescription());
		} else {
			System.out.println(getLongDescription());
		}

		return true;
	}

	/***
	 * 
	 * Method to randomize the lab in the lectureroom (it will have no lab too)
	 * 
	 ***/
	@Override
	public void randomizeCourses() {
		if (nbRoom == 1)
			coursInThisRoom = Game.lectures.get((int) (Math.random() * 2));
		else if (nbRoom == 2)
			coursInThisRoom = Game.lectures
					.get((int) (Math.random() * (5 - 3) + 3));

		else
			coursInThisRoom = Game.lectures
					.get((int) (Math.random() * (8 - 6) + 6));

		int noCours = (int) (Math.random() * 9);
		if (noCours > 6) {
			coursInThisRoom = new LectureItem();
		}

	}

	/***
	 * 
	 * Method to add the ecture of this lecture in the coursSuivi of the student
	 * 
	 * @param goodStudent
	 *            the student who attends the lecture
	 */
	public void attendLecture(Student goodStudent) {
		if (coursInThisRoom.getNumber() != 0) {
			System.out.println(Game.res
					.getString("lectureroom.attendlecture.part1")
					+ coursInThisRoom.getModule()
					+ Game.res.getString("room.attend.part2")
					+ coursInThisRoom.getNumber()
					+ Game.res.getString("room.attend.part3"));
			try {
				System.out.println(Game.res.getString("oop.lecture"));
				Thread.sleep(3000);
				System.out.println(Game.res.getString(coursInThisRoom
						.getBundleKey()));
				Thread.sleep(3000);
				System.out.println(Game.res.getString("oop.lectureend"));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			isAttend = true;
			System.out.println(Game.res
					.getString("lectureroom.attendlecture.part4"));
			goodStudent.decrementEnergy(10);
			goodStudent.addItem(coursInThisRoom);
		} else {
			System.out.println(Game.res.getString(coursInThisRoom
					.getBundleKey()));
		}
	}

	/**
	 * Return a description of the room in the form: You are in the kitchen.
	 * Exits: north west
	 *
	 * @return A long description of this room
	 */
	@Override
	public String getLongDescription() {
		if (coursInThisRoom.getNumber() == 0) {
			return Game.res.getString("lectureroom.shortdescription")
					+ Game.res.getString(coursInThisRoom.getBundleKey()) + "\n"
					+ getExitString();
		} else if (isAttend) {
			return getExitString();
		} else
			return description + coursInThisRoom.getModule() + " numero "
					+ coursInThisRoom.getNumberString() + ".\n"
					+ Game.res.getString("lectureroom.description2")
					+ getExitString();
	}

}
