import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//test data
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


	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Stall> stallList = new ArrayList<Stall>();
	private static ArrayList<Menu> menuList = new ArrayList<Menu>();
	private static ArrayList<Order> orderList = new ArrayList<Order>();
	private static ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();


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
		order2= new Order("Customer Test2", "PENDING", true, menuList.get(1));

		fb1 = new Feedback(1, "Hi", userList.get(0));
		fb2 = new Feedback(2, "Hullo", userList.get(1));
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

	public void testAddStall() {
		//Check whether stallList is not null and it is empty
		assertNotNull("Test if there is a valid Stall arraylist to add to", stallList);
		assertEquals("Test that the Stall arraylist is empty.", 0, stallList.size());
		// Given that it is an empty list, after adding 1 item, it increases the size of the list to 1
		C206_CaseStudy.addStall();
	}

	@After
	public void tearDown() throws Exception {
	}


}
