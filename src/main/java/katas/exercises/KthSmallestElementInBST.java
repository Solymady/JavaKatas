package katas.exercises;

/**
 * Kth Smallest Element in a Binary Search Tree
 *
 * Given a BST, write a function to find the Kth smallest element.
 *
 * Example:
 *
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *
 * The 3rd smallest element is 4.
 *
 * Expected time complexity is O(n), while n is the tree height.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestElementInBST {

        private static int count = 0;
        private static int result = -1;

        /** Helper function for in-order traversal **/
        private static void inOrder(TreeNode node, int k) {
            if (node == null || count >= k) return;

            // Left subtree (smaller elements)
            inOrder(node.left, k);

            // Process current node
            count++;
            if (count == k) {
                result = node.val;
                return;
            }

            // Right subtree (larger elements)
            inOrder(node.right, k);
        }

        /** Main function to find kth smallest element **/
        public static int kthSmallest(TreeNode root, int k) {
            count = 0;
            result = -1;
            inOrder(root, k);
            return result;
        }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        int k = 3;
        int kthSmallestValue = kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element is: " + kthSmallestValue); // Output: 4
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
