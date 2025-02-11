package msb.CommonDataStructure;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> nexts;
    public ArrayList<Edge> edges;
    public int in = 0;
    public int out = 0;

    public Node(int val) {
        this.val = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
