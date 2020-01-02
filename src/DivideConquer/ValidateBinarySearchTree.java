package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }

        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (pre != null && node.val <= pre.val) {
                return false;
            } else {
                pre = node;
            }

            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    node = node.left;
                    stack.add(node);
                }
            } else {
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            }
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean divConq (TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return divConq(root.left, min, Math.min(max, root.val))
                && divConq(root.right, Math.max(min, root.val), max);
    }
}
