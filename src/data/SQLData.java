package data;

import java.sql.*;
import java.util.*;

import main.*;

public class SQLData {
	
	private Connection connection;
	
	public SQLData() throws SQLException {
		createSQLConnection();
	}
	
	private void createSQLConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root", "Group3SMS!");
	}
	
	public ArrayList<Admin> getAdmins() throws SQLException {
		String selectStatement = "SELECT * FROM admin";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(selectStatement);
		
		ArrayList<Admin> admins = new ArrayList<Admin>();	
		while(resultSet.next()) {
			admins.add(new Admin(
					resultSet.getString("adminno"), 
					resultSet.getString("smspassword"), 
					resultSet.getString("firstname"),
					resultSet.getString("middlename"), 
					resultSet.getString("lastname"),
					resultSet.getString("email"), 
					resultSet.getString("contactno")));
		}
		
		resultSet.close();
		statement.close();
		
		return admins;
	}
	
	public ArrayList<Professor> getProfessors() throws SQLException {
		String selectStatement = "SELECT * FROM professor";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(selectStatement);
		
		ArrayList<Professor> professors = new ArrayList<Professor>();	
		while(resultSet.next()) {
			professors.add(new Professor(
					resultSet.getString("facultyno"),
					resultSet.getString("smspassword"),
					resultSet.getString("firstname"),
					resultSet.getString("middlename"), 
					resultSet.getString("lastname"),
					resultSet.getString("email"), 
					resultSet.getString("contactno")));
		}
		
		resultSet.close();
		statement.close();
		
		return professors;
	}
	
	public ArrayList<FacultyLoad> getFacultyLoads(String facultyNo) throws SQLException {
		String selectStatement = "SELECT * FROM facultyload WHERE facultyno = '"+facultyNo+"'";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(selectStatement);
		
		ArrayList<FacultyLoad> facultyLoads = new ArrayList<FacultyLoad>();	
		while(resultSet.next()) {
			facultyLoads.add(new FacultyLoad(
					Integer.parseInt(resultSet.getString("year")),
					resultSet.getString("semester"),
					resultSet.getString("facultyno"), 
					resultSet.getString("subjectcode"), 
					resultSet.getString("subjectdescription"), 
					resultSet.getString("sectioncode"), 
					resultSet.getString("schedule")));
		}
		
		resultSet.close();
		statement.close();
		
		return facultyLoads;	
	}
	
	public ArrayList<Student> getStudentRecords() throws SQLException {
		String selectStatement = "SELECT * FROM student";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(selectStatement);
		
		ArrayList<Student> studentRecords = new ArrayList<Student>();
		
		while(resultSet.next()) {
			studentRecords.add(new Student(
					resultSet.getString("studentno"), 
					resultSet.getString("firstname"), 
					resultSet.getString("middlename"), 
					resultSet.getString("lastname"), 
					resultSet.getString("sex"), 
					resultSet.getDate("birthday"), 
					resultSet.getString("sectioncode"), 
					resultSet.getString("email"), 
					resultSet.getString("contactno"), 
					resultSet.getString("address")));
		}
		
		resultSet.close();
		statement.close();
		
		return studentRecords;	
	}
	
	public void createStudentRecord(Student student) throws SQLException {
		String insertStatement = "INSERT INTO student VALUES ('"+
									student.getStudentNo()+"', '"+
									student.getFirstName()+"', '"+
									student.getMiddleName()+"', '"+
									student.getLastName()+"', '"+ 
									student.getSex()+"', '"+
									student.getBirthday()+"', '"+
									student.getSectionCode()+"', '"+
									student.getEmail()+"', '"+
									student.getContactNo()+"', '"+
									student.getAddress()+"')";
		Statement statement = connection.createStatement();
		statement.executeUpdate(insertStatement);
		
		statement.close();
	}
	
	public void deleteStudentRecord(Student student) throws SQLException {
		String deleteStatement = "DELETE FROM student WHERE studentno = '"+ student.getStudentNo()+"'";
		Statement statement = connection.createStatement();
		statement.executeUpdate(deleteStatement);
		
		statement.close();
	}
	
	public ArrayList<StudentGrade> getStudentGrades(String sectionCode, String subjectCode, String professorFacultyNo) throws SQLException {
		String selectStatement = "SELECT * FROM studentgrade WHERE sectioncode = '"+sectionCode+"' AND subjectcode = '"+subjectCode+
				"' AND professorfacultyno = '"+professorFacultyNo+"'";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(selectStatement);
		
		ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
		
		while(resultSet.next()) {
			studentGrades.add(new StudentGrade(
					resultSet.getString("studentno"),
					resultSet.getString("firstname"),
					resultSet.getString("lastname"),
					resultSet.getString("sectioncode"), 
					resultSet.getString("subjectcode"), 
					resultSet.getString("subjectdescription"),
					resultSet.getString("professorfacultyno"), 
					resultSet.getString("professorname"), 
					resultSet.getDouble("midtermgrade"), 
					resultSet.getDouble("finalsgrade"), 
					resultSet.getDouble("finalrating"), 
					resultSet.getInt("totalattendance"), 
					resultSet.getString("remark")));
		}
		
		resultSet.close();
		statement.close();
		
		return studentGrades;	
	}
	
	public void updateStudentGrade(StudentGrade studentGrade) throws SQLException {
		
		String updateStatement = "UPDATE studentgrade SET midtermgrade = "+studentGrade.getMidtermGrade()+", finalsgrade = "+
		studentGrade.getFinalsGrade()+", finalrating = "+studentGrade.getFinalRating()+", totalattendance = "+studentGrade.getTotalAttendance()+
		", remark = '"+studentGrade.getRemark()+"' "+ "WHERE studentno = '"+studentGrade.getStudentNo()+"'";
		Statement statement = connection.createStatement();
		statement.executeUpdate(updateStatement);
		
		statement.close();
	}
	
	public ArrayList<Student> getClassList(String sectionCode) throws SQLException {
		String selectStatement = "SELECT * FROM student WHERE sectioncode = '"+sectionCode+"'";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(selectStatement);
		
		ArrayList<Student> classList = new ArrayList<Student>();
		
		while(resultSet.next()) {
			classList.add(new Student(
					resultSet.getString("studentno"), 
					resultSet.getString("firstname"), 
					resultSet.getString("middlename"), 
					resultSet.getString("lastname"), 
					resultSet.getString("sex"), 
					resultSet.getDate("birthday"), 
					resultSet.getString("sectioncode"), 
					resultSet.getString("email"), 
					resultSet.getString("contactno"), 
					resultSet.getString("address")));
		}
		
		resultSet.close();
		statement.close();
		
		return classList;	
	}

}
