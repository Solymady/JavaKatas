package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UniqueStringTest {

    @Test
    public void test1() {
        assertTrue(UniqueString.isUnique("World"));
    }

    @Test
    public void test2() {
        assertFalse(UniqueString.isUnique("Hello"));
    }

    @Test
    public void test3() {
        assertFalse(UniqueString.isUnique("HHello"));
    }

    @Test
    public void test4() {
        assertTrue(UniqueString.isUnique(""));
    }

    @Test
    public void test5() {
        assertTrue(UniqueString.isUnique("A"));
    }

    @Test
    public void test6() {
        assertTrue(UniqueString.isUnique("AbcD"));
    }
}