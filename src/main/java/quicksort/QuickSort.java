package quicksort;

import metrics.Metrics;
import java.util.Random;

public class QuickSort {

    private static final Random rand = new Random();

    public static void sort(int[] arr, Metrics metrics) {
        metrics.start();
        quickSort(arr, 0, arr.length - 1, metrics);
        metrics.stop();
    }

    private static void quickSort(int[] arr, int left, int right, Metrics metrics) {
        metrics.enterRecursion();

        while (left < right) {
            int pivotIndex = partition(arr, left, right, metrics);


            if (pivotIndex - left < right - pivotIndex) {
                quickSort(arr, left, pivotIndex - 1, metrics);
                left = pivotIndex + 1;
            } else {
                quickSort(arr, pivotIndex + 1, right, metrics);
                right = pivotIndex - 1;
            }
        }

        metrics.exitRecursion();
    }


    // Hoare partition
    private static int partition(int[] arr, int left, int right, Metrics metrics) {
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right, metrics);

        int i = left;
        for (int j = left; j < right; j++) {
            metrics.inComparisons();
            if (arr[j] <= pivot) {
                swap(arr, i, j, metrics);
                i++;
            }
        }
        swap(arr, i, right, metrics);
        return i;
    }


    private static void swap(int[] arr, int i, int j, Metrics metrics) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        metrics.inOperations();
    }
}
