package DivideConquer;

import leetcode.BFS.TreeNode;

public class ClosestBinarySearchTreeValue_solution2 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        TreeNode lowerNode = root;
        TreeNode upperNode = root;
        while (root != null) {
            if (root.val > target) {
                upperNode = root;
                root = root.left;
            } else if (root.val < target){
                lowerNode = root;
                root = root.right;
            } else {
                return root.val;
            }
        }

        if (Math.abs(target - lowerNode.val) >= Math.abs(upperNode.val - target)) {
            return upperNode.val;
        }
        return lowerNode.val;
    }

    public static void main(String[] args) {
        ClosestBinarySearchTreeValue_solution2 test = new ClosestBinarySearchTreeValue_solution2();
        TreeNode input = new TreeNode(3);
        input.left = new TreeNode(2);
        input.left.left = new TreeNode(1);

        input.right = new TreeNode(4);

        test.closestValue(input, 4.142857);
    }
}
