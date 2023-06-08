package models;

public class FacultyLoad {

	public Subject subject;
	public String sectionCode;
	public String schedule;
	
	public FacultyLoad(Subject subject, String sectionCode, String schedule) {
		
		this.subject = subject;
		this.sectionCode = sectionCode;
		this.schedule = schedule;
	}
	
	public void DisplayFacultyLoad() {
		
		System.out.println("Subject Code:	" + subject.subjectCode);
		System.out.println("Description:	" + subject.subjectDescription);
		System.out.println("Section Code:	" + sectionCode);
		System.out.println("Schedule:	" + schedule);
	}

}
