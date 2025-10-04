Assignment 2: Insertion Sort Implementation

This repository contains the implementation of the Insertion Sort algorithm, optimized for nearly-sorted data (which is the inherent best-case efficiency of Insertion Sort: Θ(N)).

This implementation focuses on:

    Correctness: Full unit test coverage for edge cases.

    Efficiency: Implementation of the O(N) best-case.

    Metrics Tracking: Comprehensive logging of comparisons, shifts/swaps, and array accesses via PerformanceTracker.java.

Project Structure

assignment2-insertionsort/
├── src/main/java/
│ ├── algorithms/InsertionSort.java        <- The core algorithm (Student A's implementation)
│ ├── metrics/PerformanceTracker.java      <- Metric recording utility
│ └── cli/BenchmarkRunner.java             <- CLI for running empirical tests
├── src/test/java/
│ └── algorithms/InsertionSortTest.java    <- Unit tests for correctness
├── README.md                              <- This file
└── pom.xml                                <- Maven configuration

Execution Instructions

To run the project, ensure you have Java 11+ and Maven installed, and navigate to the project root directory (assignment2-insertionsort/).
1. Running Unit Tests (Correctness Validation)

Use this command to execute the JUnit tests (InsertionSortTest.java) to verify the sorting algorithm's logic across all required edge cases (empty, single-element, sorted, and reversed arrays).

**mvn test**

2. Running Benchmarks (Empirical Validation)

The BenchmarkRunner provides a CLI to test the algorithm on required input sizes (N=102 to 105) and different distributions (Random, Sorted, Reverse-Sorted, Nearly-Sorted).

This output will provide the timing and operational metrics necessary for the Empirical Validation section of your report.

**mvn clean compile exec:java -Dexec.mainClass="cli.BenchmarkRunner"**

equirements, you should use the following feature branches