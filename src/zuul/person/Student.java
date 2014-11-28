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
			if (!alreadyListenedLab(new LabItem(itemListened.getModule(),
					itemListened.getNumber()))){
				labsSuivi.add((LabItem) itemListened);}
			System.out.println(this.name
					+ Game.res.getString("student.addLab.part1")
					+ itemListened.getModule()
					+ Game.res.getString("student.add.part2")
					+ itemListened.getNumberString());
		} else {
			if (!alreadyListenedLecture(new LectureItem(itemListened.getModule(),
					itemListened.getNumber()))){
			coursSuivi.add((LectureItem) itemListened);}
			System.out.println(this.name
					+ Game.res.getString("student.addLecture.part1")
					+ itemListened.getModule()
					+ Game.res.getString("student.add.part2")
					+ itemListened.getNumberString());
		}
	}

	public void decrementEnergy(int theEnergy) {
		if (energy > 10) {
			energy -= theEnergy;
		} else {
			energy = 0;
		}
		System.out.println(Game.res.getString("student.energy.part1")
				+ this.name + Game.res.getString("student.energy.part2")
				+ this.getEnergyString());
	}

	public void incrementEnergy(int theEnergy) {
		energy += theEnergy;
		if (energy > 100) {
			energy = 100;
		}

		System.out.println(Game.res.getString("student.energy.part1")
				+ this.name + Game.res.getString("student.energy.part2")
				+ this.getEnergyString() + ".");
	}

	public boolean alreadyListenedLab(LabItem theItem) {
		boolean listened = false;
		int i;
		int size = labsSuivi.size();
			for (i = 0; i < size; i++) {
				listened = theItem.equals(labsSuivi.get(i));
				if(listened)break;
			}
		
		return listened;

	}

	public boolean alreadyListenedLecture(LectureItem theItem) {
		boolean listened = false;
		int i;
		int size= coursSuivi.size();
			
			for (i = 0; i < size; i++) {
				listened = theItem.equals(coursSuivi.get(i));
				if(listened)break;
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
		LabItem lab;
		if (!coursSuivi.isEmpty()) {
			int taille = coursSuivi.size() - 1;

			int index = (int) (Math.random() * taille);
			System.out.println(Game.res.getString("student.removeLecture1")+coursSuivi.get(index).getModule()+Game.res.getString("student.removeLecture2")+coursSuivi.get(index).getNumberString());
			lab=new LabItem(coursSuivi.get(index).getModule(),coursSuivi.get(index).getNumber());
			coursSuivi.remove(index);
			
			if (labsSuivi.contains(lab)) {
				int indexOfRem=labsSuivi.indexOf(lab);
				

				System.out.println(Game.res.getString("student.removeLab1")+labsSuivi.get(indexOfRem).getModule()+Game.res.getString("student.removeLecture2")+labsSuivi.get(indexOfRem).getNumberString());
				labsSuivi.remove(indexOfRem);
			}
		}
	}
}