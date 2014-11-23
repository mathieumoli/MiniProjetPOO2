package zuul.person;

import java.util.ArrayList;
import java.util.ResourceBundle;

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
	public static ResourceBundle res;

	public Student(ResourceBundle resource) {
		energy = 100;
		name = "Jacky";
		coursSuivi = new ArrayList<LectureItem>();
		labsSuivi = new ArrayList<LabItem>();
		res=resource;
	}

	public Student(String nameOfStudent) {
		energy = 100;
		name = nameOfStudent;
		coursSuivi = new ArrayList<LectureItem>();
		labsSuivi = new ArrayList<LabItem>();
	}

	public void addItem(Item itemListened) {
		if (itemListened instanceof LabItem){
			labsSuivi.add((LabItem) itemListened);
		System.out.println(this.name + res.getString("student.addLab.part1")
				+ itemListened.getModule() + res.getString("student.add.part2")
				+ itemListened.getNumberString());}
		else
		{
			coursSuivi.add((LectureItem) itemListened);
			System.out.println(this.name + res.getString("student.addLecture.part1")
					+ itemListened.getModule() + res.getString("student.add.part2")
					+ itemListened.getNumberString());
		}
	}

	public void decrementEnergy() {
		if (energy > 10) {
			energy -= 10;
		} else
			energy = 0;
		System.out.println(res.getString("student.energy.part1") + this.name
				+ res.getString("student.energy.part2")
				+ this.getEnergyString());
	}

	public void incrementEnergy() {
		energy += 20;
		if (energy > 100) {
			energy = 100;
		}
		
		System.out.println(res.getString("student.energy.part1") + this.name
				+ res.getString("student.energy.part2")
				+ this.getEnergyString()+".");
	}

	public boolean alreadyListened(Item theItem) {
		if (theItem instanceof LabItem) {
			return labsSuivi.contains(theItem);
		} else {
			return coursSuivi.contains(theItem);
		}

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

}
