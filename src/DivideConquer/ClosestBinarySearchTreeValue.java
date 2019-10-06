package DivideConquer;

import leetcode.BFS.TreeNode;

public class ClosestBinarySearchTreeValue {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (root == null) {
            return 0;
        }

        TreeNode lowerNode = lowerBound(root, target);
        TreeNode upperNode = upperBound(root, target);

        if (lowerNode == null) {
            return upperNode.val;
        }

        if (upperNode == null) {
            return lowerNode.val;
        }

        if (target - lowerNode.val > upperNode.val - target) {
            return upperNode.val;
        }

        return lowerNode.val;
    }

    private TreeNode lowerBound (TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (target <= root.val) {
            return lowerBound(root.left, target);
        }

        TreeNode lowerNode = lowerBound(root.right, target);
        if (lowerNode != null) {
            return lowerNode;
        }

        return root;
    }

    private TreeNode upperBound (TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (root.val < target) {
            return upperBound(root.right, target);
        }

        TreeNode upperNode = upperBound(root.left, target);
        if (upperNode != null) {
            return upperNode;
        }

        return root;
    }
}
