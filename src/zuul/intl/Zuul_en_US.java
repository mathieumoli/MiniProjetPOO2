package zuul.intl;

import java.util.ListResourceBundle;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Zuul_en_US extends ListResourceBundle {
    static final Object[][] contents = {
            {"hall.description", "You are in the hall"},
            {"lunchroom.description", "You are in the lunchroom. Why don't you take some of this Mocoffee drink,\n all natural coffee beans from the upper slopes of Mount Nicaragua,\n no artificial sweeteners! It will give you a few energy.\n Type \"take coffee\" to drink a coffee"},
            {"lectureroom.description", "You are in the classroom"},
            {"labroom.description", "You are in the computing lab"},
            {"corridor1.description", "You are in the first corridor"},
            {"corridor2.description", "You are in the second corridor"},
            {"library.description", "You are in the library"},
            {"examroom.description", "You are in the exam room"},
            {"corridor.dark","This corridor is very dark, you could switch the light on to see clearly the room.\n Type \"light on\" to switch the light on !"},
            {"library.closed","The door is closed. The library is closed 7 out of 10... Come back later !"},
            {"lunchroom.coffee","It's not the best coffee of my life but I'm feeling better !"},

            
            {"game.welcome", "Welcome to the World of Zuul!"},
            {"game.boring", "World of Zuul is a new, incredibly (slightly less) boring adventure game."},
            {"game.help", "Type 'help' if you need help."},
            {"game.idontknow", "I don't know what you mean..."},
            {"game.help2", "You are a student and you need to pass the final POO exam."},
            {"game.help3", "In order to do that, you need to listen lecture, do lab works and pass the exam."},
            {"game.help4", "Your command words are:"},
            {"game.where", "Go where?"},
            {"game.nodoor", "There is no door!"},
            {"game.quitwhat", "Quit what?"},
            {"game.exits", "Exits:"},
            {"game.thankyou", "Thank you for playing.  Good bye."}


    };


    @Override
    public Object[][] getContents() {
        return contents;
    }
}
