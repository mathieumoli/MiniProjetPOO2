package zuul.intl;

import java.util.ListResourceBundle;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Zuul_en_US extends ListResourceBundle {
    static final Object[][] contents = {
            {"lunchroom.description", "You are in the lunchroom. Why don't you take some of this Mocoffee drink,\n all natural coffee beans from the upper slopes of Mount Nicaragua,\n no artificial sweeteners! It will give you a few energy.\n Type \"take coffee\" to drink a coffee"},
            {"lectureroom.description1", "You are in the classroom.\nYou can attend to the lecture of "},
            {"lectureroom.description2", "Type \"attend lecture\" if you want \n" },
            {"labroom.description1", "You are in the computing lab.\nYou can attend to the lab of "},
            {"labroom.description2", "Type \"attend lab\" if you want \n" },
            {"corridor1.description", "You are in the first corridor"},
            {"corridor2.description", "You are in the second corridor"},
            {"library.description", "You are in the library"},
            {"examroom.description", "You are in the exam room"},
            {"corridor.dark","This corridor is very dark, you could switch the light on to see clearly the room.\n Type \"light on\" to switch the light on !"},
            {"library.closed","The door is closed. The library is closed 7 out of 10... Come back later !"},
            {"lunchroom.coffee1","It's not the best coffee of my life but I'm feeling better !"},
            {"lunchroom.coffee2", "Thank you Mocoffee !"},
            
            {"game.welcome", "Welcome to the World of Zuul!"},
            {"game.boring", "World of Zuul is a new, incredibly (slightly less) boring adventure game."},
            {"game.help", "Type 'help' if you need help."},
            {"game.idontknow", "I don't know what you mean..."},
            {"game.attend","Attend what ? lab ? lecture ?"},
            {"game.help2", "You are a student and you need to pass the final POO exam."},
            {"game.help3", "In order to do that, you need to listen lecture, do lab works and pass the exam."},
            {"game.help4", "Your command words are:"},
            {"game.where", "Go where?"},
            {"game.take", "take what? A coffee ? Type: take coffee"},
            {"game.nodoor", "There is no door!"},
            {"game.quitwhat", "Quit what?"},
            {"game.exits", "Exits:"},
            {"game.thankyou", "Thank you for playing.  Good bye."},
            {"game.askname", "What's your name ?"},
            {"game.welcomename1", "Welcome "},
            {"game.welcomename2", " ! But I think that this name isn't really for you...I'll call you "},
            {"game.welcomename3", " the badass !"},
            
            {"student.energy.part1", "Energy of "},
            {"student.energy.part2", " is "},
            {"student.addLab.part1","  participate in this lab of "},
            {"student.add.part2"," number "},
            {"student.addLecture.part1"," participate in this course of "},
            
            {"lectureroom.attendlecture.part1","Lecture of "},
            {"lectureroom.attendlecture.part4","Thank you for your attention you can do the lab now !"},
            {"room.attend.part2"," number "},
            {"room.attend.part3"," has to begin"},
            {"labroom.attendlab.part1","Lab of "},
            {"labroom.attendlab.part4","Thank you for your attention. "},
            {"labroom.noattend1","The professor doesn't want you attend to this lab because you haven't assisted to the lecture of "},
            {"labroom.noattend2"," number "},

            {"examroom.cant", "You can't pass the final exam in these conditions..."}
          


    };


    @Override
    public Object[][] getContents() {
        return contents;
    }
}
