package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LintconvertBinaryTreeToLinkedListsByDepth {
	/**
	 * @param root the root of binary tree
	 * @return a lists of linked list
	 */
	public List<ListNode> binaryTreeToLists(TreeNode root) {
		// Write your code here
		if (root == null) {
			return new ArrayList<>();
		}
		List<ListNode> result = new ArrayList<ListNode>();
		Queue<TreeNode> levels = new LinkedList<TreeNode>();
		levels.add(root);

		while (!levels.isEmpty()) {
			ListNode dummy = new ListNode(0);
			ListNode lastNode = dummy;
			int currentLevelLength = levels.size();
			for (int i = 0; i < currentLevelLength; i++) {
				TreeNode currentNode = levels.poll();
				if (currentNode.left != null) {
					levels.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					levels.offer(currentNode.right);
				}
				lastNode.next = new ListNode(currentNode.val);
				lastNode = lastNode.next;
			}
			result.add(dummy.next);
		}

		return result;
	}

//    private void addToListNode(ListNode root, ListNode listNode) {
//        if (listNode != null) {
//            while (root.next != null) {
//                root = root.next;
//            }
//            root.next = listNode;
//        }
//
//    }

	public List<ListNode> test(TreeNode root) {
		// Write your code here
		List<ListNode> result = new ArrayList<ListNode>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			ListNode listNode = new ListNode(0);
			ListNode currentNode = listNode;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				currentNode.next = new ListNode(node.val);
				currentNode = currentNode.next;

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(listNode.next);
		}
		return result;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		LintconvertBinaryTreeToLinkedListsByDepth mainTest = new LintconvertBinaryTreeToLinkedListsByDepth();
		TreeNode testNode = new TreeNode(1);
		testNode.left = new TreeNode(2);
		testNode.right = new TreeNode(-5);

		testNode.left.left = new TreeNode(4);

		testNode.right.left = new TreeNode(5);
		testNode.right.right = new TreeNode(6);

		mainTest.binaryTreeToLists(testNode);
	}
}
