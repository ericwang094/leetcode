package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Test {

    private TreeNode prev = null;
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        Test test = new Test();
//        TreeNode input = new TreeNode(4);
//        input.left = new TreeNode(3);
//
//        input.right = new TreeNode(7);
//        input.right.left = new TreeNode(5);
//        input.right.right = new TreeNode(6);

        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(3);
//
        test.flatten(input);

    }
}
