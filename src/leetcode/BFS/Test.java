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

	public static void main(String[] args) {
		Test t = new Test();
		int[] input = {1,4,6,8};


	}
}

