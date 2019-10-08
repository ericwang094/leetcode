package DivideConquer;

import leetcode.BFS.TreeNode;

public class LowestCommonAncestorIII {
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        LowestCommonAncestorIIIResultType rt = helper(root, A, B);
        if (rt.a_exist && rt.b_exist) {
            return rt.node;
        } else {
            return null;
        }
    }

    public LowestCommonAncestorIIIResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new LowestCommonAncestorIIIResultType(false, false, null);
        }

        LowestCommonAncestorIIIResultType leftRt = helper(root.left, A, B);
        LowestCommonAncestorIIIResultType rightRt = helper(root.right, A, B);

        boolean a_exist = leftRt.a_exist || rightRt.a_exist || root == A;
        boolean b_exist = leftRt.b_exist || rightRt.b_exist || root == B;

        if (root == A || root == B) {
            return new LowestCommonAncestorIIIResultType(a_exist, b_exist, root);
        }

        if (leftRt.node != null && rightRt.node != null) {
            return new LowestCommonAncestorIIIResultType(a_exist, b_exist, root);
        }
        if (leftRt.node != null) {
            return new LowestCommonAncestorIIIResultType(a_exist, b_exist, leftRt.node);
        }
        if (rightRt.node != null) {
            return new LowestCommonAncestorIIIResultType(a_exist, b_exist, rightRt.node);
        }

        return new LowestCommonAncestorIIIResultType(a_exist, b_exist, null);
    }
}

class LowestCommonAncestorIIIResultType {
    public boolean a_exist, b_exist;
    public TreeNode node;
    LowestCommonAncestorIIIResultType (boolean a, boolean b, TreeNode n) {
        a_exist = a;
        b_exist = b;
        node = n;
    }
}