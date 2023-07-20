/* This class is a subclass of @Student - a student that has grades. It defines the grades of a student in a 
 * particular subject, thus it has fields for the subject and professor. 
 * 
 * It includes the professor's faculty no, as we use ID numbers to identify a student or faculty, not names.
 */

package models;

public class StudentGrade extends Student {
	
	private String subjectCode, subjectDescription;
	private String professorFacultyNo, professorName; 
	private double midtermGrade, finalsGrade, finalRating;
	private int totalAttendance;
	private String remark;
	
	public StudentGrade(String studentNo, String firstName, String lastName, String sectionCode, String subjectCode, String subjectDescription, 
			String professorFacultyNo, String professorName, double midtermGrade, double finalsGrade, double finalRating, int totalAttendance, String remark) {
		
		super(studentNo, firstName, lastName, sectionCode);
		this.subjectCode = subjectCode;
		this.subjectDescription = subjectDescription;
		this.professorFacultyNo = professorFacultyNo;
		this.professorName = professorName;
		this.midtermGrade = midtermGrade;
		this.finalsGrade = finalsGrade;
		this.finalRating = finalRating;
		this.totalAttendance = totalAttendance;
		this.remark = remark;
	}
	
	public String getStudentName() {
		String studentName = getLastName()+", "+getFirstName();
		return studentName;
	}
	
	public String getSubjectCode() {
		return subjectCode;
	}
	
	public String getSubjectDescription() {
		return subjectDescription;
	}
	
	public String getProfessorFacultyNo() {
		return professorFacultyNo;
	}
	
	public String getProfessorName() {
		return professorName;
	}
	
	public double getMidtermGrade() {
		return midtermGrade;
	}
	
	public void setMidtermGrade(double midtermGrade) {
		this.midtermGrade = midtermGrade;
	}
	
	public double getFinalsGrade() {
		return finalsGrade;
	}
	
	public void setFinalsGrade(double finalsGrade) {
		this.finalsGrade = finalsGrade;
	}
	
	public double getFinalRating() {
		finalRating = (midtermGrade + finalsGrade)/2;
		return finalRating;
	}
	
	public int getTotalAttendance() {
		return totalAttendance;
	}
	
	public void setTotalAttendace(int totalAttendance) {
		this.totalAttendance = totalAttendance;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
