package zuul.foundobject;

import zuul.Game;
import zuul.person.Student;
import zuul.room.ExamRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Martinez
 * @version 29/11/2014
 */
public class Cheatsheet implements FoundObject{
    private List<String> answers = new ArrayList<String>();

    public Cheatsheet() {
        addStuff();
    }

    public void addStuff() {
        for (int i = 1; i <= ExamRoom.NB_QUESTIONS; ++i) {
            answers.add(Game.res.getString("OOP.exam.answer" + i));
        }
    }

    public void useObject(Student student) {
        System.out.println(answers);
        student.decrementEnergy(20);
    }
}
