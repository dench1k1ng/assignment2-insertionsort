package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0; // Read or Write operation

    public void incrementComparisons(int count) {
        this.comparisons += count;
    }

    public void incrementSwaps(int count) {
        this.swaps += count;
    }

    // A typical array element read or write is an access.
    // E.g., arr[j] < currentElement is 1 access (read) + 1 comparison (incrementComparisons).
    // E.g., arr[j+1] = arr[j] is 2 accesses (read + write).
    public void incrementArrayAccesses(int count) {
        this.arrayAccesses += count;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
    }

    // Getter methods
    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getArrayAccesses() {
        return arrayAccesses;
    }

    /**
     * Prints the collected metrics in a readable format.
     */
    public void printMetrics() {
        System.out.println("--- Performance Metrics ---");
        System.out.printf("Comparisons: %d%n", comparisons);
        System.out.printf("Swaps/Shifts: %d%n", swaps);
        System.out.printf("Array Accesses: %d%n", arrayAccesses);
        System.out.println("---------------------------");
    }
}