public class Class {
    public static void main(String[] args) {
        ClassList student = new ClassList("Danica Cabrera", 22, "2021-00155-BN-0", "2001-03-21", "109 Almeda Subdivision", "cabreradanica507@gmail.com", "BSIT", "2-1");
        
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Student Number: " + student.getStudentNumber());
        System.out.println("Birthday: " + student.getBirthday());
        System.out.println("Address: " + student.getAddress());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Course: " + student.getCourse());
        System.out.println("Section: " + student.getSection());
        
    }
}
