public class ClassList {
	
    String name;
    int age;
    String studentNumber;
    String birthday;
    String address;
    String email;
    String course;
    String section;

    public ClassList (String name, int age, String studentNumber, String birthday, String address, String email, String course, String section) {
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.course = course;
        this.section = section;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public String getSection() {
        return section;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
