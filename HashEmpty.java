import java.util.HashSet;
import java.util.Scanner;
public class HashEmpty {
    public static void HashSetEmpty(HashSet<String> name){
        if(name.isEmpty())
        {
            System.out.println("HashSet is empty");
        }
        else
        {
            System.out.println("HashSet values are -"+name);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashSet<String> name = new HashSet<>();
        while(true)
        {
            System.out.print("Enter names to the Set and enter exit to stop- ");
            String str = sc.nextLine();
            if(str.equalsIgnoreCase("exit")){
                break;
            }
            else{
                name.add(str);
            }
        }
        HashSetEmpty(name);
        sc.close();
    }
}
