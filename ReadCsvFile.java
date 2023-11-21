import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadCsvFile {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the path of the file - ");
        String path = sc.nextLine();

        try{
            BufferedReader bffRead = new BufferedReader(new FileReader(path));
            
            String line;
            while((line = bffRead.readLine()) != null){
                System.out.println(line);
            }
            bffRead.close();
        }
        
        catch(IOException e){
            System.out.println("File cannot be read");
        }
        sc.close();

    }
}
