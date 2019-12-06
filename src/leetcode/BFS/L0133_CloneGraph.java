package leetcode.BFS;

import java.util.*;

public class L0133_CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);

        Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        // copy neighbors
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapping.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return new ArrayList<UndirectedGraphNode>(set);
    }



    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraphV2(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        ArrayList<UndirectedGraphNode> nodeList = new ArrayList<>();
        nodeList.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        int index = 0;
        while (index < nodeList.size()) {
            UndirectedGraphNode currentNode = nodeList.get(index++);
//            for (UndirectedGraphNode neighbor : currentNode.neighbors) {
            for (int i = 0; i < currentNode.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = currentNode.neighbors.get(i);
//                UndirectedGraphNode currentNeighbor = currentNode.neighbors.get(i);
                if (map.containsKey(neighbor)) {
                    continue;
                }
                map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                nodeList.add(neighbor);
            }
        }

//        for (UndirectedGraphNode graphNode : nodeList) {
//            UndirectedGraphNode newNode = map.get(graphNode);
//            for (UndirectedGraphNode neighbor : graphNode.neighbors) {
//                newNode.neighbors.add(map.get(neighbor));
//            }
//        }

        for (int i = 0; i < nodeList.size(); i++) {
            UndirectedGraphNode newNode = map.get(nodeList.get(i));
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(nodeList.get(i).neighbors.get(j)));
            }
        }

        return map.get(node);
    }

    class StackElement {
        public UndirectedGraphNode node;
        public int neighborIndex;
        public StackElement(UndirectedGraphNode node, int neighborIndex) {
            this.node = node;
            this.neighborIndex = neighborIndex;
        }
    }
    private ArrayList<UndirectedGraphNode> getNodesWithStack(UndirectedGraphNode node) {
        Stack<StackElement> stack = new Stack<StackElement>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();

        stack.push(new StackElement(node, -1));
        set.add(node);
        while (!stack.isEmpty()) {
            StackElement currentNode = stack.peek();
            currentNode.neighborIndex++;
            if (currentNode.neighborIndex == currentNode.node.neighbors.size()) {
                stack.pop();
                continue;
            }

            UndirectedGraphNode neighbor = currentNode.node.neighbors.get(currentNode.neighborIndex);
            if (set.contains(neighbor)) {
                continue;
            }

            stack.push(new StackElement(neighbor, -1));
            set.add(neighbor);
        }

        return new ArrayList<UndirectedGraphNode>(set);
    }
}
