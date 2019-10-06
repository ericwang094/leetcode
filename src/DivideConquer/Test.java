package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public void flatten(TreeNode root) {
        // write your code here
        helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode flattenLeft = helper(root.left);
        TreeNode flattenRight = helper(root.right);

        if (flattenLeft != null) {
            flattenLeft.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (flattenRight != null) {
            return flattenRight;
        }

        if (flattenLeft != null) {
            return flattenLeft;
        }

        return root;
    }



    public static void main(String[] args) {
        Test test = new Test();
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.left.left = new TreeNode(5);

        input.right = new TreeNode(3);

    }
}
