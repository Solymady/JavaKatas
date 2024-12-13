package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayDifferenceTest {

    @Test
    public void testFindDifference() {
        // Test case 1: Mixed positive and negative numbers
        int[] array1 = {-10, -3, -5, -6, -20};
        assertEquals(17, ArrayDifference.findDifference(array1));

        // Test case 2: All positive numbers
        int[] array2 = {10, 20, 30, 40};
        assertEquals(30, ArrayDifference.findDifference(array2));

        // Test case 3: All negative numbers
        int[] array3 = {-5, -15, -25, -10};
        assertEquals(20, ArrayDifference.findDifference(array3));

        // Test case 4: Single element array
        int[] array4 = {5};
        assertEquals(0, ArrayDifference.findDifference(array4));

        // Test case 5: All elements are the same
        int[] array5 = {3, 3, 3, 3};
        assertEquals(0, ArrayDifference.findDifference(array5));
    }
}