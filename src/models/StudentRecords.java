//This class describes student records as an entity. It has ArrayList of students, which makes up the student records.

package models;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

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
	
	//This method sorts the ArrayList of student records based on the students' student uniqueNumber.
	public void sortStudentRecords() {
		Collections.sort(studentRecords, new Comparator<Student>() {
			@Override
	        public int compare(Student student1, Student student2) {
	            return student1.getStudentNo().compareTo(student2.getStudentNo());
	        }
	    });
	}
	
	/* This method allows retrieval of a student record using the student's student uniqueNumber.
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
	
	public String generateStudentNo() throws SQLException {
		int uniqueNum = 0;
		
		for (var student : sql.getStudentRecords()) {
			int num = Integer.parseInt(student.getStudentNo().toString().substring(5, 10));
			uniqueNum = Math.max(uniqueNum, num);
		}
		
		uniqueNum++;
		
		String studentNo = null;
		
		if (uniqueNum < 10) {
			studentNo = "2021-0000"+uniqueNum+"-BN-0";
		}
		else if (uniqueNum < 100) {
			studentNo = "2021-000"+uniqueNum+"-BN-0";
		}
		else if (uniqueNum < 1000) {
			studentNo = "2021-00"+uniqueNum+"-BN-0";
		}
		else if (uniqueNum < 10000) {
			studentNo = "2021-0"+uniqueNum+"-BN-0";
		}
		
		return studentNo;
	}

}
