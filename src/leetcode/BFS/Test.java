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

	public List<Integer> numIslands2(int n, int m, Point[] operators) {
		// write your code here
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < operators.length; i++) {
			int[][] grid = new int[n][m];
			for (int j = 0; j <= i; j++) {
				grid[operators[j].x][operators[j].y] = 1;
			}

			int numOfIsland = 0;
			for (int j = 0; j <= i; j++) {
				// System.out.println("i: " + i);
				// System.out.println("j: " + j);
				if (grid[operators[j].x][operators[j].y] == 1) {
					numOfIsland++;
					System.out.println("num of islands: " + numOfIsland);
					bfs(grid, operators[j]);
				}
			}
			result.add(numOfIsland);
		}

		return result;
	}

	private void bfs(int[][] grid, Point point) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(point);

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			List<Point> neighbors = getNeighbors(p, grid);
			for (Point neighbor : neighbors) {
				queue.add(neighbor);
			}
		}
	}

	private List<Point> getNeighbors(Point p, int[][] grid) {
		List<Point> result = new ArrayList<>();
		int[] directionX = {-1, 0, 1, 0};
		int[] directionY = {0, -1, 0, 1};

		for (int i = 0; i < 4; i++) {
			int newX = p.x + directionX[i];
			int newY = p.y + directionY[i];
			if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1) {

				grid[newX][newY] = 0;
				result.add(new Point(newX, newY));
			}
		}
		return result;
	}

	public long kDistinctCharacters(String s, int k) {
		// Write your code here
		Set<Character> set = new HashSet<>();
		char[] cArr = new char[26];

		int i = 0;

		int result = 0;
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			cArr[c - 'a']++;
			set.add(c);
			if (set.size() >= k) {
				result += s.length() - j;


				cArr[s.charAt(i) - 'a']--;
				if (cArr[s.charAt(i) - 'a'] == 0) {
					set.remove(s.charAt(i));
				}
				i++;
			}
		}

		return result;
	}

	/**
	 * @param words: a list of words
	 * @return: a string which is correct order
	 */
	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}

		Map<Character, Set<Character>> graph = new HashMap<>();
		Map<Character, Integer> indegreeMap = new HashMap<>();

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				graph.putIfAbsent(c, new HashSet<>());
				indegreeMap.putIfAbsent(c, 0);
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word = words[i];
			String nextWord = words[i + 1];
			int index = 0;
			while (index < word.length() && index < nextWord.length()) {
				if (word.charAt(index) != nextWord.charAt(index)) {
					if (!graph.get(word.charAt(index)).contains(nextWord.charAt(index))) {
						graph.get(word.charAt(index)).add(nextWord.charAt(index));
						indegreeMap.put(nextWord.charAt(index), indegreeMap.get(nextWord.charAt(index)) + 1);
						break;
					}
				}
				index++;
			}
		}

		PriorityQueue<Character> pq = new PriorityQueue<>();
		for (Map.Entry<Character, Integer> entry : indegreeMap.entrySet()){
			if (entry.getValue() == 0) {
				pq.add(entry.getKey());
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			char currentChar = pq.poll();
			sb.append(currentChar);

			for (char c : graph.get(currentChar)) {
				int currentInDegree = indegreeMap.get(c);
				if (currentInDegree == 1) {
					pq.add(c);
					indegreeMap.remove(c);
				} else {
					indegreeMap.put(c, currentInDegree - 1);
				}
			}
		}

		String resultString = sb.toString();
		if (resultString.length() != graph.size()) {
			return "";
		}

		return resultString;
	}

	public static void main(String[] args) {
		Test t = new Test();

		t.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
	}

}
