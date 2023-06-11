package main;

public class Subject {
	
	private String subjectCode;
	private String subjectDescription;
	
	public Subject(String subjectCode, String subjectDescription) {
		this.subjectCode = subjectCode;
		this.subjectDescription = subjectDescription;
	}
	
	public String getSubjectCode() {
		return subjectCode;
	}
	
	public String getSubjectDescription() {
		return subjectDescription;
	}

}
