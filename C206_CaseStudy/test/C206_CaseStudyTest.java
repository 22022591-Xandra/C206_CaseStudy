import static org.junit.Assert.*;

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

	public void testDeleteUser() {

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

	}

	@Test
	public void testAddMenu() {
		assertTrue("C206_CaseStudy", true);
		assertNotNull("Test if there is valid Menu arraylist to add to", menuList);
		assertEquals("Test that the Menu arraylist is empty.", 0, menuList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addMenu(menuList, menu1);
		assertEquals("Test that the Stall arraylist size is 1.", 1, menuList.size());

		// Add an item
		C206_CaseStudy.addMenu(menuList, menu2);
		assertEquals("Test that the User arraylist size is now 2.", 2, menuList.size());

		// The item just added is as same as the last item in the list
		assertSame("Test that User is added to the end of the list.", menu2, menuList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addMenu(menuList, menu2);
		assertEquals("Test that the User arraylist size is unchange.", 2, menuList.size());

		// Add an item that has missing detail
		Menu menu_missing = new Menu("Ricecake", 5.00, "");
		C206_CaseStudy.addMenu(menuList, menu_missing);
		assertEquals("Test that the Menu arraylist size is unchange.", 2, menuList.size());
	}

	@Test
	public void testViewMenu() {
		// Test if menuList is not null and empty
		assertNotNull("Test if there is valid Menu arraylist to add to", menuList);
		assertEquals("Test that the Menu arraylist is empty.", 0, menuList.size());
		// Attempt to retrieve the users
		String allMenu = C206_CaseStudy.viewMenu(menuList);
		String testOutput = "";
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
		
	}

	@Test
	public void testViewOrder() {
		
	}

	@Test
	public void testDeleteOrder() {

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
