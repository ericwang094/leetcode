package msb;

import msb.CommonDataStructure.TreeNode;

public class InOrderSuccessor_6_200 {
    // this is a similar question from blibli
    // https://leetcode.cn/problems/successor-lcci/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return root;
        }

        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }

            return p;
        } else {
            TreeNode successor = null;
            while (root != null) {
                if (root.val > p.val) {
                    successor = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }

            return successor;
        }
    }

    // the original question is not shown in leetcode
    // original question is not a binary search tree, so it has changed structure
    private class TreeNode2 {
        int val;
        TreeNode2 left;
        TreeNode2 right;
        TreeNode2 parent;
        TreeNode2(int x) {
            this.val = x;
        }
    }

    private TreeNode2 TreeNodeInorderSuccessor(TreeNode2 node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            TreeNode2 successor = null;
            successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        } else {
            TreeNode2 parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }

            return parent;
        }
    }
}
