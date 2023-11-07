import java.util.HashSet;
import java.util.Scanner;
public class HashToArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashSet<String> Movies = new HashSet<>();
        System.out.println("\nEnter some movie name and type exit stop ");
        while(true)
        {
            String str = sc.nextLine();
            if(str.equalsIgnoreCase("exit"))
            {
                break;
            }
            else
            {
                Movies.add(str);
            }
        }
        System.out.println("The entered list is - "+Movies);
        String[] movies = new String[Movies.size()];
        Movies.toArray(movies);
        System.out.println("Array representation is  - ");
        for(int i=0;i<movies.length;i++)
        {
            System.out.println(movies[i] +" ");
        }
        sc.close();
    }
    
}
