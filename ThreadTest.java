
class multiThreading implements Runnable {
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
            if (threadNumber == 2) {
                throw new RuntimeException();
            }
            System.out.println(i + " is executed by Thread - " + threadNumber);
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
        multiThreading t3 = new multiThreading(11, 15, 3);
        Thread myThread1 = new Thread(t1);
        Thread myThread2 = new Thread(t2);
        Thread myThread3 = new Thread(t3);

        myThread1.start();
        myThread1.join();
        myThread2.start();
        myThread2.join();
        myThread3.start();
    }

}
