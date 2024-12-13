package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayReducerTest {

    @Test
    public void testReduceArray() {

        int[] numbers1 = {10, 15, 7, 20, 25};
        int[] expected1 = {10, 25, 32, 52, 77};
        ArrayReducer.reduceArray(numbers1);
        assertArrayEquals(expected1, numbers1);


        int[] numbers2 = {5};
        int[] expected2 = {5};
        ArrayReducer.reduceArray(numbers2);
        assertArrayEquals(expected2, numbers2);

        int[] numbers3 = {0, 0, 0, 0, 0};
        int[] expected3 = {0, 0, 0, 0, 0};
        ArrayReducer.reduceArray(numbers3);
        assertArrayEquals(expected3, numbers3);

        int[] numbers4 = {-10, -20, -30, -40};
        int[] expected4 = {-10, -30, -60, -100};
        ArrayReducer.reduceArray(numbers4);
        assertArrayEquals(expected4, numbers4);

        int[] numbers5 = {5, -3, 8, -2};
        int[] expected5 = {5, 2, 10, 8};
        ArrayReducer.reduceArray(numbers5);
        assertArrayEquals(expected5, numbers5);
    }
}