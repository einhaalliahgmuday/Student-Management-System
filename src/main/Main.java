package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("STUDENT MANAGEMENT SYSTEM");
		System.out.println();
		
		Professor prof = new Professor("2021-00214-BN-0", "123123", "Einha", "Genciana", "Muday", "einhaalliahgmuday", 
				null, "Ganado, Binan");
		
		Section BSIT21 = new Section("BSIT", 2, 1);
		BSIT21.addStudent(new Student("2021-00214-BN-0", "Einha Alliah", "Genciana", "Muday", 
				'F', 2003, 2, 19, "BSIT", 2, 1, "einhaalliahgmuday@gmail.com", "09123456789", "Ganado, Binan, Laguna"));
		
		Section DICT21 = new Section("DICT", 2, 1);
		
		
		Subject OOP = new Subject("COMP20083", "Object Oriented Programming");
		
		prof.addFacultyLoad(new FacultyLoad(OOP, BSIT21, "M 2:00PM-5:00PM"));
		BSIT21.displayClassList();
		prof.addFacultyLoad(new FacultyLoad(OOP, DICT21, "T 2:00PM-5:00PM"));
		
		System.out.println();
		
		ArrayList<FacultyLoad> facultyLoads = prof.getFacultyLoads();
		prof.displayFacultyLoads();	
	}
}
