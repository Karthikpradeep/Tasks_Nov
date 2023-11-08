import java.util.Scanner;
import java.util.HashMap;

class employee {
    private String name;
    private int employeeId;

    public employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public int getid() {
        return employeeId;
    }

    public void displayDetails() {
        System.out.println("Employee name - " + name);
        System.out.println("Employee id - " + employeeId);
    }

    public double calculateSalary() {
        return 0.0;
    }

}

class permanentEmployee extends employee {
    private double salary;

    public permanentEmployee(String name, int employeeId, double salary) {
        super(name, employeeId);
        this.salary = salary;
    }

    public double calculateSalary() {
        return salary;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee type - Permanent Employee");
        System.out.println("Salary - " + calculateSalary() + " rs");
    }
}

class parttimeEmployee extends employee {
    private double hoursWorked;
    private int hourlyRate;

    public parttimeEmployee(String name, int employeeId, double hoursWorked, int hourlyRate) {
        super(name, employeeId);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee type - Part Time employee ");
        System.out.println("Salary - " + calculateSalary());
    }
}

class contractEmployee extends employee {
    int contractAmount;

    public contractEmployee(String name, int employeeId, int contractAmount) {
        super(name, employeeId);
        this.contractAmount = contractAmount;
    }

    public double calculateSalary() {
        return contractAmount;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee type - Contract Employee");
        System.out.println("Salary - " + calculateSalary() + " rs");
    }

}

public class employeeType {
    public static void main(String[] args) {
        HashMap<Integer, employee> employees = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n  ------ Employee Menu ------");
            System.out.println("1. Create employee");
            System.out.println("2. Modify employee");
            System.out.println("3. Delete employee");
            System.out.println("4. List all employees");
            System.out.println("5. Search a employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice - ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter type of employee");
                    System.out.println("1. Permanent employee");
                    System.out.println("2. Part time employee");
                    System.out.println("3. Contract Employee");
                    System.out.print("enter your choice - ");
                    int c = sc.nextInt();
                    sc.nextLine();

                    switch (c) {
                        case 1:
                            System.out.print("Enter name of the employee - ");
                            String perName = sc.nextLine();
                            System.out.print("Enter employee id - ");
                            int perEmployeeId = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter the employee salary - ");
                            double salary = sc.nextDouble();
                            sc.nextLine();
                            employee perEmpoyees = new permanentEmployee(perName, perEmployeeId, salary);
                            employees.put(perEmployeeId, perEmpoyees);
                            break;
                        case 2:
                            System.out.print("Enter name of the employee - ");
                            String ptName = sc.nextLine();
                            System.out.print("Enter employee id - ");
                            int ptEmployeeId = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter the hours worked - ");
                            double hrsWorked = sc.nextDouble();
                            System.out.print("Enter the hourly rate - ");
                            int hrlyRate = sc.nextInt();
                            employee ptEmployee = new parttimeEmployee(ptName, ptEmployeeId, hrsWorked, hrlyRate);
                            employees.put(ptEmployeeId, ptEmployee);
                            break;
                        case 3:
                            System.out.print("Enter name of the employee - ");
                            String ctName = sc.nextLine();
                            System.out.print("Enter employee id - ");
                            int ctEmployeeId = sc.nextInt();
                            System.out.print("Enter the salary of the employee - ");
                            int ctSalary = sc.nextInt();
                            employee ctEmployee = new contractEmployee(ctName, ctEmployeeId, ctSalary);
                            employees.put(ctEmployeeId, ctEmployee);
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;

                case 2:
                    System.out.print("Enter the employee id to modify name - ");
                    int modId = sc.nextInt();
                    sc.nextLine();
                    if (employees.containsKey(modId)) {
                        System.out.print("Enter the new name - ");
                        String modName = sc.nextLine();
                        employee modifiedEmployee = employees.get(modId);
                        modifiedEmployee = new employee(modName, modId);
                        employees.put(modId, modifiedEmployee);
                    } else {
                        System.out.println("Employee with id - " + modId + " not found");
                    }
                    break;
                case 3:
                    System.out.print("\nEnter Employee Id to delete employee - ");
                    int delId = sc.nextInt();
                    sc.nextLine();
                    if (employees.containsKey(delId)) {
                        employees.remove(delId);
                    } else {
                        System.out.println("Employee with Id " + delId + " not found");
                    }
                    break;
                case 4:
                    System.out.println("\nEmployees are listed below - ");
                    for (employee currenntEmployee : employees.values()) {
                        //System.out.println("Employee ID: " + currenntEmployee.getid());
                        //System.out.println("Employee Name: " + currenntEmployee.getName());
                        //System.out.println();
                        currenntEmployee.displayDetails();
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.print("Enter the empolyee id to be searched - ");
                    int empId = sc.nextInt();
                    if (employees.containsKey(empId)) {
                        System.out.println("Employee found ");
                        employee foundEmployee = employees.get(empId);
                        foundEmployee.displayDetails();
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }

        }
    }

}