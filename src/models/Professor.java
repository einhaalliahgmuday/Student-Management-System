package models;

public class Professor {

	String facultyNo, password;
	String firstName, middleName, lastName;
	String email, contactNo, address;
	
	Professor(String facultyNo, String password, String firstName, String middleName, 
			String lastName, String email, String contactNo, String address) {
		
		this.facultyNo = facultyNo;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
	}
}
