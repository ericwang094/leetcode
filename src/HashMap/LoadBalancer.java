package HashMap;

import java.util.*;

public class LoadBalancer {
//	List<Integer> list;
//	Map<Integer, Integer> idToIndex;
//	Random rand;
//	public LoadBalancer() {
//		// do intialization if necessary
//		this.list = new ArrayList<>();
//		this.idToIndex = new HashMap<>();
//		this.rand = new Random();
//	}
//
//	/*
//	 * @param server_id: add a new server to the cluster
//	 * @return: nothing
//	 */
//	public void add(int server_id) {
//		// write your code here
//		if (idToIndex.containsKey(server_id)) {
//			return;
//		}
//		list.add(server_id);
//		idToIndex.put(server_id, list.size() - 1);
//	}
//
//	/*
//	 * @param server_id: server_id remove a bad server from the cluster
//	 * @return: nothing
//	 */
//	public void remove(int server_id) {
//		// write your code here
//		if (!idToIndex.containsKey(server_id)) {
//			return;
//		}
//		// remove server id
//		int currentServerIndex = idToIndex.get(server_id);
//		idToIndex.remove(server_id);
//
//		// shift last ele to current one
//		int lastEle = list.get(list.size() - 1);
//		idToIndex.remove(lastEle);
//
//		list.set(currentServerIndex, lastEle);
//		idToIndex.put(lastEle, currentServerIndex);
//	}
//
//	/*
//	 * @return: pick a server in the cluster randomly with equal probability
//	 */
//	public int pick() {
//		// write your code here
//		return list.get(rand.nextInt(list.size()));
//	}

	List<Integer> list;
	Map<Integer, Integer> numToIndex;

	public LoadBalancer() {
		// do intialization if necessary
		list = new ArrayList<>();
		numToIndex = new HashMap<Integer, Integer>();

	}

	/*
	 * @param server_id: add a new server to the cluster
	 * @return: nothing
	 */
	public void add(int server_id) {
		// write your code here
		numToIndex.put(list.size(), server_id);
		list.add(server_id);
	}

	/*
	 * @param server_id: server_id remove a bad server from the cluster
	 * @return: nothing
	 */
	public void remove(int server_id) {
		// write your code here
		int index = numToIndex.get(server_id);
		numToIndex.remove(server_id);

		if (index != list.size() - 1) {
			// get last element
			int lastEle = list.get(list.size() - 1);
			numToIndex.put(index, lastEle);
			list.set(index, lastEle);
		}

		list.remove(list.size() - 1);
	}

	/*
	 * @return: pick a server in the cluster randomly with equal probability
	 */
	public int pick() {
		// write your code here
		Random r = new Random();
		int m = list.size();
		int index = Math.abs(r.nextInt()) % m;
		return list.get(index);
	}
}
