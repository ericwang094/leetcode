package DivideConquer;

import leetcode.BFS.TreeNode;

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

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        test.flatten(root);
    }
}
