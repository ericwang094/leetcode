package UnionFind;

import javax.naming.spi.DirStateFactory;
import java.util.*;

public class ConnectedSet2 {
	/*
	 * @param nodes: a array of Directed graph node
	 * @return: a connected set of a directed graph
	 */
	public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
		List<List<Integer>> result = new ArrayList<>();
		if (nodes == null || nodes.size() == 0) {
			return result;
		}
		// write your code here
		Map<DirectedGraphNode, Integer> map = new HashMap<>();

		Set<DirectedGraphNode> set = new HashSet<>();

		UnionFind uf = new UnionFind(nodes.size());
		for (int i = 0; i < nodes.size(); i++) {
			DirectedGraphNode node = nodes.get(i);
			if(!map.containsKey(node)) {
				map.put(node, i);
			}
			for (int j = 0; j < node.neighbors.size(); j++) {
				DirectedGraphNode neighbor = node.neighbors.get(j);
				if (!map.containsKey(neighbor)) {
					map.put(neighbor, i);
				}
				uf.connect(map.get(node), map.get(neighbor));
			}
		}

		Map<Integer, List<DirectedGraphNode>> topFatherToList = new HashMap<>();
		for (int i = 0; i < nodes.size(); i++) {
			int topFather = uf.find(map.get(nodes.get(i)));
			topFatherToList.putIfAbsent(topFather, new ArrayList<>());
			topFatherToList.get(topFather).add(nodes.get(i));
			for (DirectedGraphNode neighbor : nodes.get(i).neighbors) {
				topFather = uf.find(map.get(neighbor));
				topFatherToList.putIfAbsent(topFather, new ArrayList<>());
				topFatherToList.get(topFather).add(neighbor);
			}
		}

		for (List<DirectedGraphNode> list : topFatherToList.values()) {
			List<Integer> subList = new ArrayList<>();
			for (DirectedGraphNode node : list) {
				if (set.contains(node)) {
					continue;
				}
				set.add(node);
				subList.add(node.label);
			}
			Collections.sort(subList);
			result.add(subList);
		}
		return result;
	}

	private class UnionFind {
		int[] f;

		public UnionFind (int size) {
			f = new int[size];
			for (int i = 0; i <= f.length; i++) {
				f[i] = i;
			}
		}

		private boolean connect(int a, int b) {
			int fatherA = find(a);
			int fatherB = find(b);
			if (fatherA != fatherB) {
				f[fatherA] = fatherB;
				return false;
			}

			return true;
		}

		private int find(int a) {
			int father = f[a];
			while (father != f[father]) {
				father = f[father];
			}

			while (a != father) {
				int temp = f[a];
				f[a] = father;
				a = temp;
			}

			return father;
		}
	}

	private class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;

		DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<DirectedGraphNode>();
		}
	}
}
