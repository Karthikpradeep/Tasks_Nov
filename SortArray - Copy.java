import java.util.Arrays;

class FirstHalf extends Thread {
    private int[] arr1;

    public FirstHalf(int[] arr1) {
        this.arr1 = arr1;
    }

    public void run() {
        Arrays.sort(arr1);
    }
}

class SecondHalf extends Thread {
    private int[] arr2;

    public SecondHalf(int[] arr2) {
        this.arr2 = arr2;
    }

    public void run() {
        Arrays.sort(arr2);
    }
}

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {23, 15, 100, 1, 14, 6, 99, 43};
        int[] arr1 = new int[arr.length / 2];
        int[] arr2 = new int[arr.length / 2];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[arr1.length + i];
        }

        FirstHalf thread1 = new FirstHalf(arr1);
        SecondHalf thread2 = new SecondHalf(arr2);

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Merge the sorted halves
        int[] sortedArray = mergeArrays(arr1, arr2);

        // Print the sorted array
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            mergedArray[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }
}
