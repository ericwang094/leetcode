package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class L297_SerializeDeserializeBinaryTree {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val).append(",");
            }
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")) {
            return null;
        }

        String[] nodeValues = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;

        for (int i = 1; i < nodeValues.length; i++) {
            if (!nodeValues[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(nodeValues[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }

            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);

        L297_SerializeDeserializeBinaryTree sdb = new L297_SerializeDeserializeBinaryTree();
        System.out.println(sdb.serialize(node));

    }
}

