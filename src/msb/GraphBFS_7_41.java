package msb;

import msb.CommonDataStructure.Node;

import java.util.*;

public class GraphBFS_7_41 {

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        Set<Node> set = new HashSet<>();

        q.add(node);
        set.add(node);

        while(!q.isEmpty()) {
            Node cur = q.poll();
            for (Node n : cur.nexts) {
                if (set.contains(n)) {
                    continue;
                }

                q.add(n);
                set.add(n);
            }
        }
    }
}
