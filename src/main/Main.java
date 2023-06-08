package main;

import java.util.*;
import models.*;
import data.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("STUDENT MANAGEMENT SYSTEM");
		System.out.println();
		
		Professor prof1 = new Professor("2021-00214-BN-0", "202100214BN0", "Einha Alliah", 
				"Genciana", "Muday", "einhaalliahgmuday@gmail.com", "09123456789", 
				"Binan City, Laguna");
		
		Subject COMP20083 = new Subject("COMP20083", "Object Oriented Programming");
		
		prof1.facultyLoads.add(new FacultyLoad(COMP20083, "BSIT 2-1", "M 7:30NN-12:30PM"));
		
		for (int i = 0; i < prof1.facultyLoads.size(); i++) {
			
			prof1.facultyLoads.get(i).DisplayFacultyLoad();
			System.out.println();
		}

	}

}
