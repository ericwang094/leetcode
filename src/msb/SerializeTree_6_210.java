package msb;

import msb.CommonDataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree_6_210 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }

        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }

        return reconPreOrder(queue);
    }

    private TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);

        return node;
    }
}
