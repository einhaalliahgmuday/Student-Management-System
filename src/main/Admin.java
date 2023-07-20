package main;

import java.sql.SQLException;
import data.SQLData;

public class Admin {
	
	private SQLData sql = new SQLData();

	private String adminNo, password;
	private String firstName, middleName, lastName;
	private String email, contactNo;
	
	public Admin(String facultyNo, String password, String firstName, String middleName, String lastName, 
			String email, String contactNo) throws SQLException {
		
		this.adminNo = facultyNo;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
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
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	
	public void createStudentRecord(Student student) throws SQLException {
		sql.createStudentRecord(student);
	}
	
	public void deleteStudentRecord(Student student) throws SQLException {
		sql.deleteStudentRecord(student);
	}
}
