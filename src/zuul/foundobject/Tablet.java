package zuul.foundobject;

import zuul.Game;
import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 29/11/2014
 */
public class Tablet {
	private LectureItem coursInThisTablet;

	public Tablet() {
		downloadLecture();

	}

	public void downloadLecture() {
		int nbCours = Game.lectures.size() - 1;
		int alea = (int) (Math.random() * nbCours);
		coursInThisTablet = Game.lectures.get(alea);
	}

	public void useTablet(Student student){
		System.out.println(Game.res.getString("tablet.on"));
		int chance= (int) (Math.random() * 10);
		if(chance > 5)
			playZuul(student);
		else
			learnLecture(student);
		
	}

	public void playZuul(Student student) {
		System.out.println(Game.res.getString("tablet.zuul"));
		student.removeItem();

	}

	public void learnLecture(Student student) {
		downloadLecture();
		System.out.println(Game.res.getString("tablet.lecture"));
		student.decrementEnergy(10);
		student.addItem(coursInThisTablet);

	}
}
