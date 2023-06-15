package main;

public class Grade {
	
	private FacultyLoad facultyLoad;
	private float midtermGrade, finalsGrade, finalRating;
	private int totalAttendance;
	private char remark;
	
	public Grade(FacultyLoad facultyLoad, float midtermGrade, float finalsGrade, int totalAttendance, char remark) {
		this.facultyLoad = facultyLoad;
		this.midtermGrade = midtermGrade;
		this.finalsGrade = finalsGrade;
		this.finalRating = (midtermGrade + finalsGrade) / 2;
		this.totalAttendance = totalAttendance;
		this.remark = remark;
	}
	
	public float getMidtermGrade() {
		return midtermGrade;
	}
	
	public void setMidtermGrade(float midtermGrade) {
		this.midtermGrade = midtermGrade;
	}
	
	public float getFinalsGrade() {
		return finalsGrade;
	}
	
	public void setFinalsGrade(float finalsGrade) {
		this.finalsGrade = finalsGrade;
	}
	
	public float getFinalRating() {
		return finalRating;
	}
	
	public int getTotalAttendance() {
		return totalAttendance;
	}
	
	public void setTotalAttendance(int totalAttendance) {
		this.totalAttendance = totalAttendance;
	}
	
	public char getRemark() {
		return remark;
	}
	
	public void setRemark(char remark) {
		this.remark = remark;
	}
	
	

}
