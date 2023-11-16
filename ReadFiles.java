
//Create a program to read a file using below, BufferReader, BufferInputStream, DataInputStream
import java.io.*;

public class ReadFiles {
    public static void main(String[] args) throws IOException {
        // BufferReader
        System.out.println("\nPrinting using BufferedReader");
        BufferedReader bfReader = new BufferedReader(
                new FileReader("C:\\Users\\Karthik\\Documents\\MSIL\\p4\\FileReading.txt"));
        String str;
        while ((str = bfReader.readLine()) != null) {
            System.out.println(str);
        }
        bfReader.close();

        // BufferInputStream
    
        System.out.println("\nPrinting using BufferedInputStream");
        BufferedInputStream bfin = new BufferedInputStream(
                new FileInputStream("C:\\Users\\Karthik\\Documents\\MSIL\\p4\\FileReading.txt"));
        int i = 0;
        while ((i = bfin.read()) != -1) {
            System.out.print((char) i);
        }
        bfin.close();

        // DataInputStream
        System.out.println();
        System.out.println("\nPrinting using DataInputStream");

        DataInputStream din = new DataInputStream(
                new FileInputStream("C:\\Users\\Karthik\\Documents\\MSIL\\p4\\FileReading.txt"));
        int j = 0;
        while ((j = din.read()) != -1) {
            System.out.print((char) j);
        }
        din.close();
    }
}
