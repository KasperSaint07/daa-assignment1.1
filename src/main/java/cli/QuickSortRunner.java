package cli;

import quicksort.QuickSort;
import metrics.Metrics;

import java.io.FileWriter;
import java.io.IOException;

public class QuickSortRunner implements AlgorithmRunner {
    @Override
    public void run(int size, int trials, FileWriter csv) throws IOException {
        for (int t = 1; t <= trials; t++) {
            int[] arr = randomArray(size);
            Metrics m = new Metrics();
            QuickSort.sort(arr, m);
            csv.write(String.format("quicksort,%d,%d,%d,%d,%d,%d\n",
                    size, t, m.getTimeMillis(),
                    m.getComparisons(), m.getOperations(), m.getMaxDepth()));
        }
    }

    private int[] randomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = (int) (Math.random() * 100000);
        return arr;
    }
}
