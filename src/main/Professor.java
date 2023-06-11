package main;

import java.util.ArrayList;

public class Professor {

	private String facultyNo;
	private String password;
	private String firstName, middleName, lastName;
	private String email;
	private String contactNo;
	private String address;
	private ArrayList<FacultyLoad> facultyLoads  = new ArrayList<FacultyLoad>();
	
	public Professor(String facultyNo, String password, String firstName, String middleName, 
			String lastName, String email, String contactNo, String address) {
		
		this.facultyNo = facultyNo;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
	}
	
	public String getFacultyNo() {
		return facultyNo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getName() {
		String name = firstName + " " + middleName + " " + lastName;
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public ArrayList<FacultyLoad> getFacultyLoads() {
		return facultyLoads;
	}
	
	public void addFacultyLoad(FacultyLoad facultyLoad) {
		facultyLoads.add(facultyLoad);
	}
	
}
