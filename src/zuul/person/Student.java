package zuul.person;

import java.util.ArrayList;

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
	
	public Student(){
		energy=100;
		name="Jacky";
		coursSuivi=new ArrayList<LectureItem>();
		labsSuivi=new ArrayList<LabItem>();
	}
	
	public Student(String nameOfStudent){
		energy=100;
		name=nameOfStudent;
		coursSuivi=new ArrayList<LectureItem>();
		labsSuivi=new ArrayList<LabItem>();
	}
	
	public void addItem(Item itemListened){
		if(itemListened instanceof LabItem)
			labsSuivi.add((LabItem) itemListened);
		else
			coursSuivi.add((LectureItem) itemListened);
	}
	
	public void decrementEnergy(){
		if(energy>10)
		{
		energy-=10;
		}
		else
			energy=0;
	}
	
	public void incrementEnergy(){
		energy+=20;
		if (energy>100)
		{
			energy=100;
		}
	}
	
	public boolean alreadyListened(Item theItem){
		if(theItem instanceof LabItem)
		{
			return labsSuivi.contains(theItem);
		}
		else
		{
			return coursSuivi.contains(theItem);
		}
	
	}

	public void getEnergy() {
		// TODO Auto-generated method stub
		
	}

}
