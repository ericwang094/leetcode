package DivideConquer;

import leetcode.BFS.TreeNode;

public class LowestCommonAncestorIII {
    private boolean existA = false;
    private boolean existB = false;

    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        TreeNode result = divConq(root, A, B);
        if (existA && existB) {
            return result;
        } else {
            return null;
        }
    }

    private TreeNode divConq(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }

        TreeNode left = divConq(root.left, A, B);
        TreeNode right = divConq(root.right, A, B);

        if (root == A || root == B ){
            existA = root == A ? true : existA;
            existB = root == B ? true : existB;
            return root;
        }

        if (left != null && right != null) {

            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        TreeNode input = new TreeNode(2);
        input.left = new TreeNode(-1);

        LowestCommonAncestorIII lca = new LowestCommonAncestorIII();
        lca.lowestCommonAncestor3(input, input, input.left);
    }
}