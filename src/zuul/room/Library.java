package zuul.room;

import com.sun.org.apache.xpath.internal.SourceTree;
import zuul.Game;
import zuul.person.Student;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Library extends Room {

	boolean isOpen = false;
	
	public Library(String description) {
		super(description);

	}


    /**
     * Library containing books to read. You can only enter the library when it is open
     * (determined randomly according to some probability).
     * An OOP book, eg, Objects first, may be taken out from the library and read.
     * Reading the book is equivalent to listening to all the OOP course lectures.
     *
     * TO DO : enter(),
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

			//@todo lire le livre de POO

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
}

