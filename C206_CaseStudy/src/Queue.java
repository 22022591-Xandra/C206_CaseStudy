/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Fiqriyah, 11 Aug 2023 10:03:19 am
 */

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Fiqriyah, 11 Aug 2023 10:03:19 am
 */

public class Queue {
	private String userName;
	private String name;
	private String itemname;
	private String status;
	private boolean takeaway;


	public Queue(String userName, String name, String itemname, String status, boolean takeaway) {
	  this.userName = userName;
	  this.name = name;
	  this.itemname = itemname;
	  this.status = status;
	  this.takeaway = takeaway;
	  
	}
	public String getUserName() {
	  return userName;
	}
	public String getName() {
		return name;
	}
	public String getItemname() {
	  return itemname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isTakeaway() {
		return takeaway;
	}
	}
