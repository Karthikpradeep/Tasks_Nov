import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String employeeName;
    private int employeeId;

    public Employee(String employeeName, int employeeId) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }

    public String getName() {
        return employeeName;
    }

    public int getId() {
        return employeeId;
    }

    public String toString() {
        return "Employee name - " + employeeName + " Employee id - " + employeeId;
    }
}

public class EmployeeByStream {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---- Employee menu ----");
            System.out.println("1. Create Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. List Employees");
            System.out.println("4. Search Employee");
            System.out.println("5. Sort Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice - ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee name - ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Id - ");
                    int employeeId = sc.nextInt();
                    sc.nextLine();
                    employees.add(new Employee(name, employeeId));
                    break;
                case 2:
                    System.out.print("Enter Employee Id - ");
                    int id = sc.nextInt();
                    employees.removeIf(employee -> employee.getId() == id);
                    break;
                case 3:
                    System.out.println("List of all employees ");
                    employees.forEach(employee -> System.out.println(employee));
                    break;
                case 4:
                    System.out.print("Enter the employee id to search - ");
                    int searchId = sc.nextInt();
                    sc.nextLine();
                    boolean employeeFound = employees.stream()
                            .anyMatch(employee -> employee.getId() == searchId);

                    if (employeeFound) {

                        employees.stream()
                                .filter(employee -> employee.getId() == searchId)
                                .forEach(n -> System.out.println(n));
                    } else {
                        System.out.println("Employee not found with ID: " + searchId);
                    }
                case 5:
                    employees.stream()
                            .map(employee -> employee.getName())
                            .sorted()
                            .forEach(employee -> System.out.println(employee));

                case 6:
                    System.out.println("Exiting the system");
                    System.exit(0);

            }
        }
        
    }
}
