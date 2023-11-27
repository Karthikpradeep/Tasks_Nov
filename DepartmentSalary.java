import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
class Department{
    private String department;
    private int salary;

    public Department(String department,int salary){
        this.department = department;
        this.salary = salary;
    }
    public String getDepartment(){
        return department;
    }
    public int getSalary(){
        return salary;
    }
}
public class DepartmentSalary {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the path of the source file - ");
        String sourcePath = sc.nextLine();
        List<Department> departments = new ArrayList<>();
        try(BufferedReader read = new BufferedReader(new FileReader(sourcePath))){
                String line;
                int lineNumber =0;
                while((line =read.readLine())!= null){
                    if(lineNumber == 0)
                    {
                        lineNumber++;
                        continue;
                    }
                    String[] values = line.split(",");
                    String department = values[1].trim();
                    int salary = Integer.parseInt(values[2].trim());
                    departments.add(new Department(department, salary));
                }

                // calculating average salary
                Map<String, Double> averageSalary = departments.stream()
                            .collect(Collectors.groupingBy(Department::getDepartment,Collectors.averagingDouble(Department::getSalary)));
                
                Set<String> keys = averageSalary.keySet();
                System.out.print("Enter the destination path - ");
                String destinationPath = sc.nextLine();
                try(BufferedWriter writer =new BufferedWriter(new FileWriter(destinationPath))){
                    writer.write("Department\tAverage Salary \n");
                    for(String key : keys )
                    {
                        writer.write(key+"\t"+averageSalary.get(key)+"\n");
                    }
                    System.out.println("Result written to destination ");
                }
                catch(IOException e){
                    System.err.println("!!! Error while writing to destination file !!!");
                }
        }       
        catch(IOException e){
            System.err.println("!!! Error while reading the file !!!");
        }
        catch(Exception e){
            System.err.println("!!! Unknown Error !!!");
        }
        finally{
            sc.close();
        }
    }
}
