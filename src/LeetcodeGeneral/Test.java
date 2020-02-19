package LeetcodeGeneral;

import TwoPointers.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
	public int firstUniqueNumber(int[] nums, int number) {
		DataStream ds = new DataStream();
		for (int i = 0; i < nums.length; i++) {
			ds.add(nums[i]);
			if (nums[i] == number) {
				return ds.firstUnique();
			}
		}
		return -1;
	}

	private class DataStream {
		Map<Integer, ListNode> keyToPrev;
		Set<Integer> duplicateSet;
		ListNode head;
		ListNode tail;

		public DataStream () {
			this.keyToPrev = new HashMap<Integer, ListNode>();
			this.duplicateSet = new HashSet<Integer>();
			this.head = new ListNode(-1);
			this.tail = head;
		}

		private void add(int val) {
			if (duplicateSet.contains(val)) {
				return;
			}

			if (keyToPrev.containsKey(val)) {
				duplicateSet.add(val);
				remove(val);
			} else {
				ListNode node = new ListNode(val);
				keyToPrev.put(val, tail);
				tail.next = node;
				tail = node;
			}
		}

		private void remove(int val) {
			ListNode prevNode = keyToPrev.get(val);
			ListNode currentNode = prevNode.next;

			prevNode.next = currentNode.next;

			if (currentNode.next != null) {
				keyToPrev.put(currentNode.next.val, prevNode);
			} else {
				tail = prevNode;
			}

			keyToPrev.remove(currentNode.val);
		}

		public int firstUnique() {
			if (head.next != null) {
				return head.next.val;
			}

			return -1;
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		int[] nums = {1, 2, 2, 1, 3, 4};
		test.firstUniqueNumber(nums, 3);
	}
}
