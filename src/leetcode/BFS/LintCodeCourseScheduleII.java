package leetcode.BFS;

import java.util.*;

public class LintCodeCourseScheduleII {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
        }

        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (degree[prerequisites[i][1]] == 0) {
                queue.add(prerequisites[i][1]);
            }
        }

        int count = 0;

        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();
            result.add(currentCourse);
            count++;
            int size = edges[currentCourse].size();
            for (int i = 0; i < size; i++) {
                int pointer = (int) edges[currentCourse].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                    result.add(prerequisites[i][1]);
                }
            }
        }

        if (count == numCourses) {
            int[] resultArray = new int[numCourses];
            for (int i = 0; i < result.size(); i++) {
            	resultArray[i] = (int) result.get(i);
            }
            return resultArray;
        } else {

            return new int[]{};
        }

    }
}
