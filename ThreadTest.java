
class multiThreading extends Thread {
    private int start;
    private int end;
    private int threadNumber;

    public multiThreading(int start, int end, int threadNumber) {
        this.start = start;
        this.end = end;
        this.threadNumber = threadNumber;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " is executed by Thread - " + threadNumber);
            if( threadNumber == 1){
                throw new RuntimeException();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        multiThreading t1 = new multiThreading(1, 5, 1);
        multiThreading t2 = new multiThreading(6, 10, 2);
        t1.start();
        t1.join();
        
        t2.start();

    }

}
