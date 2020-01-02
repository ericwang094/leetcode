package DivideConquer;

import leetcode.BFS.TreeNode;

public class LowestCommonAncestor {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }

        if (root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

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

    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        if (root == null) {
            return null;
        }
        if (root == A || root == B) {
            return root;
        }

        int levelLeft = levelOfNode(A);
        int levelRight = levelOfNode(B);

        ParentTreeNode leftNode = A;
        ParentTreeNode rightNode = B;

        while (levelLeft != levelRight) {
            if (levelLeft > levelRight) {
                leftNode = leftNode.parent;
                levelLeft--;
            } else {
                rightNode = rightNode.parent;
                levelRight--;
            }
        }

        while (leftNode != rightNode && leftNode != null && rightNode != null) {
            leftNode = leftNode.parent;
            rightNode = rightNode.parent;
        }

        return leftNode;

    }

    private int levelOfNode (ParentTreeNode root) {
        int level = 0;
        while (root != null) {
            root = root.parent;
            level++;
        }

        return level;
    }

    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }
}
