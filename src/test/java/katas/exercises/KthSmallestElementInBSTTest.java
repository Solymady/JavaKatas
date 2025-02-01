package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KthSmallestElementInBSTTest {

    private KthSmallestElementInBST.TreeNode createBST() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(3);
        root.right = new KthSmallestElementInBST.TreeNode(6);
        root.left.left = new KthSmallestElementInBST.TreeNode(2);
        root.left.right = new KthSmallestElementInBST.TreeNode(4);
        return root;
    }

    @Test
    public void testKthSmallestElement() {
        KthSmallestElementInBST.TreeNode root = createBST();
        assertEquals(2, KthSmallestElementInBST.kthSmallest(root, 1), "1st smallest should be 2");
        assertEquals(3, KthSmallestElementInBST.kthSmallest(root, 2), "2nd smallest should be 3");
        assertEquals(4, KthSmallestElementInBST.kthSmallest(root, 3), "3rd smallest should be 4");
        assertEquals(5, KthSmallestElementInBST.kthSmallest(root, 4), "4th smallest should be 5");
        assertEquals(6, KthSmallestElementInBST.kthSmallest(root, 5), "5th smallest should be 6");
    }

    @Test
    public void testSingleNodeTree() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(10);
        assertEquals(10, KthSmallestElementInBST.kthSmallest(root, 1), "1st smallest in single node tree should be 10");
    }

    @Test
    public void testUnbalancedTree() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(8);
        root.left = new KthSmallestElementInBST.TreeNode(3);
        root.right = new KthSmallestElementInBST.TreeNode(10);
        root.left.left = new KthSmallestElementInBST.TreeNode(1);
        root.left.right = new KthSmallestElementInBST.TreeNode(6);
        root.left.right.left = new KthSmallestElementInBST.TreeNode(4);
        root.left.right.right = new KthSmallestElementInBST.TreeNode(7);
        root.right.right = new KthSmallestElementInBST.TreeNode(14);
        root.right.right.left = new KthSmallestElementInBST.TreeNode(13);

        assertEquals(1, KthSmallestElementInBST.kthSmallest(root, 1));
        assertEquals(3, KthSmallestElementInBST.kthSmallest(root, 2));
        assertEquals(4, KthSmallestElementInBST.kthSmallest(root, 3));
        assertEquals(6, KthSmallestElementInBST.kthSmallest(root, 4));
        assertEquals(7, KthSmallestElementInBST.kthSmallest(root, 5));
        assertEquals(8, KthSmallestElementInBST.kthSmallest(root, 6));
        assertEquals(10, KthSmallestElementInBST.kthSmallest(root, 7));
        assertEquals(13, KthSmallestElementInBST.kthSmallest(root, 8));
        assertEquals(14, KthSmallestElementInBST.kthSmallest(root, 9));
    }
}
