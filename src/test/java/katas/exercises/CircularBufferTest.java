package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularBufferTest {

    private CircularBuffer buffer;

    @BeforeEach
    void setUp() {
        buffer = new CircularBuffer(3);
    }

    @Test
    void testAddAndGet() {
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        assertEquals(1, buffer.get());
        assertEquals(2, buffer.get());
        assertEquals(3, buffer.get());
    }

    @Test
    void testOverwriteWhenFull() {
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.add(4); // Overwrites the oldest element (1)

        assertEquals(2, buffer.get());
        assertEquals(3, buffer.get());
        assertEquals(4, buffer.get());
    }

    @Test
    void testIsFull() {
        assertFalse(buffer.isFull());

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        assertTrue(buffer.isFull());
    }

    @Test
    void testIsEmpty() {
        assertTrue(buffer.isEmpty());

        buffer.add(1);

        assertFalse(buffer.isEmpty());
    }

    @Test
    void testGetFromEmptyBuffer() {
        assertEquals(-1, buffer.get());
    }

    @Test
    void testCircularBehavior() {
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.get(); // Remove the oldest (1)
        buffer.add(4); // Add a new element

        assertEquals(2, buffer.get());
        assertEquals(3, buffer.get());
        assertEquals(4, buffer.get());
    }
}
