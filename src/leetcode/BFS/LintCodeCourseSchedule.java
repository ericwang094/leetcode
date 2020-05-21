package leetcode.BFS;

import java.util.*;

public class LintCodeCourseSchedule {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List[] edges = new ArrayList[numCourses];
//    	int[] degree = new int[numCourses];
//
//    	for(int i = 0; i < numCourses; i++) {
//    		edges[i] = new ArrayList<Integer>();
//	    }
//
//	    for (int i = 0; i < prerequisites.length; i++) {
//    		degree[prerequisites[i][0]]++;
//    		edges[prerequisites[i][1]].add(prerequisites[i][0]);
//	    }
//
//	    Queue<Integer> queue = new LinkedList<>();
//    	for (int i = 0; i < degree.length; i++) {
//    		if (degree[i] == 0) {
//    			queue.add(i);
//		    }
//	    }
//
//	    int count = 0;
//    	while(!queue.isEmpty()) {
//    		int course = queue.poll();
//    		count++;
//    		int n = edges[course].size();
//    		for (int i = 0; i < n; i++) {
//    			int pointer = (int) edges[course].get(i);
//    			degree[pointer]--;
//    			if (degree[pointer] == 0) {
//    				queue.add(pointer);
//			    }
//		    }
//	    }
//		return count == numCourses;
//    }

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// write your code here
		Map<Integer, Set<Integer>> courseWithPrerequisit = new HashMap<>();
		Map<Integer, Set<Integer>> courseBlockingList = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			Set<Integer> s1 = courseWithPrerequisit.getOrDefault(prerequisites[i][1], new HashSet<>());
			s1.add(prerequisites[i][0]);
			courseWithPrerequisit.put(prerequisites[i][1], s1);

			courseWithPrerequisit.putIfAbsent(prerequisites[i][0], new HashSet<>());

			Set<Integer> s2 = courseBlockingList.getOrDefault(prerequisites[i][0], new HashSet<>());
			s2.add(prerequisites[i][1]);
			courseBlockingList.put(prerequisites[i][0], s2);

		}

		Queue<Integer> queue = new LinkedList<>();
		for (Map.Entry<Integer, Set<Integer>> entry : courseWithPrerequisit.entrySet()) {
			if (entry.getValue().size() == 0) {
				queue.add(entry.getKey());
			}
		}
		int steps = 0;
		while (!queue.isEmpty()) {
			int canFinishCauseNumber = queue.poll();
			steps++;
			courseWithPrerequisit.remove(canFinishCauseNumber);

			Set<Integer> blockedList = courseBlockingList.getOrDefault(canFinishCauseNumber, new HashSet<>());
			for (Integer i : blockedList) {
				courseWithPrerequisit.get(i).remove(canFinishCauseNumber);
				if (courseWithPrerequisit.get(i).size() == 0) {
					queue.add(i);
				}
			}
		}
		return courseWithPrerequisit.isEmpty() && steps <= numCourses;
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
