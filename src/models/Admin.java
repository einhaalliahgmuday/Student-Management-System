// This is the class for Admin. The admin manages the student records, thus it has methods to delete and create one.

package models;

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
	
	
	/* This methods allows the professor to create a student record.
	 * It receives a @Student object as a parameter, then throws it to "createStudentRecord()" method in @SQLData class.
	 */
	public void createStudentRecord(Student student) throws SQLException  {
		sql.createStudentRecord(student);
		
		var facultyLoads = sql.getFacultyLoads();
		
		for (var facultyLoad : facultyLoads) {
			if (facultyLoad.getSectionCode().equals(student.getSectionCode())) {
				sql.createStudentGrade(new StudentGrade(student.getStudentNo(), student.getFirstName(), student.getLastName(),
						student.getSectionCode(), facultyLoad.getSubjectCode(), facultyLoad.getSubjectDescription(), facultyLoad.getProfessorFacultyNo(), 
						facultyLoad.getProfessorName()));
			}
		}
	}
	
	/* This methods allows the admin to delete a student record.
	 * It receives a @Student object as a parameter, then throws it to "deleteStudentRecord()" method in @SQLData class.
	 */
	public void deleteStudentRecord(Student student) throws SQLException {
		sql.deleteStudentRecord(student);
		
		for (var studentGrade : sql.getStudentGrades()) {
			if (studentGrade.getStudentNo().equals(student.getStudentNo())) {
				sql.deleteStudentGrade(studentGrade);
			}
		}
	}
}
