package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LintCodeCourseScheduleII {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        // write your code here
        int[] degree = new int[numCourses];
        List<Integer>[] edges = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        int numOfCourse = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[numOfCourse] = course;
            numOfCourse++;

            for (int i = 0; i < edges[course].size(); i++) {
                int index = edges[course].get(i);
                degree[index]--;
                if (degree[index] == 0) {
                    queue.offer(index);
                }
            }
        }

        if (numOfCourse == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
