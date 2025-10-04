package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class InsertionSortTest {

    // A dummy tracker for unit tests, as we primarily test correctness here
    private final PerformanceTracker dummyTracker = new PerformanceTracker();

    @Test
    void testEmptyArray() {
        int[] arr = {};
        InsertionSort.sort(arr, dummyTracker);
        assertArrayEquals(new int[]{}, arr, "Empty array should remain empty.");
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {5};
        InsertionSort.sort(arr, dummyTracker);
        assertArrayEquals(new int[]{5}, arr, "Single element array should remain unchanged.");
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSort.sort(arr, dummyTracker);
        assertArrayEquals(expected, arr, "Sorted array should remain sorted.");
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSort.sort(arr, dummyTracker);
        assertArrayEquals(expected, arr, "Reverse-sorted array should be correctly sorted.");
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {5, 1, 5, 2, 1, 4};
        int[] expected = {1, 1, 2, 4, 5, 5};
        InsertionSort.sort(arr, dummyTracker);
        assertArrayEquals(expected, arr, "Array with duplicates should be correctly sorted.");
    }

    @Test
    void testArrayWithNegatives() {
        int[] arr = {-5, 0, 3, -1, 2};
        int[] expected = {-5, -1, 0, 2, 3};
        InsertionSort.sort(arr, dummyTracker);
        assertArrayEquals(expected, arr, "Array with negative numbers should be correctly sorted.");
    }

    @Test
    void testLargerUnsortedArray() {
        int[] arr = {10, 8, 2, 4, 6, 1, 9, 3, 7, 5};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        InsertionSort.sort(arr, dummyTracker);
        assertArrayEquals(expected, arr, "Larger unsorted array should be correctly sorted.");
    }

    @Test
    void testNullArray() {
        try {
            InsertionSort.sort(null, dummyTracker);
            // If no exception is thrown, the method handled null gracefully (which it should)
        } catch (Exception e) {
            fail("InsertionSort should handle a null array gracefully without throwing an exception.");
        }
    }
}
