package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaxStorageCapacityTest {

    @Test
    void testMaxStorageArea() {
        // Test case 1: General case
        int[] containers1 = {2, 1, 5, 6, 2, 3};
        assertEquals(10, MaxStorageCapacity.maxStorageArea(containers1));
    }
    @Test
    void testMaxStorageArea2() {
        // Test case 2: Single container
        int[] containers2 = {5};
        assertEquals(5, MaxStorageCapacity.maxStorageArea(containers2));
    }
    @Test
    void testMaxStorageArea3() {
        // Test case 3: Uniform height
        int[] containers3 = {3, 3, 3, 3};
        assertEquals(12, MaxStorageCapacity.maxStorageArea(containers3));
    }
    @Test
    void testMaxStorageArea4() {
        // Test case 4: Increasing height
        int[] containers4 = {1, 2, 3, 4, 5};
        assertEquals(9, MaxStorageCapacity.maxStorageArea(containers4));
    }

    @Test
    void testMaxStorageArea5() {
        // Test case 5: Decreasing height
        int[] containers5 = {5, 4, 3, 2, 1};
        assertEquals(9, MaxStorageCapacity.maxStorageArea(containers5));
    }

    @Test
    void testMaxStorageArea6() {
        // Test case 6: Heights with gaps
        int[] containers6 = {2, 1, 5, 6, 2, 3, 1};
        assertEquals(10, MaxStorageCapacity.maxStorageArea(containers6));
    }

    @Test
    void testMaxStorageArea7() {
        // Test case 7: Empty array
        int[] containers7 = {};
        assertEquals(0, MaxStorageCapacity.maxStorageArea(containers7));
    }
    @Test
    void testMaxStorageArea8() {
        // Test case 8: All zeros
        int[] containers8 = {0, 0, 0, 0};
        assertEquals(0, MaxStorageCapacity.maxStorageArea(containers8));
    }
}
