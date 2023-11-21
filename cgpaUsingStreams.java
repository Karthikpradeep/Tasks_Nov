import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
class Student{
    private int studentId;
    private String studentName;
    private double cgpa;

    public Student(int studentId,String studentName,double cgpa ){
        this.studentId = studentId;
        this.studentName = studentName;
        this.cgpa = cgpa;
    }
    public int getId(){
        return studentId;
    }

    public String getName(){
        return studentName;
    }

    public double getCgpa(){
        return cgpa;
    }
}
public class cgpaUsingStreams {
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("---- Student menu ----");
            System.out.println("1. Enter number of students");
            System.out.println("2. create student");
            System.out.println("3. Filtering ");
            System.out.println("4. exit");

            System.out.print("Enter your choice - ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter total number of students - ");
                    int numOfStudents = sc.nextInt();
                    break;
                case 2:
                    System.out.print("Enter the student id - ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student name - ");
                    String name = sc.nextLine();
                    System.out.print("Enter the cgpa - ");
                    double gpa =sc.nextDouble();

                    students.add(new Student(id, name, gpa));
                    break;
                case 3:
                    System.out.println("Students sorted by CGPA:");
                    students.stream()
                            .sorted(Comparator.comparing(Student::getCgpa).reversed()
                                    .thenComparing(Student::getName)
                                    .thenComparing(Student::getId))
                            .forEach(student -> System.out.println(
                                    " Name: " + student.getName()));
                    break;
                case 4:
                    System.out.println("Exiting the system");
                    System.exit(0);
                
                default:
                    System.out.println("!!! Invalid Input !!! ");
                    break;
            }
        }
    }
    
}
