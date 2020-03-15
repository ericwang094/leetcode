package SweepLineAndDeque;
// look at https://leetcode.com/problems/the-skyline-problem/discuss/61197/(Guaranteed)-Really-Detailed-and-Good-(Perfect)-Explanation-of-The-Skyline-Problem
import java.util.*;

public class TheSkylineProblem {
	/**
	 * @param buildings: A list of lists of integers
	 * @return: Find the outline of those buildings
	 */
	public List<List<Integer>> buildingOutline(int[][] buildings) {
		List<List<Integer>> result = new ArrayList<>();
		if (buildings.length == 0 || buildings[0].length == 0) {
			return result;
		}

		int index = 0;
		Point[] pointArray = new Point[buildings.length * 2];
		for (int[] building : buildings) {
			int start = building[0];
			int end = building[1];
			int h = building[2];
			pointArray[index] = new Point(start, h, Point.START);
			pointArray[index + 1] = new Point(end, h, Point.END);
			index += 2;
		}
		Arrays.sort(pointArray);

		TreeMap<Integer, Integer> heights = new TreeMap<>();
		int preHeight = 0;
		int preIndex = 0;

		for (Point curr : pointArray) {

			if (curr.isStart == Point.START) {
				heights.putIfAbsent(curr.height, 0);
				heights.put(curr.height, heights.get(curr.height) + 1);
			} else {
				heights.put(curr.height, heights.get(curr.height) - 1);
				if (heights.get(curr.height) == 0) {
					heights.remove(curr.height);
				}
			}
			int currentHeight = heights.size() == 0 ? 0 : heights.lastKey();
			if (preHeight != currentHeight) {
				if (curr.x != preIndex && preHeight != 0) {
					List<Integer> subResult = new ArrayList<>();
					subResult.add(preIndex);
					subResult.add(curr.x);
					subResult.add(preHeight);

					result.add(subResult);
				}
				preIndex = curr.x;
				preHeight = currentHeight;
			}
		}

		return result;
	}

	private class Point implements Comparable<Point> {
		public static final int START = -1;
		public static final int END = 1;
		private int x;
		private int height;
		private int isStart;

		public Point(int x, int height, int isStart) {
			this.x = x;
			this.height = height;
			this.isStart = isStart;
		}

		public int compareTo(Point p) {
			if (this.x != p.x) {
				return this.x - p.x;
			}

			if (this.isStart == p.isStart) {
				return this.height - p.height;
			}

			return isStart;
		}
	}

	public static void main(String[] args) {
		TheSkylineProblem skp = new TheSkylineProblem();
		int[][] input = new int[3][3];
		input[0] = new int[]{1, 3, 3};
		input[1] = new int[]{2, 4, 4};
		input[2] = new int[]{5, 6, 1};

		skp.buildingOutline(input);
	}
}
