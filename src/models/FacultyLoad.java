/*
 * This class is for the ArrayList of faculty loads in @Professor. Aside from the basic properties, this class
 * has the class list and grading sheet. 
 * 
 * Class list and grading sheet are unique and dependent to a faculty load, thus is placed here.
 */

package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

import data.SQLData;

public class FacultyLoad {

	private SQLData sql = new SQLData();

	private int year;
	private String semester;
	private String professorFacultyNo;
	private String subjectCode, subjectDescription;
	private String sectionCode;
	private String schedule;
	
	private ArrayList<Student> classList;
	private ArrayList<StudentGrade> gradingSheet;
	
	public FacultyLoad(int year, String semester, String professorFacultyNo, String subjectCode, String subjectDescription, 
			String sectionCode, String schedule) throws SQLException {
		this.year = year;
		this.semester = semester;
		this.professorFacultyNo = professorFacultyNo;
		this.subjectCode = subjectCode;
		this.subjectDescription = subjectDescription;
		this.sectionCode = sectionCode;
		this.schedule = schedule;
		
		classList = sql.getClassList(this.sectionCode);
		sortClassList();
		gradingSheet = sql.getStudentGrades(this.sectionCode, this.subjectCode, this.professorFacultyNo);
		sortGradingSheet();
	}
	
	public int getYear() {
		return year;
	}
	
	public String getSemester() {
		return semester;
	}
	
	public String getProfessorFacultyNo() {
		return professorFacultyNo;
	}
	
	public String getSubjectCode() {
		return subjectCode;
	}
	
	public String getSubjectDescription() {
		return subjectDescription;
	}
	
	public String getSectionCode() {
		return sectionCode;
	}
	
	public String getSchedule() {
		return schedule;
	}
	
	public ArrayList<Student> getClassList() throws SQLException {
		return classList;
	}
	
	//This method sorts the ArrayList of class list alphabetically, based on the students' last name.
	public void sortClassList() {
		Collections.sort(classList, new Comparator<Student>() {
			@Override
	        public int compare(Student student1, Student student2) {
	            return student1.getLastName().compareTo(student2.getLastName());
	        }
	    });
	}
	
	public ArrayList<StudentGrade> getGradingSheet() throws SQLException {
		gradingSheet = sql.getStudentGrades(sectionCode, subjectCode, professorFacultyNo);
		sortGradingSheet();
		
		/* The value of ArrayList gradingSheet is updated everytime this method is called.
		 * This is because the @Professor updates the students' grades, and "getStudentGrades()" method of SQLData class
		 * is called again to get the updated data.
		 */
		
		return gradingSheet;
	}
	
	//This method sorts the ArrayList of grading sheet alphabetically, based on the students' last name.
	public void sortGradingSheet() {
		Collections.sort(gradingSheet, new Comparator<StudentGrade>() {
			@Override
	        public int compare(StudentGrade student1, StudentGrade student2) {
	            return student1.getStudentName().compareTo(student2.getStudentName());
	        }
	    });
	}
	
	/* This method allows retrieval of @StudentGrade using the student's student number.
	 * For-loop construct is used to find the @StudentGrade in ArrayList gradingSheet.
	 */
	public StudentGrade getStudentGradeByStudentNo(String studentNo) throws SQLException {		
		StudentGrade foundStudentGrade = null;
		
		for (var studentGrade : gradingSheet) {
			if (studentGrade.getStudentNo().equals(studentNo)) {
				foundStudentGrade = studentGrade;
			}
		}
		
		return foundStudentGrade;
	}
}
