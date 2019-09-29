package DivideConquer;

import leetcode.BFS.TreeNode;

public class MinimumSubTree {
    private TreeNode subTree = null;
    private int subTreeSum = Integer.MAX_VALUE;
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subTree;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = helper(root.left) + helper(root.right) + root.val;
        if (sum <= subTreeSum) {
            subTree = root;
            subTreeSum = sum;
        }
        return sum;
    }

    
}
