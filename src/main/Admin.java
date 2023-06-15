package main;

public class Admin {

	private String adminNo, password;
	private String firstName, middleName, lastName;
	private String email, contactNo;
	
	//remove everything, and remain only the adminNo and password?
	
	Admin(String facultyNo, String password, String firstName, String middleName, 
			String lastName, String email, String contactNo, String address) {
		
		this.adminNo = facultyNo;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
	}
	
	public String getAdminNo() {
		return adminNo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
