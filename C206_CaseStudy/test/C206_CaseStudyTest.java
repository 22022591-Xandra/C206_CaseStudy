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

	menu1 = new Menu("Burger", 5.00, stallList.get(0));
	menu2 = new Menu("Fries", 5.00, stallList.get(0));
	menu3 = new Menu("Ricecake", 5.00, stallList.get(1));
	menu4 = new Menu("Ramyun", 5.00, stallList.get(1));
	menu5 = new Menu("Ayam", 5.00, stallList.get(2));
	menu6 = new Menu("Nasi", 5.00, stallList.get(2));
	menu7 = new Menu("Dog", 5.00, stallList.get(3));
	menu8 = new Menu("Cat", 5.00, stallList.get(3));

	
	order1 = new Order("Customer Test", "READY", false, menuList.get(0));
	order2= new Order("Customer Test2", "PENDING", true, menuList.get(1));

	fb1 = new Feedback(1, "Hi", userList.get(0));
	fb2 = new Feedback(2, "Hullo", userList.get(1));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
