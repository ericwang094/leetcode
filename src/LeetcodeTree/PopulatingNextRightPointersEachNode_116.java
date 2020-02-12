package LeetcodeTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNode_116 {
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();

				if (size != 1 && i == size - 1) {
					queue.add(null);
				}
				if (node == null) {
					continue;
				}
				node.next = queue.peek();

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}

		return root;
	}

	public Node connect_2(Node root) {
		Node result = root;
		while(root != null && root.left != null) {
			Node cur = root;
			while(cur != null) {
				cur.left.next = cur.right;
				cur.right.next = cur.next == null ? null : cur.next.left;
				cur = cur.next;
			}
			root = root.left;
		}
		return result;
	}

	public Node connect_3(Node root) {
		Node result = root;

		if (root == null) {
			return root;
		}

		if (root.left != null) {
			root.left.next = root.right;
			if (root.next != null) {
				root.right.next = root.next.left;
			}
		}

		connect_3(root.left);
		connect_3(root.right);

		return result;
	}

	// Definition for a Node.
	static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		PopulatingNextRightPointersEachNode_116 test = new PopulatingNextRightPointersEachNode_116();
		test.connect(root);
	}
}
