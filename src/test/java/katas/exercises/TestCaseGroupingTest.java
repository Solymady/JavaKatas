package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCaseGroupingTest {

    @Test
    void testGroupTestCasesExample1() {
        List<Integer> testCaseGroupSizes = List.of(1, 2, 3, 3, 3, 2);
        List<List<Integer>> expected = Arrays.asList(
                List.of(0),
                List.of(2, 3, 4),
                List.of(1, 5)
        );

        assertEquals(expected, TestCaseGrouping.groupTestCases(testCaseGroupSizes));
    }

    @Test
    void testGroupTestCasesExample2() {
        List<Integer> testCaseGroupSizes = List.of(2, 1, 2, 3, 3, 3);
        List<List<Integer>> expected = Arrays.asList(
                List.of(1),
                List.of(0, 2),
                List.of(3, 4, 5)
        );

        assertEquals(expected, TestCaseGrouping.groupTestCases(testCaseGroupSizes));
    }

    @Test
    void testGroupTestCasesSingleGroup() {
        List<Integer> testCaseGroupSizes = List.of(4, 4, 4, 4);
        List<List<Integer>> expected = Arrays.asList(
                List.of(0, 1, 2, 3)
        );

        assertEquals(expected, TestCaseGrouping.groupTestCases(testCaseGroupSizes));
    }

    @Test
    void testGroupTestCasesAllSingleGroups() {
        List<Integer> testCaseGroupSizes = List.of(1, 1, 1, 1);
        List<List<Integer>> expected = Arrays.asList(
                List.of(0),
                List.of(1),
                List.of(2),
                List.of(3)
        );

        assertEquals(expected, TestCaseGrouping.groupTestCases(testCaseGroupSizes));
    }

    @Test
    void testGroupTestCasesEmptyList() {
        List<Integer> testCaseGroupSizes = List.of();
        List<List<Integer>> expected = List.of();

        assertEquals(expected, TestCaseGrouping.groupTestCases(testCaseGroupSizes));
    }
}
