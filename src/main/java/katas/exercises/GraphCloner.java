package katas.exercises;

import java.util.*;

class GraphCloner {
    /**
     * Clones a directed graph using BFS.
     *
     * @param node the starting node of the graph to clone
     * @return the starting node of the cloned graph
     */
    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        // Map to track cloned nodes
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        // Clone the first node
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                // If the neighbor hasn't been cloned, clone and queue it
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                // Connect cloned node to cloned neighbor
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);

        System.out.println("Original graph:");
        printGraph(node1, new HashSet<>());

        Node clonedNode = cloneGraph(node1);

        System.out.println("\nCloned graph:");
        printGraph(clonedNode, new HashSet<>());
    }

    /** Helper function to print the graph */
    public static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        System.out.println("Node " + node.val + " -> " + node.neighbors.stream().map(n -> n.val).toList());
        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }

    /** Node class */
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", neighbors=" + neighbors.size() + '}';
        }
    }
}
