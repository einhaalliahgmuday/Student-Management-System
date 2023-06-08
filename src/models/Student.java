package models;

public class Student {
	
	String studentNo, firstName, middleName, lastName;
	char sex;	int birthMonth, birthDay, birthYear;
	String course;	int yearLevel, section;
	String address, email, contactNo;
	
	Student(String studentNo, String firstName, String middleName, String lastName, 
			char sex, int birthMonth, int birthDay, int birthYear, 
			String course, int yearLevel, int section, 
			String contactNo, String email, String address) {
		
		this.studentNo = studentNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.sex = sex;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.birthYear = birthYear;
		this.course = course;
		this.yearLevel = yearLevel;
		this.section = section;
		this.contactNo = contactNo;
		this.email = email;
		this.address = address;
	}
	
	//getters and setters
	//ArrayList of Students per section
	//name = firstName+middleName+lastName
	//section = course+yearLevel+section

}
