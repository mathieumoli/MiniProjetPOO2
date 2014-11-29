package zuul.foundobject;

import zuul.Game;
import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 29/11/2014
 */
public class Tablet implements FoundObject {
	private LectureItem coursInThisTablet;

	public Tablet() {
		addStuff();

	}

	public void addStuff() {
		int nbCours = Game.lectures.size() - 1;
		int alea = (int) (Math.random() * nbCours);
		coursInThisTablet = Game.lectures.get(alea);
	}

	public void useObject(Student student){
		System.out.println(Game.res.getString("tablet.on"));
		int chance = (int) (Math.random() * 10);
		if(chance > 7)
			playZuul(student);
		else if(chance <= 7 && chance > 3)
			learnLecture(student);
		else
			playAppli(student);
		
	}

	private void playAppli(Student student) {
		System.out.println(Game.res.getString("tablet.appli"));
		student.decrementEnergy(30);
		student.removeItem();		
	}

	public void playZuul(Student student) {
		System.out.println(Game.res.getString("tablet.zuul"));
		student.decrementEnergy(15);
	}

	public void learnLecture(Student student) {
		addStuff();
		System.out.println(Game.res.getString("tablet.lecture"));
		System.out.println(Game.res.getString(coursInThisTablet.getBundleKey().toString()));
		student.decrementEnergy(10);
		student.addItem(coursInThisTablet);

	}
}
