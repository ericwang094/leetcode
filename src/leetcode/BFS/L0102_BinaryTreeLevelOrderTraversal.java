package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L0102_BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelResult = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    levelResult.add(node.val);

                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                result.add(levelResult);
            }
            return result;
        }

        public List<List<Integer>> levelOrderDFS(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            int maxLevel = 0;
            while (true) {
                List<Integer> levelResult = new ArrayList<>();

                dfs(root, levelResult, 0, maxLevel);
                if (levelResult.size() == 0) {
                    break;
                }

                result.add(levelResult);
                maxLevel++;
            }

            return result;
        }

        private void dfs(TreeNode node, List<Integer> levelResult, int currentLevel, int maxLevel) {
            if (node == null || currentLevel > maxLevel) {
                return;
            }

            if (currentLevel == maxLevel) {
                levelResult.add(node.val);
                return;
            }

            dfs(node.left, levelResult, currentLevel + 1, maxLevel);
            dfs(node.right, levelResult, currentLevel + 1, maxLevel);
        }
    }
}
