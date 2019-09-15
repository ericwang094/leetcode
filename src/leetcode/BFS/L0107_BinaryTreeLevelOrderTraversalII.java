package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L0107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            result.add(0, currentLevel);
        }
        return result;
    }
}
