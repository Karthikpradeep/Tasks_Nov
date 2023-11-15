
//Create a new text file and write data to it. Read the contents of the file. Append additional data to the file. 
// Display the modified file contents. Rename the file. Delete the file.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteExample {
    public static void main(String[] args) throws IOException {
        String[] names = { "Arun", "Manu", "Peter" };
        // writing into a file
        BufferedWriter writer = new BufferedWriter(
                new FileWriter("C:\\Users\\Karthik\\Documents\\MSIL\\p4\\Sample.txt"));
        writer.write("This is a trial program");
        for (String name : names) {
            writer.write("\n" + name);
        }
        writer.close();
        // Reading a file
        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\Karthik\\Documents\\MSIL\\p4\\Sample.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
        // Append
        BufferedWriter appendWriter = new BufferedWriter(
                new FileWriter("C:\\Users\\Karthik\\Documents\\MSIL\\p4\\Sample.txt", true));
        appendWriter.write("\n This is a appended text");
        appendWriter.close();
        // Renaming a file
        File oldFile = new File("C:\\Users\\Karthik\\Documents\\MSIL\\p4\\Sample.txt");
        File newFile = new File("C:\\Users\\Karthik\\Documents\\MSIL\\p4\\RenamedFile.txt");
        if (oldFile.exists()) {
            oldFile.renameTo(newFile);
            System.out.println("File renamed");
        } 

        // delete a file
        // File deleteFile = new
        // File("C:\\Users\\Karthik\\Documents\\MSIL\\p4\\RenamedFile.txt");
        // if (deleteFile.delete()) {
        // System.out.println("File deleted");
        // } else {
        // System.out.println("File not deleted");
        // }
    }

}
