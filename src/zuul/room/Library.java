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

		LectureItem poo2BookPage1 = new LectureItem("POO", 1);
		LectureItem poo2BookPage2 = new LectureItem("POO", 2);
		LectureItem poo2BookPage3 = new LectureItem("POO", 3);
		poo2Book.add(poo2BookPage1);
		poo2Book.add(poo2BookPage2);
		poo2Book.add(poo2BookPage3);

	}

	/**
	 * Library containing books to read. You can only enter the library when it
	 * is open (determined randomly according to some probability). An OOP book,
	 * eg, Objects first, may be taken out from the library and read. Reading
	 * the book is equivalent to listening to all the OOP course lectures.
	 *
	 * TO DO : enter(),
	 * 
	 * @return
	 */


	/**
	 *
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
			System.out.println(Game.res.getString("library.description"));
			System.out.println();


			return true;
		}
		System.out.println(Game.res.getString("library.closed"));
		System.out.println();
		return false;
	}
    
    public boolean isOpen(){
    	int random = (int)(Math.random() * 10);

	    isOpen = (random > 7) ? true : false;
		return isOpen;
    }



	public void learnPOO(Student goodStudent) {
		int i = 0;
		int sizeBook = poo2Book.size();
		for (i = 0; i < sizeBook; i++) {
			if (!goodStudent.alreadyListened(poo2Book.get(i))) {
				goodStudent.addItem(poo2Book.get(i));
			}
		}
	}
}
