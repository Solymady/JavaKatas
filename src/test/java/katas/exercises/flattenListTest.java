package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;

public class flattenListTest {

    @Test
    public void testFlattenList_singleLevel() {
        List<Object> nestedList = List.of(1, 2, 3, 4, 5);
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        assertEquals(List.of(1, 2, 3, 4, 5), flatList);
    }

    @Test
    public void testFlattenList_twoLevels() {
        List<Object> nestedList = List.of(1, List.of(2, 3), 4, 5);
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        assertEquals(List.of(1, 2, 3, 4, 5), flatList);
    }

    @Test
    public void testFlattenList_threeLevels() {
        List<Object> nestedList = List.of(1, List.of(2, List.of(3, 4)), 5);
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        assertEquals(List.of(1, 2, 3, 4, 5), flatList);
    }

    @Test
    public void testFlattenList_empty() {
        List<Object> nestedList = List.of();
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        assertEquals(List.of(), flatList);
    }

    @Test
    public void testFlattenList_singleInteger() {
        List<Object> nestedList = List.of(1);
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        assertEquals(List.of(1), flatList);
    }

    @Test
    public void testFlattenList_mixedLevels() {
        List<Object> nestedList = List.of(1, List.of(2, 3), List.of(4, List.of(5, 6)), 7);
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), flatList);
    }
}