package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class GraphClonerTest {

    private GraphCloner.Node createTestGraph() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        GraphCloner.Node node2 = new GraphCloner.Node(2);
        GraphCloner.Node node3 = new GraphCloner.Node(3);
        GraphCloner.Node node4 = new GraphCloner.Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);

        return node1;
    }

    @Test
    public void testGraphClone() {
        GraphCloner.Node original = createTestGraph();
        GraphCloner.Node cloned = GraphCloner.cloneGraph(original);

        assertNotNull(cloned, "Cloned graph should not be null");
        assertNotSame(original, cloned, "Cloned graph should be a different instance");

        // Verify structure
        assertEquals(1, cloned.val, "Root node should have same value as original");
        assertEquals(2, cloned.neighbors.get(0).val, "First neighbor should be node 2");
        assertEquals(4, cloned.neighbors.get(1).val, "Second neighbor should be node 4");

        // Ensure deep copy
        assertNotSame(original.neighbors.get(0), cloned.neighbors.get(0), "Nodes should be distinct instances");
        assertNotSame(original.neighbors.get(1), cloned.neighbors.get(1), "Nodes should be distinct instances");
    }

    @Test
    public void testSingleNodeGraph() {
        GraphCloner.Node node = new GraphCloner.Node(1);
        GraphCloner.Node cloned = GraphCloner.cloneGraph(node);
        assertNotNull(cloned);
        assertEquals(1, cloned.val);
        assertNotSame(node, cloned);
        assertTrue(cloned.neighbors.isEmpty(), "Single node should not have neighbors");
    }

    @Test
    public void testEmptyGraph() {
        GraphCloner.Node cloned = GraphCloner.cloneGraph(null);
        assertNull(cloned, "Cloning an empty graph should return null");
    }

    @Test
    public void testGraphWithCycle() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        GraphCloner.Node node2 = new GraphCloner.Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1); // Cycle

        GraphCloner.Node cloned = GraphCloner.cloneGraph(node1);

        assertNotNull(cloned);
        assertNotSame(node1, cloned);
        assertEquals(1, cloned.val);
        assertEquals(1, cloned.neighbors.size());
        assertEquals(2, cloned.neighbors.get(0).val);
        assertEquals(cloned, cloned.neighbors.get(0).neighbors.get(0), "Cloned cycle should be maintained");
    }
}
