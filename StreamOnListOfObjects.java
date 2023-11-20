import java.util.ArrayList;
import java.util.List;

class Student {
    private int rollNum;
    private int marks;
    private String studnetName;

    public Student(String studentName, int rollNum, int marks) {
        this.studnetName = studentName;
        this.rollNum = rollNum;
        this.marks = marks;
    }

    public int getRollNum() {
        return rollNum;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return studnetName;
    }

    public String toString() {
        return "Name - " + studnetName + "   Roll Number - " + rollNum + "   Marks - " + marks;
    }
}

public class StreamOnListOfObjects {
    public static void main(String[] args) {
        String[] name = { "Aadith", "Anju", "Greeshma", "John", "Peter" };
        int[] rollNum = { 1, 2, 3, 4, 5 };
        int[] marks = { 88, 91, 87, 95, 85 };

        List<Student> student = new ArrayList<>();

        for (int i = 0; i < rollNum.length; i++) {
            student.add(new Student(name[i], rollNum[i], marks[i]));
        }

        System.out.println("\nAll students detail");
        student.stream()
                .forEach(n -> System.out.println(n));

        System.out.println("\nStudents with mark greater than 90");
        student.stream()
                .filter(n -> n.getMarks() > 90)
                .forEach(n -> System.out.println(n));

        // Average marks of students
        double averageMarks = student.stream()
                .mapToDouble(n -> n.getMarks())
                .average()
                .orElse(0);
        System.out.println("\nAverage Mark of students - " + averageMarks);
        System.out.println();
    }
}
