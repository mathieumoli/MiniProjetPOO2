package zuul.room;

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
		super(description, nbRoom);
		coursInThisRoom = new LabItem();

	}

	/**
	 * This function determines if the student can enter the labroom or not the
	 * student can't enter if he didn't attend the respective lecture
	 * 
	 * @param student
	 * @return
	 */
	@Override
	public boolean canEnter(Student student) {
		if (coursInThisRoom.getNumber() == 0) {
			return true;
		} else if (!student.alreadyListenedLecture(new LectureItem(
				coursInThisRoom.getModule(), coursInThisRoom.getNumber()))) {
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
		return super.mustEnter(student);
	}

	@Override
	public boolean enter(Student student) {
		randomizeCourses();

		isAttend = false;

		if (canEnter(student)) {
			if (coursInThisRoom.getNumber() == 0) {
				System.out.println(getLongDescription());
			}
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
		if (nbRoom == 1)
			coursInThisRoom = Game.labs.get((int) (Math.random() * (3-0)+0));
		else if (nbRoom == 2)
			coursInThisRoom = Game.labs
					.get((int) (Math.random() * (6 - 3) + 3));

		else
			coursInThisRoom = Game.labs
					.get((int) (Math.random() * (9 - 6) + 6));

		int noCours = (int) (Math.random() * 9);
		if (noCours > 6) {
			coursInThisRoom = new LectureItem();
		}
	}

	public void attendLab(Student goodStudent) {
		if (coursInThisRoom.getNumber() != 0) {
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
			return Game.res.getString("labroom.shortdescription")
					+ Game.res.getString(coursInThisRoom.getBundleKey()) + "\n"
					+ getExitString();
		} else if (isAttend) {
			return getExitString();
		} else
			return description + coursInThisRoom.getModule() + " numero "
					+ coursInThisRoom.getNumberString() + ".\n"
					+ Game.res.getString("labroom.description2") + "\n"
					+ getExitString();
	}

}
