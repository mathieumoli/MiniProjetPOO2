package zuul.room;

import java.util.ArrayList;

import zuul.Game;
import zuul.course.LectureItem;
import zuul.person.Student;


/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Library extends Room {

	boolean isOpen = false;
	

	private ArrayList<LectureItem> poo2Book;

	public Library(String description) {
		super(description);
		poo2Book=new ArrayList<LectureItem>();

		LectureItem poo2BookPage1 = new LectureItem("OOP", 1,"oop.lecture1");
		LectureItem poo2BookPage2 = new LectureItem("OOP", 2,"oop.lecture2");
		LectureItem poo2BookPage3 = new LectureItem("OOP", 3,"oop.lecture3");
		poo2Book.add(poo2BookPage1);
		poo2Book.add(poo2BookPage2);
		poo2Book.add(poo2BookPage3);

	}

	/**
	 * This function determines if the student can enter the library or not
	 * @param student
	 * @return
	 */
	public boolean canEnter(Student student){
		return isOpen();
	}

	/**
	 *
	 * @param student
	 * @return
	 */
	public boolean enter(Student student){
		if (canEnter(student)){
			System.out.println(Game.res.getString("library.description")+"\n"+getExitString());

			return true;
		}
		System.out.println(Game.res.getString("library.closed"));
		return false;
	}
    
    public boolean isOpen(){
    	int random = (int)(Math.random() * 10);

	    isOpen = random > 7;
		return isOpen;
    }

    public void takeBook(Student student){
    	student.setOOPbook(poo2Book);
    	System.out.println(Game.res.getString("library.takebook")+"\n"+getExitString());
    }


	public void learnPOO(Student goodStudent) {
		int sizeBook = poo2Book.size();
		for (int i = 0; i < sizeBook; i++) {
			if (!goodStudent.alreadyListenedLecture(poo2Book.get(i))) {
				goodStudent.addItem(poo2Book.get(i));
				System.out.println(Game.res.getString(poo2Book.get(i).getBundleKey())+"\n");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		goodStudent.decrementEnergy(35);
		System.out.println(getExitString());

	}
}
