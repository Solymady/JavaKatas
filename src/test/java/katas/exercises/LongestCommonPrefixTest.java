package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {

    @Test
    public void testLongestCommonPrefix_1() {
        String[] input = {"flower", "flow", "flight"};
        String expected = "fl";
        assertEquals(expected, LongestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    public void testLongestCommonPrefix_2() {
        String[] input = {"dog", "racecar", "car"};
        String expected = "";
        assertEquals(expected, LongestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    public void testLongestCommonPrefix_3() {
        String[] input = {"interspecies", "interstellar", "interstate"};
        String expected = "inters";
        assertEquals(expected, LongestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    public void testLongestCommonPrefix_4() {
        String[] input = {"apple", "apricot", "ape"};
        String expected = "ap";
        assertEquals(expected, LongestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    public void testLongestCommonPrefix_EmptyArray() {
        String[] input = {};
        String expected = "";
        assertEquals(expected, LongestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    public void testLongestCommonPrefix_OneString() {
        String[] input = {"apple"};
        String expected = "apple";
        assertEquals(expected, LongestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    public void testLongestCommonPrefix_NoCommonPrefix() {
        String[] input = {"dog", "cat", "fish"};
        String expected = "";
        assertEquals(expected, LongestCommonPrefix.longestCommonPrefix(input));
    }
}
