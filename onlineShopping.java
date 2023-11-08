package p4;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }
}

class EmptyCartException extends RuntimeException {
    public EmptyCartException(String message) {
        super(message);
    }
}

class shoppingCart {
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> availableItems = new ArrayList<>();

    public shoppingCart() {
        availableItems.add("apple");
        availableItems.add("orange");
        availableItems.add("grapes");
        availableItems.add("banana");
        availableItems.add("papaya");
        availableItems.add("guava");
    }

    public void addItem(String item) {
        if (!availableItems.contains(item)) {
            throw new OutOfStockException(item + " is out of stock");
        } else {
            items.add(item);
        }
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void checkOut() {
        if (items.isEmpty()) {
            throw new EmptyCartException("Cart is empty");
        } else {
            System.out.println("Check out completed");
            System.out.println(" Your items are - " + items);
        }
    }

}

public class onlineShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        shoppingCart cart = new shoppingCart();
        try {
            while (true) {
                System.out.println("----Menu----");
                System.out.println("1. Add item");
                System.out.println("2. Remove item");
                System.out.println("3. Checkout");
                System.out.print("Enter your choice - ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter the items to the cart - ");
                        String item = sc.nextLine();
                        if (item.equalsIgnoreCase("exit")) {
                            break;
                        } else {
                            cart.addItem(item.toLowerCase());
                        }
                        break;
                    case 2:
                        System.out.print("Enter the item to be removed from the cart - ");
                        String rmvitem = sc.nextLine();
                        if (cart.items.contains(rmvitem)) {
                            cart.removeItem(rmvitem);
                        }
                        break;
                    case 3:
                        System.out.println("Checking out");
                        cart.checkOut();
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Invalid choice");

                }

            }
        } catch (OutOfStockException e) {
            System.err.println("!!! Error !!!" + e.getMessage());
        } catch (EmptyCartException e) {
            System.err.println("!!! Error !!!" + e.getMessage());
        }
        catch(InputMismatchException e){
            System.err.println("Invalid input");
        }
        finally{
            sc.close();
        }

    }
}
