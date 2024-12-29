package katas.exercises;

import java.util.*;

public class ValidGitTree {

    /**
     * Determines if a given tree structure represents a valid Git tree.
     *
     * A valid Git tree should:
     * 1. Have exactly one root (no parent).
     * 2. Contain no cycles.
     *
     * @param treeMap a map representing the Git tree (commit ID to list of child commit IDs)
     * @return true if the tree is a valid Git tree, false otherwise
     */
    public static boolean isValidGitTree(Map<String, List<String>> treeMap) {
        if (treeMap == null || treeMap.isEmpty()) {
            return false;
        }

        // Step 1: Find all nodes and their parents
        Set<String> allNodes = new HashSet<>();
        Map<String, String> parents = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : treeMap.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();

            allNodes.add(parent);
            for (String child : children) {
                if (parents.containsKey(child)) {
                    // A node has more than one parent (not a valid tree)
                    return false;
                }
                parents.put(child, parent);
                allNodes.add(child);
            }
        }

        // Step 2: Identify the root (node with no parent)
        String root = null;
        for (String node : allNodes) {
            if (!parents.containsKey(node)) {
                if (root != null) {
                    // More than one root found
                    return false;
                }
                root = node;
            }
        }

        if (root == null) {
            // No root found
            return false;
        }

        // Step 3: Check for cycles using DFS
        Set<String> visited = new HashSet<>();
        return !hasCycle(root, treeMap, visited, new HashSet<>());
    }

    private static boolean hasCycle(String node, Map<String, List<String>> treeMap, Set<String> visited, Set<String> currentStack) {
        if (currentStack.contains(node)) {
            // Cycle detected
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        currentStack.add(node);

        List<String> children = treeMap.getOrDefault(node, List.of());
        for (String child : children) {
            if (hasCycle(child, treeMap, visited, currentStack)) {
                return true;
            }
        }

        currentStack.remove(node);
        return false;
    }

    public static void main(String[] args) {
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A")); // cycle

        Map<String, List<String>> multipleRoots = new HashMap<>();
        multipleRoots.put("A", List.of("B"));
        multipleRoots.put("C", List.of("D"));

        System.out.println("Is valid tree: " + isValidGitTree(validTree)); // Expected: true
        System.out.println("Is valid tree: " + isValidGitTree(invalidTree)); // Expected: false
        System.out.println("Is valid tree: " + isValidGitTree(multipleRoots)); // Expected: false
    }
}
