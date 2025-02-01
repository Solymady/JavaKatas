package katas.exercises;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> left;  // Max-Heap
    private PriorityQueue<Integer> right; // Min-Heap

    /** Initializes the MedianFinder object. */
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder()); // Max-Heap
        right = new PriorityQueue<>(); // Min-Heap (default)
    }

    /** Adds a number to the data stream. */
    public void addNum(int num) {
        // Step 1: Insert into the correct heap
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        // Step 2: Balance the heaps
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());  // Move element from left → right
        } else if (right.size() > left.size()) {
            left.offer(right.poll());  // Move element from right → left
        }
    }

    /** Finds and returns the median of the data stream. */
    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();  // Odd count, return middle element
        } else {
            return (left.peek() + right.peek()) / 2.0; // Even count, return avg of two middles
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(5);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(4);
        System.out.println("Median: " + medianFinder.findMedian());
    }
}
