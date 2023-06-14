package main;

import java.util.ArrayList;

public class Section {
	
	private String course;
	private int year;
	private int section;
	private String sectionCode;
	private ArrayList<Student> classList = new ArrayList<>();
	
	public Section(String course, int year, int section) {
		this.course = course;
		this.year = year;
		this.section = section;
		sectionCode = course + " " + Integer.toString(year) + "-" + Integer.toString(section);
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setSection(int section) {
		this.section = section;
	}
	
	public String getSectionCode() {
		return sectionCode;
	}
	
	public ArrayList<Student> getStudents() {
		return classList;
	}
	
	public void addStudent(Student student) {
		classList.add(student);
	}
	
	public void removeStudent(Student student) {
		classList.remove(student);
	}
	
	public void displayClassList() {
		for(Student student : classList) {
			System.out.println(student);
		}
	}

}
