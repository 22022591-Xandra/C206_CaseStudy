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
public class Menu {
	private String itemname;
	private double price;
	private Stall stall;

	public Menu(String itemname, double price, Stall stall) {
		this.itemname = itemname;
		this.price = price;
		this.stall = stall;
	}

	public String getItemname() {
		return itemname;
	}

	public double getPrice() {
		return price;
	}

	public Stall getStall() {
		return stall;
	}
	
}