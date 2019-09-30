package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList();
        // write your code here
        if (root == null) {
            return result;
        }

        ArrayList<String> tempResult = new ArrayList<>();
        tempResult.add(Integer.toString(root.val));
        helper(root, tempResult, result);
        return result;
    }

    private void helper(TreeNode root, List<String> tempResult, ArrayList<String> result) {
        if (root.left == null && root.right == null) {
            String tempResultString = String.join("->", tempResult);
            result.add(tempResultString);
        } else {
            if (root.left != null) {
                int rootVal = root.left.val;
                tempResult.add(Integer.toString(rootVal));
                helper(root.left, tempResult, result);
                tempResult.remove(tempResult.size() - 1);
            }

            if (root.right != null) {
                int rootVal = root.right.val;
                tempResult.add(Integer.toString(rootVal));
                helper(root.right, tempResult, result);
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }
}
