package katas.exercises;

import java.util.Arrays;

public class ArrayDifference {

    /**
     * Finds the difference between the largest and smallest numbers in the array.
     *
     * @param numbers the array of integers
     * @return the difference between the largest and smallest numbers
     */
    public static int findDifference(int[] numbers) {

        int larget =Arrays.stream(numbers).max().getAsInt();
        int smallest = Arrays.stream(numbers).min().getAsInt();
        int difference  = larget - smallest;

        return difference;
    }

    public static void main(String[] args) {
        int[] sampleArray = {10, 3, 5, 6, 20, -2};
        int difference = findDifference(sampleArray);

        System.out.println(difference);
    }
}
