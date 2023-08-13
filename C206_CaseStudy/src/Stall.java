/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22006545, 9 Aug 2023 7:51:44 pm
 */

/**
 * @author 22006545
 *
 */

import java.util.ArrayList;

public class Stall {
	private String name;
	private String description;

	public Stall(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String toString() {
		return "Stall Name: " + name + "\nDescription: " + description;
	}
	public void setIsAvailable(boolean a) {
		
	}
	public boolean getIsAvailable() {
	
		return false;
	}
}

