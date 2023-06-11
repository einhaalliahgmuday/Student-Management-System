package main;

public class Student {
	
	private String studentNo;
	private String firstName, middleName, lastName;	private String name;
	private char sex;	
	private int birthMonth, birthDay, birthYear;	private String birthDate;
	private String course;	private int year, section;	private String sectionCode;
	private String email; 
	private String contactNo;
	private String address; 
	
	//OVERLOAD CONSTRUCTORS?
	//those without middle name
	
	Student(String studentNo, String firstName, String middleName, String lastName, 
			char sex, int birthMonth, int birthDay, int birthYear, 
			String course, int year, int section, String email, String contactNo, String address) {
		
		this.studentNo = studentNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		name = firstName + " " + middleName + " " + lastName;
		this.sex = sex;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.birthYear = birthYear;
		birthDate = birthYear + "-" + birthMonth + "-" + birthDay;
		this.course = course;
		this.year = year;
		this.section = section;
		sectionCode = course + " " + year + "-" + section;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	
	public String getName() {
		return name;
	}
	
	public char getSex() {
		return sex;
	}

    public String getBirthDate() {
        return birthDate;
    }

    public String getSectionCode() {
        return sectionCode;
    }
    
    public void setSectionCode(String course, int year, int section) {
    	this.course = course;
    	this.year = year;
    	this.section = section;
    	sectionCode = course + " " + year + "-" + section;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String contactNo() {
        return contactNo;
    }
    
    public void setContactNo(String contactNo) {
    	this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
    
    @Override
    public String toString() {
    	return studentNo + "	" + name + "	" + sex + "	" + birthDate + "	" + 
    			sectionCode + "	" + email + "	" + contactNo + "	" + address;
    }

}