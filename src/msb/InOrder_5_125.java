package msb;

import msb.CommonDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder_5_125 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null ) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                TreeNode rightNode = node.right;
                stack.push(rightNode);
                while (rightNode.left != null) {
                    stack.push(rightNode.left);
                    rightNode = rightNode.left;
                }
            }
        }

        return res;
    }
}
