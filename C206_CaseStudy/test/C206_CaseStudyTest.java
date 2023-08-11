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
	private Stall stall3;
	private Stall stall4;
	private Menu menu1;
	private Menu menu2;
	private Menu menu3;
	private Menu menu4;
	private Menu menu5;
	private Menu menu6;
	private Menu menu7;
	private Menu menu8;
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
		
		user1 = new User("Customer Test", "c@gmail.com", "1234");
		user2 = new User("Staff Test", "s@gmail.com", "5678", true);

		stall1 = new Stall("XY's Burgs and Fries", "Western Cuisine");
		stall2 = new Stall("Kim's Ricecake", "Korean Cuisine");
		stall3 = new Stall("Ayam Penyet", "Malay Cuisine");
		stall4 = new Stall("Cheng's Dog", "Chinese Cuisine");

		menuList.add(new Menu("Burger", 5.00, "XY's Burgs and Fries"));
		menuList.add(new Menu("Fries", 5.00, "XY's Burgs and Fries"));
		menuList.add(new Menu("Ricecake", 5.00, "Kim's Ricecake"));
		menuList.add(new Menu("Ramyun", 5.00, "Kim's Ricecake"));
		menuList.add(new Menu("Ayam", 5.00, "Ayam Penyet"));
		menuList.add(new Menu("Nasi", 5.00, "Ayam Penyet"));
		menuList.add(new Menu("Dog", 5.00, "Cheng's Dog"));
		menuList.add(new Menu("Cat", 5.00, "Cheng's Dog"));

		order1 = new Order("Customer Test", "READY", false, menuList.get(0));
		order2 = new Order("Customer Test2", "PENDING", true, menuList.get(1));

		fb1 = new Feedback(1, "Hi", userList.get(0));
		fb2 = new Feedback(2, "Hullo", userList.get(1));
		
		userList = new ArrayList<User>();
		stallList = new ArrayList<Stall>();
		menuList = new ArrayList<Menu>();
		orderList = new ArrayList<Order>();
		feedbackList = new ArrayList<Feedback>();
		queueList = new ArrayList<Queue>();
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
	
	public void testViewUser() {
		
	}
	
	public void testDeleteUser() {
		
	}

	@Test
	public void testAddStall() {
		assertNotNull("Test if there is valid Stall arraylist to add to", stallList);
		assertEquals("Test that the Stall arraylist is empty.", 0, stallList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addStall(stallList, stall1);
		assertEquals("Test that the Stall arraylist size is 1.", 1, stallList.size());

		// Add an item
		C206_CaseStudy.addStall(stallList, stall2);
		assertEquals("Test that the User arraylist size is now 2.", 2, stallList.size());

		// The item just added is as same as the last item in the list
		assertSame("Test that User is added to the end of the list.", user2, stallList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addStall(stallList, stall2);
		assertEquals("Test that the User arraylist size is unchange.", 2, stallList.size());

		// Add an item that has missing detail
		Stall stall_missing = new Stall("Kim's Ricecake","");
		C206_CaseStudy.addStall(stallList, stall_missing);
		assertEquals("Test that the Stall arraylist size is unchange.", 2, stallList.size());
	}
	
	public void testViewStall() {
		
	}
	
	public void testDeleteStall() {
		
	}
	
	@Test
	public void testAddMenu() {
		assertNotNull("Test if there is valid Menu arraylist to add to", menuList);
		assertEquals("Test that the Menu arraylist is empty.", 0, menuList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addMenu(menuList, menu1);
		assertEquals("Test that the Stall arraylist size is 1.", 1, menuList.size());

		// Add an item
		C206_CaseStudy.addMenu(menuList, menu2);
		assertEquals("Test that the User arraylist size is now 2.", 2, menuList.size());

		// The item just added is as same as the last item in the list
		assertSame("Test that User is added to the end of the list.", user2, menuList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addMenu(menuList, menu2);
		assertEquals("Test that the User arraylist size is unchange.", 2, menuList.size());

		// Add an item that has missing detail
		Menu menu_missing = new Menu("Ricecake",5.00 ,"");
		C206_CaseStudy.addMenu(menuList, menu_missing);
		assertEquals("Test that the Menu arraylist size is unchange.", 2, menuList.size());
	}
	
	public void testViewMenu() {
		
	}
	
	public void testDeleteMenu() {
		
	}

	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
		stall1 = null;
		stall2 = null;
		stall3 = null;
		stall4 = null;
		menu1 = null;
		menu2 = null;
		menu3 = null;
		menu4 = null;
		menu5 = null;
		menu6 = null;
		menu7 = null;
		menu8 = null;
		order1 = null;
		order2 = null;
		fb1 = null;
		fb2 = null;
		userList = null;
		stallList = null;
	
	}

}
