import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		 ArrayList<Stall> stallList = new ArrayList<Stall>();
		 ArrayList<User> userList = new ArrayList<User>();

	        stallList.add(new Stall("XY's Burgs and Fries", "Western Cuisine"));
	        stallList.add(new Stall("Kim's Ricecake", "Korean Cuisine"));
	        stallList.add(new Stall("Ayam Penyet", "Malay Cuisine"));
	        stallList.add(new Stall("Waaow", "Fusion"));
	        
	        userList.add(new User("Customer Test", "customer@gmail.com", "1234"));
	        userList.add(new User("Staff Test", "staff@gmail.com", "5678"));
	        
	        
	        int option = 0;

	        char logIn = Helper.readChar("Log in as Customer or Stall Owner? (C/S) >" );
	        
	        
	        if (logIn == 'C' && logIn == 'c') {
	        	
	        	
	        }

	        while (option != 10) {
	            C206_CaseStudy.menu();
	            option = Helper.readInt("Enter an option > ");
	            
	            if (option == 1) {
	            	C206_CaseStudy.viewAllStalls(stallList);
	            	C206_CaseStudy.viewAllUsers(userList);
	            	
	            }
	            
	            else if (option == 2) {
	            	
	          
	            }
	            
	            else if (option == 3) {
	            	
	            	
	            }

	        }
	}



	private static void menu() {
		// TODO Auto-generated method stub
		
		
		
	}
	
	private static void viewAllStalls(ArrayList<Stall> stallList) {
		// TODO Auto-generated method stub
        Helper.line(50, "=");
        System.out.println("STALL LIST");
        Helper.line(50, "=");
        
        for (int i = 0; i < stallList.size(); i++) {
        	 String output = String.format("%-20s %27s\n", "STALL NAME", "DESCRIPTION");
             output += String.format("%-20s %27s\n", stallList.get(i).getName(), stallList.get(i).getDescription());
            System.out.println(output);
        }
        
       
    }
		
	
	
	private static void viewAllUsers(ArrayList<User> userList) {
		// TODO Auto-generated method stub
		Helper.line(70, "=");
		System.out.println("USER LIST");
		Helper.line(70, "=");
		
		for (int i = 0; i < userList.size();i++) {
			String output = String.format("%-20s %30s %30s\n", "USERNAME", "EMAIL", "PASSWORD");
			output += String.format("%-20s %30s %30s\n", userList.get(i).getName(), userList.get(i).getEmail(), userList.get(i).getPassword());
			System.out.println(output);
		}
		
		
	}

	

}
