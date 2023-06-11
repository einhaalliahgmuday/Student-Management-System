package main;

public class FacultyLoad {

	private Subject subject;
	private Section section;
	private String schedule;
	
	public FacultyLoad(Subject subject, Section section, String schedule) {
		this.subject = subject;
		this.section = section;
		this.schedule = schedule;
	}
	
	public String getSubjectCode() {
		return subject.getSubjectCode();
	}
	
	public String getSubjectDescription() {
		return subject.getSubjectDescription();
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
	
	public String toString() {
		return subject.getSubjectCode() + "	" + subject.getSubjectDescription() + "	" + section.getSectionCode()
				+ "	" + schedule;
	}
}
