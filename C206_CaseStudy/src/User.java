/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: tay xin yu
 * Student ID: 22012885
 * Class: C206-5D-W64M-A
 * Date/Time created: Monday 07-08-2023 13:30
 */

/**
 * @author  22012885
 *
 */

public class User{
	String name;
	String email;
	String password;
	boolean employee;

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public User(String name, String email, String password, boolean employee) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.employee = employee;
	}

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}	
	public boolean getEmp() {
		return employee;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
