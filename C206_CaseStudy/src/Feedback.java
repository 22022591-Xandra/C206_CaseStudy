/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 22013147
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Monday 07-08-2023 13:37
 */

/**
 * @author 22013147
 *
 */
public class Feedback {
	 private int id;
	    private String message;

	    public Feedback(int id, String message) {
	        this.id = id;
	        this.message = message;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getMessage() {
	        return message;
	    }

	    @Override
	    public String toString() {
	        return "Feedback #" + id + ": " + message;
	    }
	}

