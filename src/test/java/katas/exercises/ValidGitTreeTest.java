package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ValidGitTreeTest {

    @Test
    void testValidTree() {
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        assertTrue(ValidGitTree.isValidGitTree(validTree), "The tree should be valid");
    }

    @Test
    void testTreeWithCycle() {
        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A")); // cycle

        assertFalse(ValidGitTree.isValidGitTree(invalidTree), "The tree should be invalid due to a cycle");
    }

    @Test
    void testTreeWithMultipleRoots() {
        Map<String, List<String>> multipleRoots = new HashMap<>();
        multipleRoots.put("A", List.of("B"));
        multipleRoots.put("C", List.of("D"));

        assertFalse(ValidGitTree.isValidGitTree(multipleRoots), "The tree should be invalid due to multiple roots");
    }

    @Test
    void testTreeWithNoRoot() {
        Map<String, List<String>> noRootTree = new HashMap<>();
        noRootTree.put("A", List.of("B"));
        noRootTree.put("B", List.of("C"));
        noRootTree.put("C", List.of());
        noRootTree.put("D", List.of("E"));
        noRootTree.put("E", List.of());

        assertFalse(ValidGitTree.isValidGitTree(noRootTree), "The tree should be invalid due to disconnected nodes with no root");
    }

    @Test
    void testEmptyTree() {
        Map<String, List<String>> emptyTree = new HashMap<>();

        assertFalse(ValidGitTree.isValidGitTree(emptyTree), "The tree should be invalid because it's empty");
    }

    @Test
    void testTreeWithSingleNode() {
        Map<String, List<String>> singleNodeTree = new HashMap<>();
        singleNodeTree.put("A", List.of());

        assertTrue(ValidGitTree.isValidGitTree(singleNodeTree), "The tree should be valid with a single node");
    }

    @Test
    void testTreeWithDisconnectedComponents() {
        Map<String, List<String>> disconnectedTree = new HashMap<>();
        disconnectedTree.put("A", List.of("B"));
        disconnectedTree.put("C", List.of());

        assertFalse(ValidGitTree.isValidGitTree(disconnectedTree), "The tree should be invalid due to disconnected components");
    }
}
