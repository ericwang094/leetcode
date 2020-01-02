package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    /*
     * @param root: The root of binary tree.
     */public BSTIterator(TreeNode root) {
        // do intialization if necessary
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode cur = stack.peek();
        TreeNode node = cur;

        if (node.right != null) {
            node = node.right;
            stack.add(node);
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        } else {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        }

        return cur;
    }
}
