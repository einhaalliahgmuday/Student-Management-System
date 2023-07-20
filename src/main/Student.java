package main;

import java.util.Date;

public class Student {
	
	private String studentNo;
	private String firstName, middleName, lastName;
	private String sex;	
	private Date birthday;
	private String sectionCode;
	private String email; 
	private String contactNo;
	private String address; 
	
	public Student(String studentNo, String firstName, String middleName, String lastName, 
			String sex, Date birthday, String sectionCode, String email, String contactNo, String address) {
		
		this.studentNo = studentNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.sex = sex;
		this.birthday = birthday;
		this.sectionCode = sectionCode;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
	}
	
	public Student(String studentNo, String firstName, String lastName, String sectionCode) {
		
		this.studentNo = studentNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sectionCode = sectionCode;
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getSex() {
		return sex;
	}
	
	public Date getBirthday() {
		return birthday;
	}

    public String getSectionCode() {
        return sectionCode;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }
    
    @Override
    public String toString() {
    	return studentNo + "	" + firstName + " " + middleName + " " + lastName + "	" + sex + "	" + birthday + "	" + 
    			sectionCode + "	" + email + "	" + contactNo + "	" + address;
    }

}
