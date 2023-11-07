import java.util.HashSet;
import java.util.Scanner;

public class HashClone {
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
        System.out.println("Orginal hashset - "+name);
        HashSet<String> ClonedName = new HashSet<>();
        ClonedName.addAll(name);
        System.out.println("Cloned hashset - "+ClonedName);
        sc.close();
    }
}
