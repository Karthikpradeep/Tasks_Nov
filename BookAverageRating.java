
/*Assume you have a CSV file (books.csv) with the following format:

Title,Author,Genre,Rating
The Great Gatsby,F. Scott Fitzgerald,Classic,4.5
To Kill a Mockingbird,Harper Lee,Fiction,4.8

Write a Java program that reads this CSV file, calculates the average rating for each genre, 
and writes the genre names along with their average ratings to another text file (results.txt). */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Book {
    private String genre;
    private double rating;

    public Book(String genre, double rating) {
        this.genre = genre;
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }
}

public class BookAverageRating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the path of the CSV file - ");
        String path = sc.nextLine();
        List<Book> books = new ArrayList<>();

        try (BufferedReader bff = new BufferedReader(new FileReader(path))) {
            String line;
            int lineNum = 0;
            while ((line = bff.readLine()) != null) {
                if (lineNum == 0) {
                    lineNum++;
                    continue;
                }
                String[] data = line.split(",");
                String genre = data[2].trim();
                double rating = Double.parseDouble(data[3].trim());
                books.add(new Book(genre, rating));
            }

            Map<String, Double> averageRatings = books.stream()
                    .collect(Collectors.groupingBy(Book::getGenre, Collectors.averagingDouble(Book::getRating)));
            
            System.out.print("Enter the destination path - ");
            String destinationPath = sc.nextLine();
            
            Set<String> keys =averageRatings.keySet();
            try (BufferedWriter bffWriter = new BufferedWriter(new FileWriter(destinationPath + "resultsBook.txt"))) {
                bffWriter.write("Genre\tAverage Rating\n");
                    for(String key : keys){
                         bffWriter.write(key + "\t" + averageRatings.get(key) + "\n");
                    }
                System.out.println("Results written to resultsBook.txt");
            } catch (IOException e) {
                System.out.println("Error writing to resultsBook.txt: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        finally{
            sc.close();
        }
    }
}
