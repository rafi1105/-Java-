public class Student {
    private String name;
    private int studentID;
    private double cgpa;
    
    // Default constructor
    public Student() {
        name = "Unknown";
        studentID = 0;
        cgpa = 0.0;
    }
    
    // Constructor with two parameters
    public Student(String name, int studentID) {
        this.name = name;
        this.studentID = studentID;
        cgpa = 0.0;
    }
    
    // Constructor with object parameter
    public Student(Student other) {
        name = other.name;
        studentID = other.studentID;
        cgpa = other.cgpa;
    }
    
    // Display method
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentID);
        System.out.println("CGPA: " + cgpa);
    }
}

public class StudentExample {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("John Doe", 12345);
        Student student3 = new Student(student2);
        
        student1.display();
        System.out.println();
        student2.display();
        System.out.println();
        student3.display();
    }
}


        

