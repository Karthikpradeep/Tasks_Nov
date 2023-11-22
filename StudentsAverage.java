
/*Assume you have a CSV file (students.csv) with the following format:

Name,Math,Science,English
John,90,85,95
Jane,80,92,88

Write a Java program that reads this CSV file, calculates the average grade for each student, 
and writes the student names along with their average grades to another text file (results.txt). */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int math;
    private int science;
    private int english;
    private double average;

    public Student(String name, int math, int science, int english) {
        this.name = name;
        this.math = math;
        this.science = science;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public int getMath() {
        return math;
    }

    public int getScience() {
        return science;
    }

    public int getEnglish() {
        return english;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}

public class StudentsAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the path of the csv file - ");
        String path = sc.nextLine();
        List<Student> students = new ArrayList<>();
        try (BufferedReader bffRead = new BufferedReader(new FileReader(path))) {
            String line;
            int lineNumber = 0;
            while ((line = bffRead.readLine()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length == 4) {
                    String name = values[0].trim();
                    int math = Integer.parseInt(values[1].trim());
                    int science = Integer.parseInt(values[2].trim());
                    int english = Integer.parseInt(values[3].trim());
                    Student student = new Student(name, math, science, english);
                    students.add(student);
                } else {
                    System.out.println("Invalid data format: " + line);
                }
            }
            DecimalFormat df = new DecimalFormat("#.###");
            for (Student student : students) {
                int total = student.getMath() + student.getScience() + student.getEnglish();
                double average = (double) total / 3;
                String formatedAverage = df.format(average);
                student.setAverage(Double.parseDouble(formatedAverage));
            }
            System.out.print("Enter the path of the resulting file - ");
            String destinationPath = sc.nextLine();
            try (BufferedWriter bffwrite = new BufferedWriter(new FileWriter(destinationPath))) {
                for (Student student : students) {
                    bffwrite.write(student.getName() + " - " + student.getAverage());
                    bffwrite.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            sc.close();
        }

    }
}
