package DivideConquer;

import leetcode.BFS.TreeNode;

import java.sql.SQLOutput;
import java.util.Stack;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;

            n = n.right;
            while (n != null) {
                st.push(n);
                n = n.left;
            }
        }

        return -1; // never hit if k is valid
    }

    public static void main(String[] args) {
        KthSmallest test = new KthSmallest();
        TreeNode input = new TreeNode(10);
        input.left = new TreeNode(5);
        input.left.right = new TreeNode(6);
        input.left.right.right = new TreeNode(7);

        input.left.left = new TreeNode(3);


        input.left.left.left = new TreeNode(2);
        input.left.left.right = new TreeNode(4);
        input.left.left.left.left = new TreeNode(1);

        System.out.println(test.kthSmallest(input, 5));
    }
}
