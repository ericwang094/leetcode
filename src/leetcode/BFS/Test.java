package leetcode.BFS;

import TwoPointers.ListNode;

import java.util.*;

public class Test {

	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[mid] < target) {
				if (A[start] <= target && A[mid] >= target) {
					end = mid;
				} else {
					start = mid;
				}
			} else {
				if (A[mid] < target && A[end] > target) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}

		if (A[start] == target) {
			return start;
		} else if (A[end] == target){
			return end;
		} else {
			return -1;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode tail = reverseList(head.next);
		head.next.next = head;
		head.next = null;

		return tail;
	}

	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
		// write your code here
		Map<Integer, Integer> indegree = new HashMap<>();
		Map<Integer, Set<Integer>> edge = new HashMap<>();

		for (int[] seq : seqs) {
			if (seq.length > 0) {
				indegree.putIfAbsent(seq[0], 0);
			}

			for (int i = 0; i < seq.length - 1; i++) {
				int existingDegree = indegree.getOrDefault(seq[i+1], 0);
				existingDegree++;
				indegree.put(seq[i + 1], existingDegree);

				Set<Integer> existingEdge = edge.getOrDefault(seq[i], new HashSet<Integer>());
				existingEdge.add(seq[i+1]);
				edge.put(seq[i], existingEdge);
			}
		}

		if (indegree.size() != org.length) {
			return false;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < org.length; i++) {
			if (indegree.get(org[i]) == 0) {
				queue.add(org[i]);
			}
		}

		if (queue.size() > 1) {
			return false;
		}

		int index = 0;
		while (!queue.isEmpty()) {
			int currentNum = queue.poll();
			if (currentNum != org[index]) {
				return false;
			}
			index++;
			Set<Integer> currentEdgeSet = edge.getOrDefault(currentNum, new HashSet<>());
			for (int currentEdge : currentEdgeSet) {
				int currentEdgeDegree = indegree.get(currentEdge);
				currentEdgeDegree--;
				if (currentEdgeDegree == 0) {
					queue.add(currentEdge);
				}
				indegree.put(currentEdge, indegree.get(currentEdge) - 1);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Test t = new Test();
		int[] input1 = {1,2,3};
		int[][] input2 = {
				{1,2},
				{1,3},
				{2,3}
		};
		t.sequenceReconstruction(input1, input2);
	}
}

