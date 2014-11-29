package zuul.room;

import zuul.Game;
import zuul.course.Item;
import zuul.course.LabItem;
import zuul.course.LectureItem;
import zuul.person.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class ExamRoom extends Room {
    public static final int NB_QUESTIONS = 3;
    private String exam;

    public ExamRoom(String description) {
        super(description);
    }

    /**
     * Exam rooms where an exam is being given. If the exam is on OOP, the student must take the exam.
     * If it's some other course, the student may leave immediately :^) . Taking the exam means answering some true / false questions.
     * The number of correct answers determines whether the student passes the course.
     * Normally, the student must have listened to all the lectures and done all the labs before they are allowed to take the exam.
     * The student must have a certain energy level to take the exam.
     *
     *
     * TO DO : enter() , startExam()
     */

    @Override
    public boolean canEnter(Student student){
        return true;
    }

    public boolean mustEnter(Student student){
        //vérifier qu'il a tous les cours et tous les labs
        boolean allCourses = false;
        boolean allLabs = false;
        List<LectureItem> lectureOOP = new ArrayList<LectureItem>();
        List<LabItem> labOOP = new ArrayList<LabItem>();
        for (int i = 0; i < Game.NB_COURSES; ++i){
            lectureOOP.add(new LectureItem("OOP", i + 1));
            labOOP.add(new LabItem("OOP", i + 1));
            if (!student.getCoursSuivi().contains(lectureOOP.get(i))) {
                allCourses = false;
            } else {
                allCourses = true;
            }
            if (!student.getLabsSuivi().contains(labOOP.get(i))) {
                allLabs = false;
            } else {
                allLabs = true;
            }
        }

        if (allCourses && allLabs) {
            if (exam.equals("OOP") && student.getEnergy() >= 50){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean enter(Student student){
        randomizeExams();
        if(mustEnter(student)){
            System.out.println(Game.res.getString("examroom.description"));
            System.out.println(Game.res.getString("oop.exam.description"));
            startExam();
            return true;
        } else {
            System.out.println(Game.res.getString("examroom.cant"));
            return false;
        }
    }

    private void randomizeExams(){
        int rand = (int) (Math.random() * Game.NB_COURSES);

        //exam = Game.COURSES[rand];
        //test
        exam = Game.COURSES[0];
    }

    private void startExam() {
        int questionsRight = 0;
        String answer;
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= NB_QUESTIONS; ++i){
            System.out.println(Game.res.getString("oop.exam.question" + i));
            answer = scanner.nextLine();
            String rightAnswer = Game.res.getString("oop.exam.answer"+ i);
            if (answer.toUpperCase().equals(rightAnswer)) {
                ++questionsRight;
            }

            System.out.println(Game.res.getString("oop.exam.rightanswer") + rightAnswer);
            System.out.println();
        }

        System.out.println(Game.res.getString("student.youhave")
                        + questionsRight + "/" + NB_QUESTIONS + Game.res.getString("student.answers"));
        if (questionsRight > (NB_QUESTIONS/2)) {
            System.out.println(Game.res.getString("game.win"));
        } else {
            System.out.println(Game.res.getString("game.lose"));
        }
        System.out.println(Game.res.getString("game.thankyou"));

        System.exit(1);
    }
}
