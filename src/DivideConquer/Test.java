package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.*;

public class Test {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();

        while (root != null) {
            if (root.val < target) {
                preStack.add(root);
                root = root.right;
            } else {
                nextStack.add(root);
                root = root.left;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (result.size() < k ) {
            double distN = nextStack.isEmpty() ? Double.MAX_VALUE : Math.abs(nextStack.peek().val - target);
            double distP = preStack.isEmpty() ? Double.MAX_VALUE : Math.abs(target - preStack.peek().val);

            if (distN < distP) {
                result.add(nextStack.peek().val);
                goNext(nextStack);
            } else {
                result.add(0, preStack.peek().val);
                goPrev(preStack);
            }
        }

        return result;
    }

    private void goNext(Stack<TreeNode> stack) {
        TreeNode node = stack.pop().right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private void goPrev(Stack<TreeNode> stack) {
        TreeNode node = stack.pop().left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.add(node);
                    node = node.left;
                }
            } else {
                node = stack.pop();
                result.add(node.val);

                while (!stack.isEmpty() && stack.peek().right != null) {
                    node = stack.pop();
                    result.add(node.val);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
//        Test test = new Test();
//        TreeNode input = new TreeNode(4);
//        input.left = new TreeNode(3);
//
//        input.right = new TreeNode(7);
//        input.right.left = new TreeNode(5);
//        input.right.right = new TreeNode(6);

//        TreeNode input = new TreeNode(2);
//        input.left = new TreeNode(1);
//        input.right = new TreeNode(2);
//
//        boolean result = test.isValidBST2(input);
//        if (result) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
        System.out.println(((String)null).toUpperCase());
    }
}
