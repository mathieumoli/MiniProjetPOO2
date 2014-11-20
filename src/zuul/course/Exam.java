package zuul.course;

import java.util.HashMap;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class Exam extends Item {
	private HashMap questions;
	
	public Exam(HashMap questionsExam){
		super();
		// nous prenons en compte diverses langues donc mieux vaut recuperer dans la bonne langue lors de la création de l'exam
		questions=questionsExam;
	}

}
