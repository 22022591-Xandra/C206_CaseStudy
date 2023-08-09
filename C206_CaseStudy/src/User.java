

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
