package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L0103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean fromLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (fromLeft) {
                    levelResult.add(node.val);
                } else {
                    levelResult.add(0, node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            fromLeft = !fromLeft;
            result.add(levelResult);
        }
        return result;
    }

    public List<List<Integer>> test(TreeNode root)  {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean fromLeft = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (fromLeft) {
                    levelList.add(node.val);
                } else {
                    levelList.add(0, node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            fromLeft = !fromLeft;
            list.add(levelList);
        }
        return list;
    }

    public static void main(String[] args) {
        L0103_BinaryTreeZigzagLevelOrderTraversal test = new L0103_BinaryTreeZigzagLevelOrderTraversal();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.right.right = new TreeNode(5);

        test.test(node);
    }
}
