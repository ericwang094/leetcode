package msb;

import msb.CommonDataStructure.Node;

import java.util.HashSet;
import java.util.Stack;

public class GraphDFS_7_52 {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node n : cur.nexts) {
                if (set.contains(cur)) {
                    continue;
                }
                stack.push(cur);
                stack.push(n);
                set.add(n);
                break;
            }
        }
    }
}
