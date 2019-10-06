package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    /*
     * @param root: The root of binary tree.
     */
    public BSTIterator(TreeNode root) {
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
        TreeNode currentNode = stack.peek();
        TreeNode node = currentNode;

        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        } else {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        }

        return currentNode;
    }
}
