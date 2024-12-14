package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TrueCounterTest {

    @Test
    public void testCountTrueValues() {

        boolean[] array1 = {true, false, true, true, false};
        int result1 = TrueCounter.countTrueValues(array1);
        assertEquals(3, result1);

        boolean[] array2 = {true, true, true, true, true};
        int result2 = TrueCounter.countTrueValues(array2);
        assertEquals(5, result2);

        boolean[] array3 = {false, false, false, false, false};
        int result3 = TrueCounter.countTrueValues(array3);
        assertEquals(0, result3);

        boolean[] array4 = {false, false, true, false, false};
        int result4 = TrueCounter.countTrueValues(array4);
        assertEquals(1, result4);

        boolean[] array5 = {};
        int result5 = TrueCounter.countTrueValues(array5);
        assertEquals(0, result5);
    }
}