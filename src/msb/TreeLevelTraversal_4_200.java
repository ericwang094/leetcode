package msb;

import msb.CommonDataStructure.TreeNode;

import java.util.*;

// There is leetcode 662 https://leetcode.com/problems/maximum-width-of-binary-tree/description/
// https://leetcode.com/problems/maximum-width-of-binary-tree/solutions/1802311/c-bfs-easy-to-understand-full-explanation/
public class TreeLevelTraversal_4_200 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();

        queue.add(root);
        map.put(root, 1);
        int maxWidth = Integer.MIN_VALUE;

        while(queue.size() != 0) {
            int size = queue.size();

            int levelStart = map.get(queue.peek());
            int lastIndex = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                lastIndex = map.get(node);

                if (node.left != null) {
                    queue.add(node.left);
                    map.put(node.left, 2*map.get(node)+1);
                }

                if (node.right != null) {
                    queue.add(node.right);
                    map.put(node.right, 2*map.get(node)+2);
                }
            }
            maxWidth = Math.max(maxWidth, lastIndex - levelStart + 1);
        }

        return maxWidth;
    }
}
