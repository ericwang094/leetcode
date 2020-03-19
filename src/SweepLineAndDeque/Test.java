package SweepLineAndDeque;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Test {
	/**
	 * @param buildings: A list of lists of integers
	 * @return: Find the outline of those buildings
	 */
	public List<List<Integer>> buildingOutline(int[][] buildings) {
		// write your code here

		List<List<Integer>> result = new ArrayList<>();
		if (buildings.length == 0 || buildings[0].length == 0) {
			return result;
		}

		List<Event> list = new ArrayList<>();
		for (int i = 0; i < buildings.length; i++) {
			list.add(new Event(buildings[i][0], buildings[i][2], Event.START));
			list.add(new Event(buildings[i][1], buildings[i][2], Event.END));
		}

		Collections.sort(list, new Comparator<Event>() {
			@Override
			public int compare(Event e1, Event e2) {
				if (e1.x == e2.x) {
					return e1.status - e2.status;
				}
				return e1.x - e2.x;
			}
		});

//		PriorityQueue<Event> pq = new PriorityQueue<Event>(new Comparator<Event>() {
//			@Override
//			public int compare(Event e1, Event e2) {
//				return e2.height - e1.height;
//			}
//		});

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer e1, Integer e2) {
				return e2 - e1;
			}
		});

		int previousHeight = 0;
		int prevIndex = 0;
		for (Event e : list) {
			if (e.status == Event.START) {
				pq.add(e.height);
			} else {
				pq.remove(e.height);
			}

			int currentHeight = pq.isEmpty() ? 0 : pq.peek();
			if (currentHeight != previousHeight) {
				if (e.x != prevIndex && previousHeight != 0) {
					List<Integer> tempList = new ArrayList<>();
					tempList.add(prevIndex);
					tempList.add(e.x);
					tempList.add(previousHeight);
					result.add(tempList);
				}
				previousHeight = currentHeight;
				prevIndex = e.x;
			}
		}

		return result;
	}

	private class Event {
		public static final int START = 1;
		public static final int END = 0;

		private int x;
		private int height;
		private int status;

		public Event(int x, int height, int status) {
			this.x = x;
			this.height = height;
			this.status = status;
		}
	}

	/**
	 * @param pages: an array of integers
	 * @param k: An integer
	 * @return: an integer
	 */
	public int copyBooks(int[] pages, int k) {
		// write your code here
		int start = 0, end = 0;
		for (int i = 0; i < pages.length; i++) {
			end += pages[i];
			start = Math.max(start, pages[i]);
		}

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int people = countPeople(pages, mid);
			if (people > k) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (countPeople(pages, start) <= k) {
			return start;
		}
		if (countPeople(pages, end) <= k) {
			return end;
		}

		return start;
	}

	private int countPeople(int[] pages, int k) {
		int num = 1;
		int sum = 0;
		for (int i = 0; i < pages.length; i++) {
			if (sum + pages[i] > k) {
				num++;
				sum = 0;
			}
			sum += pages[i];
		}

		return num;
	}

	public int woodCut(int[] L, int k) {
		if (L == null || L.length == 0) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int sum = 0;
		for (int i = 0; i < L.length; i++) {
			right = Math.max(right, L[i]);
			sum += L[i];
		}

		sum = Math.min(sum, k);

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			int cut = cut(L, mid);
			if (cut >= sum) {
				left = mid;
			} else {
				right = mid;
			}
		}

		int cut = cut(L, left);
		if (cut > sum) {
			return right;
		}
		return left;
	}

	private int cut(int[] L, int k) {
		int num = 0;
		for (int i = 0; i < L.length; i++) {
			num += L[i] / k;
		}

		return num;
	}

	public static void main(String[] args) {
		Test test = new Test();
//		int[][] input = new int[3][3];
//		input[0] = new int[]{1, 3, 3};
//		input[1] = new int[]{2, 4, 4};
//		input[2] = new int[]{5, 6, 1};
//
//		test.buildingOutline(input);

//		int[] input = {232, 124, 456};
//		int[] input = {6,6,5,5,6,5,4,4,5};
//		test.woodCut(input, 41);

		int[] input = {1, 2};
		test.copyBooks(input, 5);
	}
}
