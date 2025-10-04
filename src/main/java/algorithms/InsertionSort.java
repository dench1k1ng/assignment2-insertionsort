package algorithms;

import metrics.PerformanceTracker;


public class InsertionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int n = arr.length;
        tracker.incrementArrayAccesses(1);

        for (int i = 1; i < n; i++) {
            int currentElement = arr[i];
            tracker.incrementArrayAccesses(1);

            int j = i - 1;


            while (j >= 0) {
                tracker.incrementComparisons(1);
                tracker.incrementArrayAccesses(1);

                if (arr[j] > currentElement) {
                    arr[j + 1] = arr[j];
                    tracker.incrementArrayAccesses(2);
                    tracker.incrementSwaps(1);
                    j--;
                } else {
                    break;
                }
            }


            arr[j + 1] = currentElement;
            tracker.incrementArrayAccesses(1);
        }
    }
}
