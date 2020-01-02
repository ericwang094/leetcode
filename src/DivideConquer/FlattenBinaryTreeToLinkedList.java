package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode leftNode = helper(root.left);
        TreeNode rightNode = helper(root.right);

        if (leftNode != null) {
            leftNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightNode != null) {
            return rightNode;
        }

        if (leftNode != null) {
            return leftNode;
        }

        return root;
    }

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten2(root.left);
        flatten2(root.right);

        if (root.left == null) {
            return;
        }

        TreeNode node = root.left;
        while (node.right != null) {
            node = node.right;
        }

        node.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }

            node.left = null;
            if (stack.empty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        test.flatten3(root);
    }
}
