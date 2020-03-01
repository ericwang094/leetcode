package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqChar {
	Set<Character> set = new HashSet<>();
	Map<Character, ListNode> keyToPrev = new HashMap<>();
	ListNode head = new ListNode(' ');
	ListNode tail = head;
	/**
	 * @param str: str: the given string
	 * @return: char: the first unique character in a given string
	 */
	public char firstUniqChar(String str) {

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (set.contains(currentChar)) {
				continue;
			}

			if (keyToPrev.containsKey(currentChar)) {
				set.add(currentChar);
				remove(currentChar);
			} else {
				ListNode node = new ListNode(currentChar);
				tail.next = node;
				keyToPrev.put(currentChar, tail);

				tail = node;
			}
		}

		return head.next.val;
	}

	private void remove (char c) {
		ListNode prevNode = keyToPrev.get(c);
		prevNode.next = prevNode.next.next;

		if (prevNode.next != null) {
			keyToPrev.put(prevNode.next.val, prevNode);
		} else {
			tail = prevNode;
		}
	}

	private class ListNode {
		Character val;
		ListNode next;
		public ListNode (Character val) {
			this.val = val;
		}
	}
}
