package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SemanticVersionComparatorTest {

    @Test
    public void testSemanticVersionComparator1() {
        String input1 = "1.0.0";
        String input2 = "1.0.1";
        int expected = -1;
        assertEquals(expected,SemanticVersionComparator.compareVersions(input1,input2));
    }

    @Test
    public void testSemanticVersionComparator2() {
        String input1 = "0.0.0";
        String input2 = "0.0.1";
        int expected = -1;
        assertEquals(expected,SemanticVersionComparator.compareVersions(input1,input2));
    }

    @Test
    public void testSemanticVersionComparator3() {
        String input1 = "0.0.0";
        String input2 = ".0.0.0";
        int expected = 0;
        assertEquals(expected,SemanticVersionComparator.compareVersions(input1,input2));
    }

    @Test
    public void testSemanticVersionComparator4() {
        String input1 = "";
        String input2 = "";
        int expected = 0;
        assertEquals(expected,SemanticVersionComparator.compareVersions(input1,input2));
    }

    @Test
    public void testSemanticVersionComparator5() {
        String input1 = "0.1.0";
        String input2 = "0.0.1";
        int expected = 1;
        assertEquals(expected,SemanticVersionComparator.compareVersions(input1,input2));
    }
}
