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
		if(chance > 7)
			playZuul(student);
		else if(chance<=7 && chance>3)
			learnLecture(student);
		else
			playAppli(student);
		
	}

	private void playAppli(Student student) {
		System.out.println(Game.res.getString("tablet.appli"));
		student.removeItem();		
	}

	public void playZuul(Student student) {
		System.out.println(Game.res.getString("tablet.zuul"));
		

	}

	public void learnLecture(Student student) {
		downloadLecture();
		System.out.println(Game.res.getString("tablet.lecture"));
		student.decrementEnergy(10);
		student.addItem(coursInThisTablet);

	}
}
