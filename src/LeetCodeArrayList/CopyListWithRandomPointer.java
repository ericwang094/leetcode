package LeetCodeArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
		Node firstHead = head;
		Map<Node, Node> map = new HashMap<>();

		while (head != null) {
			Node newNode = new Node(head.val);
			map.put(head, newNode);
			head = head.next;
		}

		for (Map.Entry<Node, Node> entry : map.entrySet()) {
			Node originalNode = entry.getKey();
			Node newNode = entry.getValue();

			newNode.next = map.get(originalNode.next);
			newNode.random = map.get(originalNode.random);
		}

		return map.get(firstHead);
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
