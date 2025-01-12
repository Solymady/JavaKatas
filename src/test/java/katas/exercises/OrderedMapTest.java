package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrderedMapTest {

    private OrderedMap<String, Integer> orderedMap;

    @BeforeEach
    void setUp() {
        orderedMap = new OrderedMap<>();
    }

    @Test
    void testPutAndGet() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        assertEquals(1, orderedMap.get("One"));
        assertEquals(2, orderedMap.get("Two"));
        assertEquals(3, orderedMap.get("Three"));
    }

    @Test
    void testUpdateValue() {
        orderedMap.put("One", 1);
        orderedMap.put("One", 10); // Update the value

        assertEquals(10, orderedMap.get("One"));
        assertEquals(1, orderedMap.size());
    }

    @Test
    void testKeysOrder() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        List<String> keys = orderedMap.keys();
        assertEquals(List.of("One", "Two", "Three"), keys);
    }

    @Test
    void testRemove() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        orderedMap.remove("Two");

        List<String> keys = orderedMap.keys();
        assertEquals(List.of("One", "Three"), keys);
        assertNull(orderedMap.get("Two"));
    }

    @Test
    void testSize() {
        assertEquals(0, orderedMap.size());

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);

        assertEquals(2, orderedMap.size());

        orderedMap.remove("One");
        assertEquals(1, orderedMap.size());
    }

    @Test
    void testClear() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);

        orderedMap.clear();

        assertEquals(0, orderedMap.size());
        assertTrue(orderedMap.keys().isEmpty());
    }

    @Test
    void testOrderAfterRemovalAndReAddition() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        orderedMap.remove("Two");
        orderedMap.put("Two", 22); // Re-add "Two" with a new value

        List<String> keys = orderedMap.keys();
        assertEquals(List.of("One", "Three", "Two"), keys);
    }
}
