package msb;

import msb.CommonDataStructure.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/validate-binary-search-tree/

public class ValidateBinarySearchTree_5_20 {
    private static int preValue = Integer.MIN_VALUE;
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        boolean isLeftTreeBST = isValidBST(root.left);
//        if (!isLeftTreeBST) {
//            return false;
//        }
//
//        if (preValue >= root.val) {
//            return false;
//        } else {
//            preValue = root.val;
//        }
//
//        return isValidBST(root.right);
//    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        TreeNode preNode = null;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (preNode != null && node.val <= preNode.val) {
                return false;
            } else {
                preNode = node;
            }

            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}

