package models;

public class Admin {

	String adminNo, password;
	String firstName, middleName, lastName;
	String email, contactNo, address;
	
	Admin(String facultyNo, String password, String firstName, String middleName, 
			String lastName, String email, String contactNo, String address) {
		
		this.adminNo = facultyNo;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
	}
}
