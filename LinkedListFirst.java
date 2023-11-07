import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListFirst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> L1 = new LinkedList<>();
        System.out.print("Enter the number of elements to be entered to list - ");
        int num = sc.nextInt();
        System.out.println("Enter the elements to the list - ");
        for (int i = 0; i < num; i++) {
            L1.add(sc.nextInt());
        }
        System.out.println("List elements are " + L1);
        Integer FirstElement = L1.poll();
        if( FirstElement != null)
        {
            System.out.print("First element - "+FirstElement);
        }
        else{
            System.out.println("Empty List");
        }
        System.out.println("\nList after removing first element - "+L1);
        sc.close();
        
    }
}
