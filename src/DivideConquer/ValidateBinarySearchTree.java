package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        TreeNode lastNode = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (lastNode != null && lastNode.val >= node.val) {
                return false;
            }
            lastNode = node;

            // move to next
            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

       return true;
    }
}
