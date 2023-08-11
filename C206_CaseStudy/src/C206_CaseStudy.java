import java.util.ArrayList;

public class C206_CaseStudy {

	public static boolean isLoggedIn = false;
	public static User currentUser = null;

	public static ArrayList<Stall> stallList = new ArrayList<Stall>();
	public static ArrayList<Menu> menuList = new ArrayList<Menu>();
	public static ArrayList<User> userList = new ArrayList<User>();
	public static ArrayList<Order> orderList = new ArrayList<Order>();
	public static ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		stallList.add(new Stall("XY's Burgs and Fries", "Western Cuisine"));
		stallList.add(new Stall("Kim's Ricecake", "Korean Cuisine"));
		stallList.add(new Stall("Ayam Penyet", "Malay Cuisine"));
		stallList.add(new Stall("Cheng's Noodles", "Chinese Cuisine"));

		menuList.add(new Menu("Burger", 5.00, "XY's Burgs and Fries"));
		menuList.add(new Menu("Fries", 5.00, "XY's Burgs and Fries"));
		menuList.add(new Menu("Ricecake", 5.00, "Kim's Ricecake"));
		menuList.add(new Menu("Ramyun", 5.00, "Kim's Ricecake"));
		menuList.add(new Menu("Ayam", 5.00, "Ayam Penyet"));
		menuList.add(new Menu("Nasi", 5.00, "Ayam Penyet"));
		menuList.add(new Menu("Wanton", 5.00, "Cheng's Noodles"));
		menuList.add(new Menu("MeePok", 5.00, "Cheng's Noodles"));

		userList.add(new User("Customer Test", "c@gmail.com", "1234"));
		userList.add(new User("Staff Test", "s@gmail.com", "5678", true));

		orderList.add(new Order("Customer Test", "READY", false, menuList.get(0)));
		orderList.add(new Order("Customer Test2", "PENDING", true, menuList.get(1)));

		feedbackList.add(new Feedback(1, "Hi", userList.get(0)));
		feedbackList.add(new Feedback(2, "Hullo", userList.get(1)));

		int option = 0;

