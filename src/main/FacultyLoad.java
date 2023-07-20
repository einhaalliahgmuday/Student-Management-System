package main;

import java.sql.SQLException;
import java.util.ArrayList;

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
		gradingSheet = sql.getStudentGrades(sectionCode, subjectCode, professorFacultyNo);
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
	
	public ArrayList<StudentGrade> getGradingSheet() throws SQLException {
		return gradingSheet;
	}
	
	public void updateGradeSheet() throws SQLException {
		gradingSheet = sql.getStudentGrades(sectionCode, subjectCode, professorFacultyNo);
	}
	
	public StudentGrade getStudentGradeByStudentNo(String studentNo) throws SQLException {		
		StudentGrade foundStudentGrade = null;
		
		for (var studentGrade : getGradingSheet()) {
			if (studentGrade.getStudentNo().equals(studentNo)) {
				foundStudentGrade = studentGrade;
			}
		}
		
		return foundStudentGrade;
	}
	
	public String toString() {
		return year + "	" + semester + "	" + professorFacultyNo + "	" + subjectCode + "	" + subjectDescription 
				+ "	" + sectionCode + "	" + schedule;
	}
}
