package msb;

import msb.CommonDataStructure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// There is no leetcode question for this. The leetcode 662 counts null node.
// This is the one no null node
public class TreeLevelTraversal_4_201 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        // key: node, value: the level of this node
        HashMap<TreeNode, Integer> map = new HashMap<>();

        queue.add(root);
        map.put(root, 1);

        int curLevel = 1;
        int curLevelNodes = 0;
        int maxWidth = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int currentLevel = map.get(cur);

            if(currentLevel == curLevel) {
                curLevelNodes++;
            } else {
                maxWidth = Math.max(maxWidth, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }

            if (cur.left != null) {
                queue.add(cur.left);
                map.put(cur.left, curLevelNodes + 1);
            }

            if (cur.right != null) {
                queue.add(cur.right);
                map.put(cur.right, curLevelNodes + 1);
            }
        }

        return maxWidth;
    }
}
