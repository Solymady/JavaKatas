package katas.exercises;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


public class RequirementsCoverageTest {


    @Test
    public void testSelectMinimalTestCases_SimpleCase() {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3),
                List.of(1, 4),
                List.of(2, 3, 4),
                List.of(1, 5),
                List.of(3, 5)
        );

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(2, 3), result, "Minimal set of test cases should be [2, 3]");
    }

    @Test
    public void testSelectMinimalTestCases_ExactMatch() {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(1, 4),
                List.of(2, 3)
        );

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(0, 1), result, "Minimal set of test cases should be [0, 1]");
    }

    @Test
    public void testSelectMinimalTestCases_AllRequirementsCoveredByOneTestCase() {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(1),
                List.of(2, 3),
                List.of(4, 5)
        );

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(0), result, "Minimal set of test cases should be [0]");
    }

    @Test
    public void testSelectMinimalTestCases_DisjointRequirements() {
        List<List<Integer>> testCases = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(4),
                List.of(5)
        );

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(0, 1, 2, 3, 4), result, "Minimal set of test cases should cover all requirements individually");
    }

    @Test
    public void testSelectMinimalTestCases_EmptyTestCases() {
        List<List<Integer>> testCases = List.of();

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(), result, "No test cases should return an empty result");
    }

    @Test
    public void testSelectMinimalTestCases_NoRequirements() {
        List<List<Integer>> testCases = List.of(
                List.of(),
                List.of(),
                List.of()
        );

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(), result, "No requirements should return an empty result");
    }
}
