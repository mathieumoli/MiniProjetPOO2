package zuul.person;

import java.util.ArrayList;
import java.util.ResourceBundle;

import zuul.Game;
import zuul.course.Item;
import zuul.course.LabItem;
import zuul.course.LectureItem;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class Student {

	private int energy;
	private String name;
	private ArrayList<LectureItem> coursSuivi;
	private ArrayList<LabItem> labsSuivi;

	public Student(String nameOfStudent) {
		energy = 100;
		name = nameOfStudent;
		coursSuivi = new ArrayList<LectureItem>();
		labsSuivi = new ArrayList<LabItem>();
	}

	public void addItem(Item itemListened) {
		if (itemListened instanceof LabItem) {
			if (alreadyListened(new Item(itemListened.getModule(),
					itemListened.getNumber())))
				labsSuivi.add((LabItem) itemListened);
			System.out.println(this.name
					+ Game.res.getString("student.addLab.part1")
					+ itemListened.getModule()
					+ Game.res.getString("student.add.part2")
					+ itemListened.getNumberString());
		} else {
			coursSuivi.add((LectureItem) itemListened);
			System.out.println(this.name
					+ Game.res.getString("student.addLecture.part1")
					+ itemListened.getModule()
					+ Game.res.getString("student.add.part2")
					+ itemListened.getNumberString());
		}
	}

	public void decrementEnergy() {
		if (energy > 10) {
			energy -= 10;
		} else {
			energy = 0;
		}
		System.out.println(Game.res.getString("student.energy.part1")
				+ this.name + Game.res.getString("student.energy.part2")
				+ this.getEnergyString());
	}

	public void incrementEnergy() {
		energy += 20;
		if (energy > 100) {
			energy = 100;
		}

		System.out.println(Game.res.getString("student.energy.part1")
				+ this.name + Game.res.getString("student.energy.part2")
				+ this.getEnergyString() + ".");
	}

	public boolean alreadyListened(Item theItem) {
		boolean listened = false;
		int i;
		int size;
		if (theItem instanceof LabItem) {
			size = labsSuivi.size();
			for (i = 0; i < size; i++) {
				listened = labsSuivi.get(i).equals(theItem);
			}
		} else if (theItem instanceof LectureItem) {
			size = coursSuivi.size();
			for (i = 0; i < size; i++) {
				listened = coursSuivi.get(i).equals(theItem);
			}
		}
		return listened;

	}

	public int getEnergy() {
		return energy;

	}

	public String getEnergyString() {
		return Integer.toString(energy);
	}

	public String getName() {
		return name;
	}

	public void removeItem() {

		if (!coursSuivi.isEmpty()) {
			int taille = coursSuivi.size() - 1;

			int index = (int) (Math.random() * taille);
			System.out.println(Game.res.getString("student.removeLecture1")+coursSuivi.get(index).getModule()+Game.res.getString("student.removeLecture2")+coursSuivi.get(index).getNumberString());
			coursSuivi.remove(index);
		}
	}
}