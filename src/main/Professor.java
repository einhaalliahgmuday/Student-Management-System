package main;

import java.sql.SQLException;
import java.util.ArrayList;

import data.SQLData;

public class Professor {
	
	private SQLData sql = new SQLData();

	private String facultyNo, password;
	private String firstName, middleName, lastName;
	private String email, contactNo;
	
	private ArrayList<FacultyLoad> facultyLoads;
	
	public Professor(String facultyNo, String password, String firstName, String middleName, String lastName, 
			String email, String contactNo) throws SQLException {
		
		this.facultyNo = facultyNo;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		
		facultyLoads = sql.getFacultyLoads(this.facultyNo);
	}
	
	public String getFacultyNo() {
		return facultyNo;
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
	
	public ArrayList<FacultyLoad> getFacultyLoads() {
		return facultyLoads;
	}
	
	public void updateStudentGrade(StudentGrade studentGrade) throws SQLException {
		sql.updateStudentGrade(studentGrade);
	}
}
