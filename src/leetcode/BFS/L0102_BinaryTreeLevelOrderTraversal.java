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
            Queue<TreeNode> nodeList = new LinkedList<>();
            nodeList.offer(root);
            while (!nodeList.isEmpty()) {
                int nodeListLength = nodeList.size();
                List<Integer> currentLevel = new ArrayList<>();
                for (int i = 0; i < nodeListLength; i++) {
                    TreeNode currentNode = nodeList.poll();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        nodeList.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        nodeList.offer(currentNode.right);
                    }
                }
                result.add(currentLevel);
            }
            return result;
        }
    }
}
