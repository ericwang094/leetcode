package msb;

import msb.CommonDataStructure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfTree_6_123 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root, null);
        process(root, fatherMap);

        HashSet<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = fatherMap.get(p);
        }

        while (q != null) {
            if (set.contains(q)) {
                return q;
            }

            q = fatherMap.get(q);
        }

        return null;
    }

    private void process(TreeNode root, HashMap<TreeNode, TreeNode> fatherMap) {
        if (root == null) {
            return;
        }

        fatherMap.put(root.left, root);
        fatherMap.put(root.right, root);

        process(root.left, fatherMap);
        process(root.right, fatherMap);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
