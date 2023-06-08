package data;

import java.util.*;
import models.Subject;

public class SubjectData {
	
	public ArrayList <Subject> subjects = new ArrayList<Subject>();
	
	public void Data() {
		
		Subject COMP20083 = new Subject("COMP20083", "Object Oriented Programming");
		subjects.add(COMP20083);
	}
}
