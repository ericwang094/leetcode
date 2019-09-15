package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L0103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        boolean fromLeft = true;

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> levels = new LinkedList<TreeNode>();
        levels.offer(root);
        while(!levels.isEmpty()) {
            int levelLength = levels.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelLength; i++) {
                TreeNode currentNode = levels.poll();
                if (currentNode.left != null) {
                    levels.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    levels.add(currentNode.right);
                }

                if(fromLeft) {
                    currentLevel.add(currentNode.val);
                } else {
                    currentLevel.add(0, currentNode.val);
                }
            }
            result.add(currentLevel);
            fromLeft = !fromLeft;
        }

        return result;
    }
}
