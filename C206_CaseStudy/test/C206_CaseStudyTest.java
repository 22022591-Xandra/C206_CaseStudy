import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// test data
	private User user1;
	private User user2;

	private Stall stall1;
	private Stall stall2;

	private Menu menu1;
	private Menu menu2;

	private Order order1;
	private Order order2;

	private Feedback fb1;
	private Feedback fb2;

	private ArrayList<User> userList;
	private ArrayList<Stall> stallList;
	private ArrayList<Menu> menuList;
	private ArrayList<Order> orderList;
	private ArrayList<Feedback> feedbackList;
	private ArrayList<Queue> queueList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		userList = new ArrayList<User>();
		stallList = new ArrayList<Stall>();
		menuList = new ArrayList<Menu>();
		orderList = new ArrayList<Order>();
		feedbackList = new ArrayList<Feedback>();
		queueList = new ArrayList<Queue>();

		user1 = new User("Customer Test", "c@gmail.com", "1234");
		user2 = new User("Staff Test", "s@gmail.com", "5678", true);

		userList.add(user1);
		userList.add(user2);

		stall1 = new Stall("XY's Burgs and Fries", "Western Cuisine");
		stall2 = new Stall("Kim's Ricecake", "Korean Cuisine");

		stallList.add(stall1);
		stallList.add(stall2);

		menu1 = new Menu("Fries", 5.00, "XY's Burgs and Fries");
		menu2 = new Menu("Ricecake", 5.00, "Kim's Ricecake");

		menuList.add(menu1);
		menuList.add(menu2);

		order1 = new Order("Customer Test", "READY", false, menuList.get(0));
		order2 = new Order("Customer Test2", "PENDING", true, menuList.get(1));

		orderList.add(order1);
		orderList.add(order2);

		fb1 = new Feedback(1, "Hi", userList.get(0));
		fb2 = new Feedback(2, "Hullo", userList.get(1));

		feedbackList.add(fb1);
		feedbackList.add(fb2);

	}

	@Test
	public void testisLoggedIn() {
		assertTrue("C206_CaseStudy_testLogin", true);
	}

	@Test
	public void testAddUser() {
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		assertEquals("Test that the User arraylist is empty.", 0, userList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addUser(userList, user1);
		assertEquals("Test that the User arraylist size is 1.", 1, userList.size());

		// Add an item
		C206_CaseStudy.addUser(userList, user2);
		assertEquals("Test that the User arraylist size is now 2.", 2, userList.size());

		// The item just added is as same as the last item in the list
		assertSame("Test that User is added to the end of the list.", user2, userList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addUser(userList, user2);
		assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());

		// Add an item that has missing detail
		User user_missing = new User("Customer Test", "", "1234");
		C206_CaseStudy.addUser(userList, user_missing);
		assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());
	}

	@Test
	public void testViewUser() {
		assertTrue("C206_CaseStudyTest", true);
		// Test if userList is not null and empty
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		assertEquals("Test that the User arraylist is empty.", 0, userList.size());
		// Attempt to retrieve the users
		String allUser = C206_CaseStudy.viewAllUsers(userList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allUser);

		C206_CaseStudy.addUser(userList, user1);
		C206_CaseStudy.addUser(userList, user2);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 2.", 2, userList.size());
		// Attempt to retrieve the users
		allUser = C206_CaseStudy.viewAllUsers(userList);
		testOutput = String.format("%-6d %-15s %-28s\n", "Customer Test", "c@gmail.com", "1234", null);
		testOutput += String.format("%-6d %-15s %-28s\n", "Staff Test", "s@gmail.com", "5678", true);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);

		user2.setIsAvailable(false);
		C206_CaseStudy.addUser(userList, user2);
		assertEquals("Test that User arrayList size is 1.", 2, userList.size());
		assertFalse("Test that the last item in the arraylist is not available", userList.get(0).getIsAvailable());
		// Attempt to retrieve the users
		allUser = C206_CaseStudy.viewAllUsers(userList);
		testOutput = String.format("%-6d %-15s %-28s\n", "Customer Test", "c@gmail.com", "1234", null);
		// Test that the details are displayed correctly
		assertEquals("Test that the diplay is correct.", testOutput, allUser);
	}

	@Test
	public void testDeleteUser() {
		int initialSize = userList.size();
		// Delete an user
		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");
		C206_CaseStudy.deleteUser();
		assertEquals(initialSize - 1, userList.size());

		// Try to delete from an empty list
		userList.clear();
		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");
		C206_CaseStudy.deleteUser();
		assertEquals(0, userList.size());

		// Try to delete using invalid index
		userList.add(new User("Customer Test", "c@gmail.com", "0897", false));
		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");
		C206_CaseStudy.deleteUser();
		assertEquals(0, userList.size());
	}



	@Test
	public void testAddStall() {
		//
		assertTrue("C206_CaseStudyTest", true);
		assertNotNull("Test if there is valid Stall arraylist to add to", stallList);
		assertEquals("Test that the Stall arraylist is empty.", 0, stallList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addStall(stallList, stall1);
		assertEquals("Test that the Stall arraylist size is 1.", 1, stallList.size());

		// Add an item
		C206_CaseStudy.addStall(stallList, stall2);
		assertEquals("Test that the User arraylist size is now 2.", 2, stallList.size());

		// The item just added is as same as the last item in the list
		assertSame("Test that User is added to the end of the list.", stall2, stallList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addStall(stallList, stall2);
		assertEquals("Test that the User arraylist size is unchange.", 2, stallList.size());

		// Add an item that has missing detail
		Stall stall_missing = new Stall("Kim's Ricecake", "");
		C206_CaseStudy.addStall(stallList, stall_missing);
		assertEquals("Test that the Stall arraylist size is unchange.", 2, stallList.size());
	}

	@Test
	public void testViewStall() {
		// Test if stallList is not null and empty
		assertNotNull("Test if there is valid Stall arraylist to add to", stallList);
		assertEquals("Test that the Stall arraylist is empty.", 0, stallList.size());
		// Attempt to retrieve the users
		String allStall = C206_CaseStudy.viewAllStalls(stallList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allStall);

		C206_CaseStudy.addStall(stallList, stall1);
		C206_CaseStudy.addStall(stallList, stall2);
		// Test that the list is not empty
		assertEquals("Test that Stall arraylist size is 2.", 2, stallList.size());
		// Attempt to retrieve the users
		allStall = C206_CaseStudy.viewAllStalls(stallList);
		testOutput = String.format("%-20s %29s\n", "XY's Burgs and Fries", "Western Cuisine");
		testOutput += String.format("%-20s %29s\n", "Kim's Ricecake", "Korean Cuisine");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allStall);

		stall2.setIsAvailable(false);
		C206_CaseStudy.addStall(stallList, stall2);
		assertEquals("Test that Stall arrayList size is 2.", 3, stallList.size());
		assertFalse("Test that the last item in the arraylist is not available", stallList.get(2).getIsAvailable());
		// Attempt to retrieve the users
		allStall = C206_CaseStudy.viewAllStalls(stallList);
		testOutput = String.format("%-20s %29s\n", "XY's Burgs and Fries", "Western Cuisine");
		testOutput += String.format("%-20s %29s\n", "Kim's Ricecake", "Korean Cuisine");
		// Test that the details are displayed correctly
		assertEquals("Test that the diplay is correct.", testOutput, allStall);
	}

	public void testDeleteStall() {
		int initialSize = stallList.size();
		// delete a stall in the list
		C206_CaseStudy.deleteStall();
		assertEquals("Stall list size should decrease by 1", initialSize - 1, stallList.size());

		// delete stall with last index
		C206_CaseStudy.deleteStall();
		assertEquals("Stall list size should decrease by 1", initialSize - 1, stallList.size());

		// delete stall with invalid index
		C206_CaseStudy.deleteStall(); // Index out of bounds
		assertEquals("Stall list size should remain the same", initialSize, stallList.size());
	}

	@Test
	public void testAddMenu() {
	
	}
	
	@Test public void testSearchMenu() {
		assertNotNull("Test if there is valid Stall arraylist to add to", stallList);
		assertEquals("Test that the menu arraylist is available to be searched .", 0, menuList.size());
	}
	
	@Test
	public void testDeleteMenu1() {

		C206_CaseStudy.deleteQueue(orderList, 1);

		assertEquals("Check if MenuList size is 0 after deleting menu", 0, menuList.size());

		// deleting an invalid order
		C206_CaseStudy.deleteMenu();

		assertEquals("Check if MenuList remains unchanged after deleting with invalid menu", 1, menuList.size());

		// deleting an order from an empty orderList
		ArrayList<Order> emptyOrderList = new ArrayList<Order>();

		C206_CaseStudy.deleteQueue(emptyOrderList, 1);

		assertEquals("Check if MenuList size is 0 after attempting to delete from empty list", 0,
				menuList.size());
	}

	@Test
	public void testViewMenu() {
		// Test if menuList is not null and empty
		assertNotNull("Test if there is valid Menu arraylist to add to", menuList);
		assertEquals("Test that the Menu arraylist is empty.", 0, menuList.size());
		// Attempt to retrieve the users
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allMenu);

		C206_CaseStudy.addMenu(menuList, menu1);
		C206_CaseStudy.addMenu(menuList, menu2);
		// Test that the list is not empty
		assertEquals("Test that Menu arraylist size is 2.", 2, menuList.size());
		// Attempt to retrieve the users
		allMenu = C206_CaseStudy.viewAllStalls(stallList);
		testOutput = String.format("%s - %.2f\n", "Burger", 5.00, "XY's Burgs and Fries");
		testOutput += String.format("%s - %.2f\n", "Fries", 5.00, "XY's Burgs and Fries");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allMenu);

		stall2.setIsAvailable(false);
		C206_CaseStudy.addMenu(menuList, menu2);
		assertEquals("Test that Menu arrayList size is 2.", 2, menuList.size());
		assertFalse("Test that the last item in the arraylist is not available", menuList.get(2).getIsAvailable());
		// Attempt to retrieve the users
		allMenu = C206_CaseStudy.viewMenu(menuList);
		testOutput = String.format("%s - %.2f\n", "Burger", 5.00, "XY's Burgs and Fries");
		testOutput += String.format("%s - %.2f\n", "Fries", 5.00, "XY's Burgs and Fries");
		// Test that the details are displayed correctly
		assertEquals("Test that the diplay is correct.", testOutput, allMenu);
	}

	public void testDeleteMenu() {
		int initialSize = orderList.size();

		// Delete an order
		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");
		C206_CaseStudy.deleteOrder();
		assertEquals(initialSize - 1, orderList.size());

		// Try to delete from an empty list
		orderList.clear();
		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");
		C206_CaseStudy.deleteOrder();
		assertEquals(0, orderList.size());

		// Try to delete using invalid index
		orderList.add(new Order("Customer Test", "PENDING", true, new Menu("Burger", 5.00, "XY's Burgs and Fries")));
		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");
		C206_CaseStudy.deleteOrder();
		assertEquals(0, orderList.size());
	}

	@Test
	public void testAddOrder() {
		assertTrue("C206_CaseStudy", true);
		assertNotNull("Test if there is valid Order arraylist to add to", orderList);
		assertEquals("Test that the Order arraylist is empty.", 0, orderList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addOrder(orderList, order1);
		assertEquals("Test that the Order arraylist size is 1.", 1, orderList.size());

		// Add an item
		C206_CaseStudy.addOrder(orderList, order2);
		assertEquals("Test that the Order arraylist size is now 2.", 2, orderList.size());

		// The item just added is as same as the last item in the list
		assertSame("Test that Order is added to the end of the list.", order2, orderList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addOrder(orderList, order2);
		assertEquals("Test that the Order arraylist size is unchange.", 2, orderList.size());

		// Add an item that has missing detail
		Order order_missing = new Order("Customer Test", "PENDING", true, null);
		C206_CaseStudy.addOrder(orderList, order_missing);
		assertEquals("Test that the Order arraylist size is unchange.", 2, orderList.size());
	}

	@Test
	public void testViewOrder() {
		// Test if orderList is not null and empty
		assertNotNull("Test if there is valid Order arraylist to add to", orderList);
		assertEquals("Test that the Order arraylist is empty.", 0, orderList.size());
		// Attempt to retrieve the orders
		String allOrder = C206_CaseStudy.viewAllOrders(orderList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allOrder);

		C206_CaseStudy.addOrder(orderList, order1);
		C206_CaseStudy.addOrder(orderList, order2);
		// Test that the list is not empty
		assertEquals("Test that Order arraylist size is 2.", 2, orderList.size());
		// Attempt to retrieve the orders
		allOrder = C206_CaseStudy.viewAllOrders(orderList);
		testOutput = String.format("%-15s %-10s %-10s %s\n", "Customer Test", "READY", false, "Fries");
		testOutput += String.format("%-15s %-10s %-10s %s\n", "Customer Test2", "PENDING", true, "Ricecake");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allOrder);

		order2.setStatus("READY");
		C206_CaseStudy.addOrder(orderList, order2);
		assertEquals("Test that Order arrayList size is 2.", 3, orderList.size());
		assertEquals("Test that the last item in the arraylist status has changed to READY", "READY",
				orderList.get(2).getStatus());
		// Attempt to retrieve the orders
		allOrder = C206_CaseStudy.viewAllOrders(orderList);
		testOutput = String.format("%-15s %-10s %-10s %s\n", "Customer Test", "READY", false, "Fries");
		testOutput += String.format("%-15s %-10s %-10s %s\n", "Customer Test2", "PENDING", true, "Ricecake");
		// Test that the details are displayed correctly
		assertEquals("Test that the diplay is correct.", testOutput, allOrder);
	}

	@Test
	public void testDeleteOrder() {
		int initialSize = orderList.size();

		// Delete an order
		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");
		C206_CaseStudy.deleteOrder();
		assertEquals(initialSize - 1, orderList.size());

		// Try to delete from an empty list
		orderList.clear();
		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");
		C206_CaseStudy.deleteOrder();
		assertEquals(0, orderList.size());

		// Try to delete using invalid order
		orderList.add(order1);
		C206_CaseStudy.currentUser = new User("Customer Test2", "c2@gmail.com", "5678");
		C206_CaseStudy.deleteOrder();
		assertEquals(1, orderList.size());
	}

	@Test
	public void testAddQueue() {
		// menu chosen in queue is valid
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		menuList.add(new Menu("Burger", 5.00, "XY's Burgs and Fries"));
		menuList.add(new Menu("Fries", 5.00, "XY's Burgs and Fries"));

		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");

		C206_CaseStudy.addQueue(orderList, menuList, 1);

		assertEquals("Check if orderList size is 1 after adding order", 1, orderList.size());
		assertEquals("Check if order user is correct", "Customer Test", orderList.get(0).getUserName());
		assertEquals("Check if order stall is correct", "XY's Burgs and Fries", orderList.get(0).getItem().getStall());
		assertEquals("Check if otder item is correct", "Burger", orderList.get(0).getItem().getItemname());
		assertEquals("Check if order status is PENDING", "PENDING", orderList.get(0).getStatus());
		assertEquals("Check if order takeaway status is true", true, orderList.get(0).isTakeaway());

		// menu chosen in queue is invalid
		menuList.add(new Menu("Burger", 5.00, "XY's Burgs and Fries"));
		menuList.add(new Menu("Fries", 5.00, "XY's Burgs and Fries"));

		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");

		C206_CaseStudy.addQueue(orderList, menuList, 3);

		assertEquals("Check if orderList size is 0 after invalid menu choice", 0, menuList.size());

		// menuList is empty
		C206_CaseStudy.currentUser = new User("Customer Test", "c@gmail.com", "1234");

		C206_CaseStudy.addQueue(orderList, menuList, 1);

		assertEquals("Check if orderList size is 0 after adding with empty menuList", 0, orderList.size());
	}

	@Test
	public void testViewQueue() {
		// displaying correct information of orders in the queue
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order("Customer Test", "READY", false, menuList.get(0)));
		orderList.add(new Order("Customer Test2", "PENDING", true, menuList.get(1)));

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		C206_CaseStudy.viewQueue(orderList);

		String expectedOutput = "VIEW QUEUE\n" + "==================\n" + "QUEUE: 1\n" + "User: Customer Test\n"
				+ "Stall: XY's Burgs and Fries\n" + "Item: Burger\n" + "Status: PENDING\n" + "Takeaway: Yes\n"
				+ "==================\n" + "QUEUE: 2\n" + "User: Customer Test\n" + "Stall: XY's Burgs and Fries\n"
				+ "Item: Fries\n" + "Status: PENDING\n" + "Takeaway: No\n" + "==================\n";

		assertEquals("Check if the output matches the expected output", expectedOutput, outContent.toString());

		// displaying the correct message when there are no orders in the queue
		C206_CaseStudy.viewQueue(orderList);
		String expectedOutput1 = "VIEW QUEUE\n" + "==================\n" + "No orders available.\n";

		assertEquals("Check if the output matches the expected output", expectedOutput1, outContent.toString());

		// method handles a null
		C206_CaseStudy.viewQueue(null);

		String expectedOutput2 = "VIEW QUEUE\n" + "==================\n" + "No orders available.\n";

		assertEquals("Check if the output matches the expected output", expectedOutput2, outContent.toString());
	}

	@Test
	public void testDeleteQueue() {
		// deleting a valid order from orderList successfully
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order("Customer Test", "PENDING", true, new Menu("Burger", 5.00, "XY's Burgs and Fries")));

		C206_CaseStudy.deleteQueue(orderList, 1);

		assertEquals("Check if orderList size is 0 after deleting order", 0, orderList.size());

		// deleting an invalid order
		C206_CaseStudy.deleteQueue(orderList, 2);

		assertEquals("Check if orderList remains unchanged after deleting with invalid order", 1, orderList.size());

		// deleting an order from an empty orderList
		ArrayList<Order> emptyOrderList = new ArrayList<Order>();

		C206_CaseStudy.deleteQueue(emptyOrderList, 1);

		assertEquals("Check if orderList size is 0 after attempting to delete from empty list", 0,
				emptyOrderList.size());
	}

	@Test
	public void testAddFeedback() {
		assertNotNull("Test if there is valid Feedback arraylist to add to", feedbackList);
		assertEquals("Test that the Feedback arraylist is empty.", 0, feedbackList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addFeedback(feedbackList, fb1);
		assertEquals("Test that the Feedback arraylist size is 1.", 1, feedbackList.size());
		// Add another item
		C206_CaseStudy.addFeedback(feedbackList, fb2);
		assertEquals("Test that the Feedback arraylist size is now 2.", 2, feedbackList.size());
		// The item just added is as same as the last item in the list
		assertSame("Test that Feedback is added to the end of the list.", fb2, feedbackList.get(1));
		// Add an item that already exists in the list
		C206_CaseStudy.addFeedback(feedbackList, fb2);
		assertEquals("Test that the Feedback arraylist size is unchanged.", 2, feedbackList.size());
		// Add an item that has missing details
		Feedback feedback_missing = new Feedback(3, "", user1);
		C206_CaseStudy.addFeedback(feedbackList, feedback_missing);
		assertEquals("Test that the Feedback arraylist size is unchanged.", 2, feedbackList.size());
	}

	@Test
	public void testViewFeedback() {
		// Check if the initial state is as expected
		assertNotNull("Test if there is valid Feedback arraylist to add to", feedbackList);
		assertEquals("Test that the Feedback arraylist is empty.", 0, feedbackList.size());
		// Add some feedback to the list
		feedbackList.add(fb1);
		feedbackList.add(fb2);
		// Test that the list is not empty
		assertEquals("Test that Feedback arraylist size is 2.", 2, feedbackList.size());

	}

	@Test
	public void testDeleteFeedback() {
		assertNotNull("Test if there is valid Feedback arraylist to add to", feedbackList);
		assertEquals("Test that the Feedback arraylist is empty.", 0, feedbackList.size());
		// Test that the list is not empty
		assertEquals("Test that Feedback arraylist size is 2.", 2, feedbackList.size());
		// Delete feedback by index
		C206_CaseStudy.deleteFeedback();
		// Test that the size of the list is decreased after deletion
		assertEquals("Test that Feedback arraylist size is 1 after deletion.", 1, feedbackList.size());
		// Delete feedback that doesn't exist
		C206_CaseStudy.deleteFeedback(); // Invalid index
		// Test that the size of the list remains the same after invalid deletion
		assertEquals("Test that Feedback arraylist size is still 1 after invalid deletion.", 1, feedbackList.size());
		// Delete feedback by index
		C206_CaseStudy.deleteFeedback();
		// Test that the list is empty after all feedback are deleted
		assertEquals("Test that Feedback arraylist size is 0 after all deletions.", 0, feedbackList.size());
	}

	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
		stall1 = null;
		stall2 = null;

		menu1 = null;
		menu2 = null;

		order1 = null;
		order2 = null;

		fb1 = null;
		fb2 = null;

		userList = null;
		stallList = null;
		menuList = null;

	}

}
