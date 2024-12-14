package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringDigitSumTest {

    @Test
    public void testSumOfDigits() {
        String input1 = "abc123";
        int result1 = StringDigitSum.sumOfDigits(input1);
        assertEquals(6, result1);

        String input2 = "5 cats and 2 dogs";
        int result2 = StringDigitSum.sumOfDigits(input2);
        assertEquals(7, result2);

        String input3 = "No digits here!";
        int result3 = StringDigitSum.sumOfDigits(input3);
        assertEquals(0, result3);

        String input4 = "abc9xyz";
        int result4 = StringDigitSum.sumOfDigits(input4);
        assertEquals(9, result4);

        String input5 = "1234";
        int result5 = StringDigitSum.sumOfDigits(input5);
        assertEquals(10, result5);

        String input6 = "";
        int result6 = StringDigitSum.sumOfDigits(input6);
        assertEquals(0, result6);

        String input7 = null;
        int result7 = StringDigitSum.sumOfDigits(input7);
        assertEquals(0, result7);
    }
}