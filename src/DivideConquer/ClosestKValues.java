package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ClosestKValues {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();

        if (k == 0 || root == null) {
            return values;
        }

        Stack<TreeNode> lowerStack = getStack(root, target);
        Stack<TreeNode> upperStack = new Stack<>();
        upperStack.addAll(lowerStack);
        if (target < lowerStack.peek().val) {
            moveLower(lowerStack);
        } else {
            moveUpper(upperStack);
        }

        for (int i = 0; i < k; i++) {
            if (lowerStack.isEmpty() ||
                    !upperStack.isEmpty() && target - lowerStack.peek().val > upperStack.peek().val - target) {
                values.add(upperStack.peek().val);
                moveUpper(upperStack);
            } else {
                values.add(lowerStack.peek().val);
                moveLower(lowerStack);
            }
        }

        return values;
    }

    private Stack<TreeNode> getStack(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);

            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return stack;
    }

    private void moveUpper(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();
        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        } else {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    private void moveLower(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();
        if (node.left == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().left == node) {
                node = stack.pop();
            }
        } else {
            node = node.left;
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
        }
    }

    // #####################################################
    // Solution 2
    // #####################################################
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        Stack<TreeNode> next = new Stack<TreeNode>();
        Stack<TreeNode> prev = new Stack<TreeNode>();
        TreeNode node = root;

        while (node != null) {
            if (node.val < target) {
                prev.push(node);
                node = node.right;
            } else {
                next.push(node);
                node = node.left;
            }
        }

        List<Integer> ret = new LinkedList<>();

        while (ret.size() < k) {
            double distp = prev.isEmpty() ? Integer.MAX_VALUE : target - prev.peek().val;
            double distn = next.isEmpty() ? Integer.MAX_VALUE : next.peek().val - target;

            if (distp < distn) {
                ret.add(0, prev.peek().val);
                goPrev(prev);
            } else {
                ret.add(next.peek().val);
                goNext(next);
            }
        }

        return ret;
    }

    private void goNext(Stack<TreeNode> st) {
        TreeNode r = st.pop().right;
        while (r != null) {
            st.push(r);
            r = r.left;
        }
    }

    private void goPrev(Stack<TreeNode> st) {
        TreeNode l = st.pop().left;

        while (l != null) {
            st.push(l);
            l = l.right;
        }
    }
}
