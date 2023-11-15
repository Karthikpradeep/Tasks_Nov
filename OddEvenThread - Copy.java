//Write a Java program that creates two threads to find and print even and odd numbers from 1 to 20.
class oddThread extends Thread {
    String name;

    public oddThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            if (i % 2 == 1) {
                System.out.println(i + " is Odd and executed by - " + name);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}

class evenThread extends Thread {
    String name;

    public evenThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            if (i % 2 == 0) {
                System.out.println(i + " is even and executed by - " + name);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }
}

public class OddEvenThread {
    public static void main(String[] args) throws InterruptedException {
        oddThread thread1 = new oddThread("oddThread");
        evenThread thread2 = new evenThread("evenThread");
        thread1.start();
        thread1.join();
        thread2.start();
    }
}