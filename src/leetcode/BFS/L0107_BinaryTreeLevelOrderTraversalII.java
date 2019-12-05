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

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(0, levelList);
        }

        return result;
    }

    public static void main(String[] args) {
        L0107_BinaryTreeLevelOrderTraversalII test = new L0107_BinaryTreeLevelOrderTraversalII();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(2);

        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(4);

        test.levelOrderBottom(node);
    }
}
