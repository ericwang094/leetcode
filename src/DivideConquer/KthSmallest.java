package DivideConquer;

import leetcode.BFS.TreeNode;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        TreeNode node = null;
        for (int i = 0; i < k ; i++) {
            node = stack.pop();
            TreeNode nodePlaceHolder = node;
            if (nodePlaceHolder.right != null) {
                nodePlaceHolder = nodePlaceHolder.right;
                while (nodePlaceHolder != null) {
                    stack.add(nodePlaceHolder);
                    nodePlaceHolder = nodePlaceHolder.left;
                }
            } else {
                while (!stack.isEmpty() && stack.peek().right == nodePlaceHolder) {
                    nodePlaceHolder = stack.pop();
                }
            }
        }

        return node.val;
    }


//    public int kthSmallest2(TreeNode root, int k) {
//        MyStack<TreeNode> stack = new MyStack<>();
//        stack.add(root);
//        for (int i = 0; i < k; i++) {
//            TreeNode node = stack.pop();
//            while (node.left != null) {
//                stack.add(node.left);
//                node = node.left;
//            }
//
//        }
//    }

    public static void main(String[] args) {
        KthSmallest test = new KthSmallest();
//        TreeNode input = new TreeNode(10);
//        input.left = new TreeNode(5);
//        input.left.right = new TreeNode(6);
//        input.left.right.right = new TreeNode(7);
//
//        input.left.left = new TreeNode(3);
//
//
//        input.left.left.left = new TreeNode(2);
//        input.left.left.right = new TreeNode(4);
//        input.left.left.left.left = new TreeNode(1);

        TreeNode input = new TreeNode(1);
//        input.left = new TreeNode(5);

        input.right = new TreeNode(2);

        System.out.println(test.kthSmallest(input, 2));
    }
}
