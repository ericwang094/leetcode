package leetcode.BFS;

import java.util.*;

public class LintCodeCourseSchedule {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        List<Integer>[] edges = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        // build edges, degree
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

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < edges[course].size(); i++) {
                int pointer = edges[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.offer(pointer);
                }
            }
        }

        return count == numCourses;
    }

    public static void main (String[] args) {
        LintCodeCourseSchedule test = new LintCodeCourseSchedule();
//        int[][] prerequest = {};
//        int[][] prerequest = {{1, 0}};
//        int[][] prerequest = {{1, 0}, {0, 1}};
//        [5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]
        int[][] prerequest = {
            {5,8},
            {3,5},
            {1,9},
            {4,5},
            {0,2},
            {1,9},
            {7,8},
            {4,9},
        };
        if (test.canFinish(10, prerequest)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}