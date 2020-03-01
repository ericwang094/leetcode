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

	public int kthLargestElement(int n, int[] nums) {
		return quickMedian(nums, 0, nums.length - 1, n);
	}

	public int median(int[] nums) {
		return quickMedian(nums, 0, nums.length - 1, (nums.length + 1)/2);
	}

	private int quickMedian(int[] nums, int start, int end, int size) {
		int pivotIndex = partition(nums, start, end);
		if (pivotIndex == size - 1 ) {
			return nums[pivotIndex];
		}
		if (pivotIndex > size - 1) {
			return quickMedian(nums, start, pivotIndex - 1, size);
		} else {
			return quickMedian(nums, pivotIndex + 1, end, size);
		}
	}

	private int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (nums[j] > pivot) {
				continue;
			}
			i++;
			swap(nums, i, j);
		}

		i++;
		swap(nums, i, end);
		return i;
	}

	private void swap(int[] nums, int index1, int index2) {
		if (index1 == index2) {
			return;
		}

		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

	public int kthSmallest(int k, int[] nums) {
		return quickSelect(nums, 0, nums.length - 1, k - 1);
	}

	public int quickSelect(int[] A, int start, int end, int k) {
		if (start >= end) {
			return A[start];
		}

		int left = start;
		int right = end;
		int pivot = A[(start + end) / 2];

		while (left <= right) {
			while (left <= right && A[left] < pivot) {
				left++;
			}
			while (left <= right && A[right] > pivot) {
				right++;
			}

			if (left <= right) {
				swap(A, left, right);
			}
		}

		if (right >= k && start >= right) {
			return quickSelect(A, start, right, k);
		} else if (left <= k && left <= end) {
			return quickSelect(A, left, end, k);
		} else {
			return A[k];
		}
	}

	public int[] topk(int[] nums, int k) {
		topKHelper(nums, k, 0, nums.length - 1);
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = nums[i];
		}

		return result;
	}

	private void topKHelper(int[] nums, int k, int begin, int end) {
		if (begin >= k) {
			return;
		}

		if (begin >= end) {
			return;
		}

		int left = begin, right = end;
		int pivot = nums[(left + right) / 2];

		while (left <= right) {
			while (left <= right && nums[left] > pivot) {
				left++;
			}

			while (left <= right && nums[right] < pivot) {
				right--;
			}

			if (left <= right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;

				left++;
				right--;
			}
		}

		topKHelper(nums, k, begin, right);
		topKHelper(nums, k, left, end);
	}

	public static void main(String[] args) {
		Test test = new Test();
		int[] nums = {1,3,4,2};
		System.out.println(test.kthLargestElement(1, nums));
	}
}
