package main;

public class FacultyLoad {

	private int schoolYear, semester;
	private String subjectCode, subjectDescription;
	private Section section;
	private String schedule;
	private int totalMeetings;
	
	//add professor as attribute?
	
	public FacultyLoad(int schoolYear, int semester, String subjectCode, String subjectDescription, 
			Section section, String schedule) {
		this.schoolYear = schoolYear;
		this.semester = semester;
		this.subjectCode = subjectCode;
		this.subjectDescription = subjectDescription;
		this.section = section;
		this.schedule = schedule;
		this.totalMeetings = 0;
	}
	
	public int getSchoolYear() {
		return schoolYear;
	}
	
	public int getSemester() {
		return semester;
	}
	
	public String getSubjectCode() {
		return subjectCode;
	}
	
	public String getSubjectDescription() {
		return subjectDescription;
	}
	
	public String getSectionCode() {
		return section.getSectionCode();
	}
	
	public String getSchedule() {
		return schedule;
	}
	
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	public int getTotalMeetings() {
		return totalMeetings;
	}
	
	public void setTotalMeetings(int totalMeetings) {
		this.totalMeetings = totalMeetings;
	}
	
	public String toString() {
		return subjectCode + "	" + subjectDescription + "	" + section.getSectionCode()
				+ "	" + schedule;
	}
}
