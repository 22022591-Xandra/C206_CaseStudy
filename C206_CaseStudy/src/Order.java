/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22006545, 9 Aug 2023 8:15:27 pm
 */

/**
 * @author 22006545
 *
 */
public class Order {
	private String userName;
	private String status;
	private boolean takeaway;
	private Menu item;

	public Order(String userName, String status, boolean takeaway, Menu item) {
		super();
		this.userName = userName;
		this.status = status;
		this.takeaway = takeaway;
		this.item = item;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public boolean isTakeaway() {
		return takeaway;
	}

	public Menu getItem() {
		return item;
	}
}
