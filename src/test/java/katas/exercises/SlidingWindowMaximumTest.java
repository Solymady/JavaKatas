package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SlidingWindowMaximumTest {

    @Test
    public void testBasicFunctionality() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> result = SlidingWindowMaximum.maxSlidingWindow(nums, k);
        List<Integer> expected = List.of(3, 3, 5, 5, 6, 7);
        assertEquals(expected, result);
    }

    @Test
    public void testSingleElementArray() {
        int[] nums = {5};
        int k = 1;
        List<Integer> result = SlidingWindowMaximum.maxSlidingWindow(nums, k);
        List<Integer> expected = List.of(5);
        assertEquals(expected, result);
    }

    @Test
    public void testWindowSizeEqualToArraySize() {
        int[] nums = {4, 2, 7, 3, 1};
        int k = 5;
        List<Integer> result = SlidingWindowMaximum.maxSlidingWindow(nums, k);
        List<Integer> expected = List.of(7);
        assertEquals(expected, result);
    }

    @Test
    public void testAllNegativeNumbers() {
        int[] nums = {-2, -3, -5, -1};
        int k = 2;
        List<Integer> result = SlidingWindowMaximum.maxSlidingWindow(nums, k);
        List<Integer> expected = List.of(-2, -3, -1);
        assertEquals(expected, result);
    }

    @Test
    public void testWindowSizeOne() {
        int[] nums = {1, 3, 2, 5};
        int k = 1;
        List<Integer> result = SlidingWindowMaximum.maxSlidingWindow(nums, k);
        List<Integer> expected = List.of(1, 3, 2, 5);
        assertEquals(expected, result);
    }

    @Test
    public void testIdenticalElements() {
        int[] nums = {5, 5, 5, 5};
        int k = 2;
        List<Integer> result = SlidingWindowMaximum.maxSlidingWindow(nums, k);
        List<Integer> expected = List.of(5, 5, 5);
        assertEquals(expected, result);
    }

    @Test
    public void testArrayWithGaps() {
        int[] nums = {1, 100, 1, 100, 1};
        int k = 3;
        List<Integer> result = SlidingWindowMaximum.maxSlidingWindow(nums, k);
        List<Integer> expected = List.of(100, 100, 100);
        assertEquals(expected, result);
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int k = 3;
        List<Integer> result = SlidingWindowMaximum.maxSlidingWindow(nums, k);
        List<Integer> expected = List.of();
        assertEquals(expected, result);
    }

    @Test
    public void testLargeArray() {
        int[] nums = {1, 3, 5, 2, 8, 6, 7, 4, 2};
        int k = 4;
        List<Integer> result = SlidingWindowMaximum.maxSlidingWindow(nums, k);
        List<Integer> expected = List.of(5, 8, 8, 8, 8, 7);
        assertEquals(expected, result);
    }

}
