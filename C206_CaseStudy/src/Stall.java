
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
	

	
}
