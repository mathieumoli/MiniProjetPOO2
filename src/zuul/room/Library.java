package zuul.room;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Library extends Room {


	boolean open=false;
	
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
    
    public boolean getRandomOpening(){
    	
    	int random = (int)(Math.random() * (10-1)) + 1;
    	
    	if(random>7)
    	{
    		open=true;
    	}
    	else
    		{
    		open=false;
    		}
    	return open;
    	}
    }

