package leetcode.BFS;

import java.util.*;

public class L0133_CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        ArrayList<UndirectedGraphNode> allNodes = this.getNodes(node);
        for (UndirectedGraphNode currentNode : allNodes) {
            map.put(currentNode, new UndirectedGraphNode(currentNode.label));
        }

        for (UndirectedGraphNode currentNode: allNodes) {
            UndirectedGraphNode newNode = map.get(currentNode);
            for (UndirectedGraphNode neighbor : newNode.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> nodes = new LinkedList<>();
        Set<UndirectedGraphNode> nodeSet = new HashSet<>();

        nodes.offer(node);
        nodeSet.add(node);
        while (!nodes.isEmpty()) {
            UndirectedGraphNode currentNode = nodes.poll();
            for (UndirectedGraphNode neighbor : currentNode.neighbors) {
                if (nodeSet.contains(neighbor)) {
                    continue;
                }

                nodeSet.add(neighbor);
                nodes.offer(neighbor);
            }
        }

        return new ArrayList<UndirectedGraphNode>(nodeSet);
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
