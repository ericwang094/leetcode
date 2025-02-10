package msb.CommonDataStructure;

import java.util.List;

public class Node {
    public int val;
    public List<Node> nexts;
    public int in = 0;
    public int out = 0;

    public Node(int val) {
        this.val = val;
    }
}
