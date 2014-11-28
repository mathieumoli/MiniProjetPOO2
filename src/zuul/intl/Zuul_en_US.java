package zuul.intl;

import java.util.ListResourceBundle;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Zuul_en_US extends ListResourceBundle {
    static final Object[][] contents = {
            {"lunchroom.description", "You are in the lunchroom. Why don't you take some of this Mocoffee drink,\n all natural coffee beans from the upper slopes of Mount Nicaragua,\n no artificial sweeteners! It will give you a few energy.\n Type \"take coffee\" to drink a coffee"},
            {"lectureroom.description1", "You are in a classroom.\nYou can attend to the lecture of "},
            {"lectureroom.description2", "Type \"attend lecture\" if you want \n" },
            {"labroom.description1", "You are in the computing lab.\nYou can attend to the lab of "},
            {"labroom.description2", "Type \"attend lab\" if you want \n" },
            {"corridor1.description", "You are in the first corridor"},
            {"corridor2.description", "You are in the second corridor"},
            {"corridor2.description", "You are in the third corridor"},
            {"library.description", "You are in the library.In the Library you can see the OOP2 book. This book contains all lecture you can learn about OOP2. If you want to read it, just type \"read book\""},
            
            {"examroom.description", "You are in the exam room"},
            {"corridor.dark","This corridor is very dark, you could switch the light on to see clearly the room.\n Type \"light on\" to switch the light on !"},
            {"library.closed","The door is closed. The library is closed 7 out of 10... Come back later !"},
            {"lunchroom.coffee1","It's not the best coffee of my life but I'm feeling better !"},
            {"lunchroom.coffee2", "Thank you Mocoffee !"},

            {"oop.lecture", "You need to know...blabla"},
            {"oop.lecture1", "...developers aim for high cohesion and loose coupling..."},
            {"oop.lecture2", "...interfaces don't need a constructor..."},
            {"oop.lecture3", "...a sub-class must have a 'super' call in its constructor..."},
            {"oop.lectureend", "Voilà, c'est tout pour aujourd'hui. Apprenez bien votre cours pour la prochaine fois."},

            {"oop.exam.description", "You are going to take an exam, please answer with TRUE or FALSE."},
            {"oop.exam.question1", "Does an interface need a constructor ?"},
            {"oop.exam.question2", "We aim for low cohesion and high coupling. Is it true ?"},
            {"oop.exam.question3", "Subclass constructors must always contain a 'super' call. Is it true ?"},
            {"oop.exam.answer1", "FALSE"},
            {"oop.exam.answer2", "FALSE"},
            {"oop.exam.answer3", "TRUE"},
            {"oop.exam.rightanswer", "The right answer is : "},

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
            {"game.win", "Congratulations ! You passed the final OOP exam and therefore you finished the game."},
            {"game.lose", "Sorry, you didn't pass the final OOP exam, you need to try again..."},

            {"student.youhave", "You have "},
            {"student.answers", " right answers."},
            {"student.energy.part1", "Energy of "},
            {"student.energy.part2", " is "},
            {"student.addLab.part1","  participate in this lab of "},
            {"student.add.part2"," number "},
            {"student.addLecture.part1"," participate in this course of "},
            {"student.removeLecture1","You forget the lecture of "},
            {"student.removeLecture2"," number "},
            {"student.removeLab1","You forget the lab of "},
            {"student.removeLab2"," number "},
            
            {"lectureroom.attendlecture.part1","Lecture of "},
            {"lectureroom.attendlecture.part4","Thank you for your attention you can do the lab now !"},
            {"room.attend.part2"," number "},
            {"room.attend.part3"," has to begin"},
            {"labroom.attendlab.part1","Lab of "},
            {"labroom.attendlab.part4","Thank you for your attention. "},
            {"labroom.noattend1","The professor doesn't want you attend to this lab because you haven't assisted to the lecture of "},
            {"labroom.noattend2"," number "},
            {"lunchroom.babyFoot","You're in the lunchroom. Salah and Fanfan la tulipe say to you : \"It's babyfoot time !\" You can't refuse."},
            {"examroom.cant", "You can't pass the final exam in these conditions..."}
          


    };


    @Override
    public Object[][] getContents() {
        return contents;
    }
}