		while (isLoggedIn != true) {

			C206_CaseStudy.menuVisitor();
			option = Helper.readInt("Enter an option > ");

			// VIEW MENU
			if (option == 1) {
				C206_CaseStudy.viewMenu();
				// LOGIN AS CUSTOMER/STALL OWNER
			} else if (option == 2) {
				String email = Helper.readString("Enter Email > ");
				String pass = Helper.readString("Enter Password > ");
				if (loginCheck(email, pass, userList)) {
					isLoggedIn = true;
				} else {
					System.out.println("Incorrect Email or Password");
				}
				// Register
			} else if (option == 3) {
				C206_CaseStudy.getRegister();
			}

			if (currentUser != null && currentUser.getEmp() == false) {
				// CUSTOMER VIEW
				while (option != 5) {
					C206_CaseStudy.menuCustomer();
					option = Helper.readInt("Enter an option > ");

					// VIEW MENU
					if (option == 1) {
						C206_CaseStudy.viewMenu();
					} else if (option == 2) {// ADD ORDER
						C206_CaseStudy.addOrder();
					} else if (option == 3) {// ADD FEEDBACK
						C206_CaseStudy.addFeedback();
					} else if (option == 4) {// MAKE PAYMENT
						C206_CaseStudy.makePayment();
					} else if (option == 5) {
						isLoggedIn = false;
					}
				}
				// STAFF VIEW
			} else if (currentUser != null && currentUser.getEmp() == true) {
				while (option != 14) {
					C206_CaseStudy.menuStaff();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						C206_CaseStudy.addUser();
					} else if (option == 2) {
						C206_CaseStudy.viewAllUsers(userList);
					} else if (option == 3) {
						C206_CaseStudy.deleteUser();
					} else if (option == 4) {
						C206_CaseStudy.addStall();
					} else if (option == 5) {
						C206_CaseStudy.viewAllStalls(stallList);
					} else if (option == 6) {
						C206_CaseStudy.deleteStall();
					} else if (option == 7) {
						C206_CaseStudy.addMenu();
					} else if (option == 8) {
						C206_CaseStudy.viewMenu();
					} else if (option == 9) {
						C206_CaseStudy.deleteMenu();
					} else if (option == 10) {
						C206_CaseStudy.viewOrder();
					} else if (option == 11) {
						C206_CaseStudy.deleteOrder();
					} else if (option == 12) {
						C206_CaseStudy.viewQueue();
					} else if (option == 13) {
						C206_CaseStudy.viewFeedback();
					} else if (option == 14) {
						C206_CaseStudy.deleteFeedback();
					} else if (option == 15) {
						isLoggedIn = false;
					}
				}
			}
		}
	}

	public static void menuVisitor() {
		Helper.line(50, "=");
		System.out.println("VISITOR");
		Helper.line(50, "=");
		System.out.println("1 - View Menu");
		System.out.println("2 - Log In As Customer/Stall Owner");
		System.out.println("3 - Register");
		System.out.println("4 - Quit");
	}

	public static void menuCustomer() {
		// TODO Auto-generated method stub
		Helper.line(50, "=");
		System.out.println("CUSTOMER");
		Helper.line(50, "=");
		System.out.println("1 - View Menu");
		System.out.println("2 - Add Order");
		System.out.println("3 - Add Feedback");
		System.out.println("4 - Make Payment");
		System.out.println("5 - Log Out");
		System.out.println("6 - Quit");
	}

	public static void menuStaff() {
		Helper.line(50, "=");
		System.out.println("STAFF");
		Helper.line(50, "=");
		System.out.println("1 -  Add User");
		System.out.println("2 -  View User");
		System.out.println("3 -  Delete User");
		System.out.println("4 -  Add Stall");
		System.out.println("5 -  View Stall");
		System.out.println("6 -  Delete Stall");
		System.out.println("7 -  Add Menu");
		System.out.println("8 -  View Menu");
		System.out.println("9 -  Delete Menu");
		System.out.println("10 - View Order");
		System.out.println("11 - Delete Order");
		System.out.println("12 - View Queue");
		System.out.println("13 - View Feedback");
		System.out.println("14 - Delete Feedback");
		System.out.println("15 - Log Out");
		System.out.println("16 - Quit");
	}

	public static void makePayment() {
		Helper.line(50, "=");
		System.out.println("MAKE PAYMENT");
		Helper.line(50, "=");

		if (orderList.isEmpty()) {
			System.out.println("No orders available for payment.");
		} else {
			viewOrder();

			int orderIndex = Helper.readInt("Enter the number of the order to make payment for > ");
			orderIndex--;

			if (orderIndex >= 0 && orderIndex < orderList.size()) {
				Order selectedOrder = orderList.get(orderIndex);

				if (selectedOrder.getStatus().equals("PENDING")) {
					selectedOrder.setStatus("PAID");
					System.out.println("Payment for order " + (orderIndex + 1) + " has been made.");
				} else {
					System.out.println("Payment cannot be made for this order as its status is not PENDING.");
				}
			} else {
				System.out.println("Invalid order index!");
			}
		}
	}

	public static void viewMenu() {
		Helper.line(50, "=");
		System.out.println("MENU");
		Helper.line(50, "=");
		String output = "";

		for (Stall stall : stallList) {
			output += ("Stall: " + stall.getName() + "\n");
			output += "Menu:\n";

			for (Menu menu : menuList) {
				if (menu.getStall().equals(stall.getName())) {
					output += String.format("%s - %.2f\n", menu.getItemname(), menu.getPrice());
				}
			}
			output += "\n";
		}
		System.out.println(output);
	}

	public static void addMenu() {
		// TODO: Implement the logic to add a menu item
		Helper.line(50, "=");
		System.out.println("ADD MENU ITEM");
		Helper.line(50, "=");
		
		
		String stall  = Helper.readString("Enter the stall name you want to add menu to > ");
		String itemname = Helper.readString("Enter menu item >");
		Double price = Helper.readDouble("Enter price of food > ");
		
		menuList.add(new Menu(itemname, price, stall));
		System.out.println("Added successfully!");

	}

	public static void deleteMenu() {
		// TODO: Implement the logic to delete a menu item
		Helper.line(50, "=");
		System.out.println("DELETE MENU");
		Helper.line(50, "=");
		
		if (menuList.isEmpty()) {
			System.out.println("No menu item available to delete.");
		} else {
			viewMenu();

			int menuIndex = Helper.readInt("Enter the number of the menus to delete > ");
			menuIndex--;

			if (menuIndex >= 0 && menuIndex < menuList.size()) {
				menuList.remove(menuIndex);
				System.out.println("Menu item deleted successfully!");
			} else {
				System.out.println("Invalid menu index!");
			}
		}
		
		
	}

	public static void viewAllStalls(ArrayList<Stall> stallList) {
		// TODO Auto-generated method stub
		Helper.line(50, "=");
		System.out.println("STALL LIST");
		Helper.line(50, "=");

		String output = String.format("%-20s %29s\n\n", "STALL NAME", "DESCRIPTION");

		for (int i = 0; i < stallList.size(); i++) {
			output += String.format("%-20s %29s\n", stallList.get(i).getName(), stallList.get(i).getDescription());
		}
		System.out.println(output);
	}

	public static void addStall() {
		String name = Helper.readString("Enter Stall Name > ");
		String description = Helper.readString("Enter Description > ");
		stallList.add(new Stall(name, description));
		System.out.println("Stall added successfully!");
	}

	public static void deleteStall() {
		Helper.line(50, "=");
		System.out.println("DELETE STALL");
		Helper.line(50, "=");

		if (stallList.isEmpty()) {
			System.out.println("No stalls available to delete.");
		} else {
			viewAllStalls(stallList);

			int stallIndex = Helper.readInt("Enter the number of the stall to delete > ");
			stallIndex--;

			if (stallIndex >= 0 && stallIndex < stallList.size()) {
				stallList.remove(stallIndex);
				System.out.println("Stall deleted successfully!");
			} else {
				System.out.println("Invalid stall index!");
			}
		}
	}

	public static void viewAllUsers(ArrayList<User> userList) {
		Helper.line(50, "=");
		System.out.println("USER LIST");
		Helper.line(50, "=");

		String output = String.format("%-6s %-15s %-28s\n", "INDEX", "USERNAME", "EMAIL");

		for (int i = 0; i < userList.size(); i++) {
			output += String.format("%-6d %-15s %-28s\n", (i + 1), userList.get(i).getName(),
					userList.get(i).getEmail());
		}
		System.out.println(output);
	}

	public static void addUser() {
		Helper.line(50, "=");
		System.out.println("ADD USER");
		Helper.line(50, "=");

		String name = Helper.readString("Enter Name > ");
		String email = Helper.readString("Enter Email > ");
		String pass = Helper.readString("Enter Password > ");
		boolean isEmployee = Helper.readBoolean("Is this user an employee? (true/false) > ");

		userList.add(new User(name, email, pass, isEmployee));
		System.out.println("User added successfully!");
	}

	public static void deleteUser() {
		Helper.line(50, "=");
		System.out.println("DELETE USER");
		Helper.line(50, "=");

		if (userList.isEmpty()) {
			System.out.println("No users available to delete.");
		} else {
			viewAllUsers(userList); // Display available users first

			int userIndex = Helper.readInt("Enter the number of the user to delete > ");
			userIndex--;

			if (userIndex >= 0 && userIndex < userList.size()) {
				userList.remove(userIndex);
				System.out.println("User deleted successfully!");
			} else {
				System.out.println("Invalid user index!");
			}
		}
	}

	public static boolean loginCheck(String email, String password, ArrayList<User> userList) {
		for (User user : userList) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				currentUser = user;
				return true;
			}
		}
		return false;
	}

	public static void getRegister() {
		String name = Helper.readString("Enter Name > ");
		String email = Helper.readString("Enter Email > ");
		String pass = Helper.readString("Enter Password > ");
		userList.add(new User(name, email, pass));
	}

	public static void addOrder() {
		String userName = currentUser.getName();
		boolean takeaway = Helper.readBoolean("Is it a takeaway? (true/false) > ");

		System.out.println("Available Menu Items:");
		for (int i = 0; i < menuList.size(); i++) {
			System.out.println((i + 1) + ". " + menuList.get(i).getItemname() + " - $" + menuList.get(i).getPrice());
		}

		int menuChoice = Helper.readInt("Enter the number of the menu item > ");

		if (menuChoice >= 1 && menuChoice <= menuList.size()) {
			Menu selectedMenu = menuList.get(menuChoice - 1);
			orderList.add(new Order(userName, "PENDING", takeaway, selectedMenu));
			System.out.println("Order added successfully!");
		} else {
			System.out.println("Invalid menu choice!");
		}
	}

	public static void viewOrder() {
		Helper.line(50, "=");
		System.out.println("VIEW ORDERS");
		Helper.line(50, "=");

		if (orderList.isEmpty()) {
			System.out.println("No orders available.");
		} else {
			for (int i = 0; i < orderList.size(); i++) {
				System.out.println("ORDER " + (i + 1));
				System.out.println("User: " + orderList.get(i).getUserName());
				System.out.println("Item: " + orderList.get(i).getItem().getItemname());
				System.out.println("Status: " + orderList.get(i).getStatus());
				System.out.println("Takeaway: " + (orderList.get(i).isTakeaway() ? "Yes" : "No"));
				System.out.println("=============================");
			}
		}
	}

	public static void deleteOrder() {
		Helper.line(50, "=");
		System.out.println("DELETE ORDER");
		Helper.line(50, "=");

		if (orderList.isEmpty()) {
			System.out.println("No orders available to delete.");
		} else {
			viewOrder(); // Display available orders first

			int orderIndex = Helper.readInt("Enter the number of the order to delete > ");
			orderIndex--;

			if (orderIndex >= 0 && orderIndex < orderList.size()) {
				orderList.remove(orderIndex);
				System.out.println("Order deleted successfully!");
			} else {
				System.out.println("Invalid order index!");
			}
		}
	}

	public static void addFeedback() {
		String message = Helper.readString("Enter your feedback message > ");
		int feedbackId = feedbackList.size() + 1;
		feedbackList.add(new Feedback(feedbackId, message, currentUser));
		System.out.println("Feedback added successfully!");
	}

	public static void viewFeedback() {
		Helper.line(50, "=");
		System.out.println("VIEW FEEDBACK");
		Helper.line(50, "=");

		if (feedbackList.isEmpty()) {
			System.out.println("No feedback available.");
		} else {
			for (int i = 0; i < feedbackList.size(); i++) {
				System.out.println("FEEDBACK " + (i + 1));
				System.out.println("ID: " + feedbackList.get(i).getId());
				System.out.println("User: " + feedbackList.get(i).getUser().getName());
				System.out.println("Message: " + feedbackList.get(i).getMessage());
				System.out.println("=============================");
			}
		}
	}

	public static void deleteFeedback() {
		Helper.line(50, "=");
		System.out.println("DELETE FEEDBACK");
		Helper.line(50, "=");

		if (feedbackList.isEmpty()) {
			System.out.println("No feedback available to delete.");
		} else {
			viewFeedback();

			int feedbackId = Helper.readInt("Enter the ID of the feedback to delete > ");

			boolean feedbackFound = false;
			for (Feedback feedback : feedbackList) {
				if (feedback.getId() == feedbackId) {
					feedbackList.remove(feedback);
					feedbackFound = true;
					System.out.println("Feedback deleted successfully!");
					break;
				}
			}

			if (!feedbackFound) {
				System.out.println("Feedback ID not found.");
			}
		}
	}

	public static void viewQueue() {
		Helper.line(50, "=");
		System.out.println("VIEW QUEUE");
		Helper.line(50, "=");

		if (orderList.isEmpty()) {
			System.out.println("No orders available.");
		} else {
			for (int i = 0; i < orderList.size(); i++) {
				System.out.println("QUEUE: " + (i + 1));
				System.out.println("User: " + orderList.get(i).getUserName());
				System.out.println("Item: " + orderList.get(i).getItem().getItemname());
				System.out.println("Status: " + orderList.get(i).getStatus());
				System.out.println("Takeaway: " + (orderList.get(i).isTakeaway() ? "Yes" : "No"));
				System.out.println("=============================");
			}
		}
	}
}
