package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class BenchmarkRunner {

    private static final PerformanceTracker tracker = new PerformanceTracker();

    public static void main(String[] args) {
        System.out.println("--- Algorithmic Analysis: Insertion Sort Benchmark ---");

        // Required input sizes for Empirical Validation
        int[] inputSizes = {100, 1000, 10000, 100000};

        for (int size : inputSizes) {
            System.out.printf("%nRunning benchmarks for N = %d%n", size);

            runTest("Random Data (Avg Case)", generateRandomArray(size));

            runTest("Sorted Data (Best Case)", generateSortedArray(size));

            runTest("Reverse-Sorted Data (Worst Case)", generateReverseSortedArray(size));

            runTest("Nearly-Sorted Data (Optimized Case)", generateNearlySortedArray(size, 0.01));
        }
    }


    private static void runTest(String testName, int[] originalArray) {
        int[] array = Arrays.copyOf(originalArray, originalArray.length); // Copy to preserve original
        tracker.reset();

        long startTime = System.nanoTime();
        InsertionSort.sort(array, tracker);
        long endTime = System.nanoTime();

        long durationNs = endTime - startTime;
        long durationMs = TimeUnit.NANOSECONDS.toMillis(durationNs);

        System.out.printf("  - %s (Time: %d ms, %d ns):%n", testName, durationMs, durationNs);
        System.out.printf("    | Comparisons: %d | Swaps/Shifts: %d | Array Accesses: %d%n",
                tracker.getComparisons(), tracker.getSwaps(), tracker.getArrayAccesses());

        // Basic check for correctness (can be expanded)
        if (!isSorted(array)) {
            System.err.println("    | ERROR: Array is not sorted correctly!");
        }
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }

    private static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }


    private static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }


    private static int[] generateNearlySortedArray(int size, double swapPercentage) {
        int[] arr = generateSortedArray(size);
        Random rand = new Random();
        int swapsCount = (int) (size * swapPercentage);

        for (int i = 0; i < swapsCount; i++) {
            int idx1 = rand.nextInt(size);
            int idx2 = rand.nextInt(size);
            // Swap elements
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        return arr;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
