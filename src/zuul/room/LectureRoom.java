package zuul.room;

import zuul.Game;
import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LectureRoom extends StudySpace {
	private int nbRoom;

	public LectureRoom(String description, int nbRoom) {
		super(description, nbRoom);
		coursInThisRoom = new LectureItem();
		this.nbRoom = nbRoom;

	}

	/**
	 * This function determines if the student can enter the lectureroom or not
	 * 
	 * @param student
	 * @return
	 */
	@Override
	public boolean canEnter(Student student) {
		return true;
	}

	public boolean mustEnter(Student student) {
		return super.mustEnter(student);
	}

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
		if (!(coursInThisRoom.getNumber() == 0)) {
			randomizeCourses();
		}
		return true;
	}

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
					+ Game.res.getString(coursInThisRoom.getBundleKey())+"\n"+ getExitString();
		} else if (isAttend) {
			return getExitString();
		} else
			return description + coursInThisRoom.getModule() + " numero "
					+ coursInThisRoom.getNumberString() + ".\n"
					+ Game.res.getString("lectureroom.description2")
					+ getExitString();
	}

}
