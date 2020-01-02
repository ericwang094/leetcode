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


    public static void main(String[] args) {
        Test test = new Test();
//        TreeNode input = new TreeNode(4);
//        input.left = new TreeNode(3);
//
//        input.right = new TreeNode(7);
//        input.right.left = new TreeNode(5);
//        input.right.right = new TreeNode(6);

        TreeNode input = new TreeNode(2);
        input.left = new TreeNode(1);
        input.right = new TreeNode(2);
//
//        boolean result = test.isValidBST2(input);
//        if (result) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }

    }
}
