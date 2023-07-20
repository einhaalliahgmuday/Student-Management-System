package main;

import java.sql.SQLException;
import java.util.ArrayList;

import data.SQLData;

public class StudentRecords {
	
	private SQLData sql = new SQLData();
	
	private ArrayList<Student> studentRecords = sql.getStudentRecords();
	
	public StudentRecords() throws SQLException {
		
	}
	
	public ArrayList<Student> get() throws SQLException {
		return studentRecords;
	}
	
	public void update() throws SQLException {
		studentRecords = sql.getStudentRecords();
	}
	
	public Student getStudentRecordByStudentNo(String studentNo) throws SQLException {
		Student foundStudentRecord = null;
		
		for (var student : studentRecords) {
			if (student.getStudentNo().equals(studentNo)) {
				foundStudentRecord = student;
			}
		}
		
		return foundStudentRecord;
	}

}
