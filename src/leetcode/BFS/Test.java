package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
	/*
	 * @param numCourses: a total of n courses
	 * @param prerequisites: a list of prerequisite pairs
	 * @return: true if can finish all courses or false
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] degrees = new int[numCourses];
		List<Integer>[] edges = new List[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			degrees[prerequisites[i][0]]++;
			edges[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] == 0) {
				queue.add(i);
			}
		}

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int currentCourse = queue.poll();
				for (int j = 0; j < edges[currentCourse].size(); j++) {
					degrees[edges[currentCourse].get(j)]--;
					if (degrees[edges[currentCourse].get(j)] == 0) {
						queue.add(edges[currentCourse].get(j));
					}
				}
			}
			count++;
		}

		return count == numCourses;
	}

}

