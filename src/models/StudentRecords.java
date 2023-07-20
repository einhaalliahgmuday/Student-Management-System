//This class describes student records as an entity. It has ArrayList of students, which makes up the student records.

package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import data.SQLData;

public class StudentRecords {
	
	private SQLData sql = new SQLData();
	
	private ArrayList<Student> studentRecords;
	
	public StudentRecords() throws SQLException {
		studentRecords = sql.getStudentRecords();
		sortStudentRecords();
	}
	
	public ArrayList<Student> get() throws SQLException {
		studentRecords = sql.getStudentRecords();
		sortStudentRecords();
		
		return studentRecords;
	}
	
	//This method sorts the ArrayList of student records based on the students' student number.
	public void sortStudentRecords() {
		Collections.sort(studentRecords, new Comparator<Student>() {
			@Override
	        public int compare(Student student1, Student student2) {
	            return student1.getStudentNo().compareTo(student2.getStudentNo());
	        }
	    });
	}
	
	/* This method allows retrieval of a student record using the student's student number.
	 * For-loop construct is used to find the @Student in ArrayList studentRecords.
	 */
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
