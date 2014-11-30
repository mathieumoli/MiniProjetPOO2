package zuul.room;

import zuul.Game;
import zuul.course.LabItem;
import zuul.course.LectureItem;
import zuul.person.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class ExamRoom extends Room {
	public static final int NB_QUESTIONS = 3;
	private String exam;
	private List<LectureItem> lectureOOP = new ArrayList<LectureItem>();
	private List<LabItem> labOOP = new ArrayList<LabItem>();

	public ExamRoom(String description) {
		super(description);
	}

	/**
	 * This function determines if the student can enter the examroom or not the
	 * student can't enter if he doesn't have enough energy (50) and if he
	 * didn't attend the oop lectures and the oop labs for an OOP exam
	 *
	 * @param student
	 * @return
	 */
	@Override
	public boolean canEnter(Student student) {
		

		if (student.getEnergy() >= 50) {
			if (exam.equals("OOP")) {
				if (doAllCourses(student) ) {
					return true;
				}
			} else if (exam.equals("C")) {
				return true;
			} else if (exam.equals("ALGO")) {
				return true;
			}
		}
		return false;
	}

	public boolean doAllCourses(Student student) {
		boolean allCourses = false;
		boolean allLabs = false;
		for (int i = 0; i < Game.NB_COURSES; ++i) {
			lectureOOP.add(new LectureItem("OOP", i + 1));
			labOOP.add(new LabItem("OOP", i + 1));
		}
		allCourses = (student.getCoursSuivi().contains(lectureOOP.get(0))
				&& student.getCoursSuivi().contains(lectureOOP.get(1)) && student
				.getCoursSuivi().contains(lectureOOP.get(2)));
		allLabs = (student.getLabsSuivi().contains(labOOP.get(0))
				&& student.getLabsSuivi().contains(labOOP.get(1)) && student
				.getLabsSuivi().contains(labOOP.get(2)));

		if (allCourses == true && allLabs == true)
			return true;
		else
			return false;

	}

	@Override
	public boolean enter(Student student) {
		randomizeExams();
		if (canEnter(student)) {
			System.out.println(Game.res.getString("examroom.description"));
			if (exam.equals("OOP")) {
				System.out.println(Game.res.getString("OOP.exam.description"));
				startExam(student);

			} else {
				System.out.println(Game.res.getString(exam
						+ ".exam.description"));
				System.out.println(getExitString());
			}
		} else {
			System.out.println(Game.res.getString("examroom.cant"));
			return false;
		}
		return true;
	}

	private void randomizeExams() {
		int rand = (int) (Math.random() * Game.NB_COURSES);
		exam = Game.COURSES[rand];
	}

	public void startExam(Student student) {
		int questionsRight = 0;
		String answer;
		Scanner scanner = new Scanner(System.in);

		for (int i = 1; i <= NB_QUESTIONS; ++i) {
			System.out.println(Game.res.getString(exam + ".exam.question" + i));
			answer = scanner.nextLine();
			String rightAnswer = Game.res.getString(exam + ".exam.answer" + i);
			if (answer.toUpperCase().equals(rightAnswer)) {
				++questionsRight;
			}

			System.out.println(Game.res.getString("exam.rightanswer")
					+ rightAnswer);
			System.out.println();
		}

		System.out.println(Game.res.getString("student.youhave")
				+ questionsRight + "/" + NB_QUESTIONS
				+ Game.res.getString("student.answers"));
		if (questionsRight > (NB_QUESTIONS / 2)) {
			System.out.println(Game.res.getString("game.win") + exam + ".");
			student.decrementEnergy(40);
			if (exam.equals("OOP")) {
				System.out.println(Game.res.getString("game.thankyou"));
				System.exit(1);
			}
		} else {
			System.out.println(Game.res.getString("game.lose") + exam
					+ Game.res.getString("game.lose2"));
			student.decrementEnergy(40);
			System.out.println(getExitString());
		}
	}
}
