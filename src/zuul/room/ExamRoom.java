package zuul.room;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class ExamRoom extends Room {

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
}
