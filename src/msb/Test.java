package msb;

import msb.CommonDataStructure.ListNode;

import java.util.*;

public class Test {
    private class Edge {
        public int from;
        public int to;
        public int weight;

        public Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }



    private Set<Edge> constructGraph(int[][] connections) {
        Set<Edge> edges = new HashSet<>();
        for (int[] connection: connections) {
            int from = connection[0];
            int to = connection[1];
            int weight = connection[2];

            Edge edge1 = new Edge(from, to, weight);

            edges.add(edge1);
        }

        return edges;
    }

    public static void main(String[] args) {
        Test sol = new Test();

//        int[][] test = {{2,1,50459},{3,2,47477},{4,2,52585},{5,3,16477}};
//        int[][] test = {{2,1,50459}};
        int[][] test2 = {{1,2,5},{1,3,6},{2,3,1}};

//        int[][] test = {{2,1,50459}};
        System.out.println();


    }
}
