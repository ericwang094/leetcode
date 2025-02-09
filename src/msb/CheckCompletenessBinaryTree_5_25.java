package msb;

import msb.CommonDataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
public class CheckCompletenessBinaryTree_5_25 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean firstIncompleteNode = false;
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node.right != null && node.left == null) {
                return false;
            }

            if (firstIncompleteNode && (node.left != null || node.right != null)) {
                return false;
            }

            if (node.left == null || node.right == null) {
                firstIncompleteNode = true;
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        CheckCompletenessBinaryTree_5_25 checkCompletenessBinaryTree = new CheckCompletenessBinaryTree_5_25();
        System.out.println(checkCompletenessBinaryTree.isCompleteTree(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        checkCompletenessBinaryTree = new CheckCompletenessBinaryTree_5_25();
        System.out.println(checkCompletenessBinaryTree.isCompleteTree(root));

    }
}

