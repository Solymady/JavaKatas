package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianFinderTest {

    @Test
    public void testSingleElement() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(5);
        assertEquals(5.0, medianFinder.findMedian(), "Median of [5] should be 5.0");
    }

    @Test
    public void testEvenNumberOfElements() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian(), "Median of [1,2] should be 1.5");

        medianFinder.addNum(3);
        medianFinder.addNum(4);
        assertEquals(2.5, medianFinder.findMedian(), "Median of [1,2,3,4] should be 2.5");
    }

    @Test
    public void testOddNumberOfElements() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian(), "Median of [1,2,3] should be 2.0");

        medianFinder.addNum(4);
        medianFinder.addNum(5);
        assertEquals(3.0, medianFinder.findMedian(), "Median of [1,2,3,4,5] should be 3.0");
    }

    @Test
    public void testNegativeNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-3);
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        assertEquals(-2.0, medianFinder.findMedian(), "Median of [-3,-1,-2] should be -2.0");
    }

    @Test
    public void testUnsortedInput() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(5);
        medianFinder.addNum(3);
        medianFinder.addNum(8);
        medianFinder.addNum(2);
        medianFinder.addNum(7);
        assertEquals(5.0, medianFinder.findMedian(), "Median of [5,3,8,2,7] should be 5.0");
    }

    @Test
    public void testPerformanceWithLargeInput() {
        MedianFinder medianFinder = new MedianFinder();
        for (int i = 1; i <= 1000; i++) {
            medianFinder.addNum(i);
        }
        assertEquals(500.5, medianFinder.findMedian(), "Median of 1 to 1000 should be 500.5");
    }

    @Test
    public void testAlternatingPushes() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(10);
        assertEquals(10.0, medianFinder.findMedian(), "Median should be 10");

        medianFinder.addNum(20);
        assertEquals(15.0, medianFinder.findMedian(), "Median should be 15");

        medianFinder.addNum(30);
        assertEquals(20.0, medianFinder.findMedian(), "Median should be 20");

        medianFinder.addNum(40);
        assertEquals(25.0, medianFinder.findMedian(), "Median should be 25");

        medianFinder.addNum(50);
        assertEquals(30.0, medianFinder.findMedian(), "Median should be 30");
    }
}
