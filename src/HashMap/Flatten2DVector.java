package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Flatten2DVector {
	Queue<Integer> queue;
	public Flatten2DVector(List<List<Integer>> vec2d) {
		// Initialize your data structure here
		this.queue = new LinkedList<Integer>();
		for (int i = 0; i < vec2d.size(); i++) {
			this.queue.addAll(vec2d.get(i));
		}
	}

	public Integer next() {
		// Write your code here
		return this.queue.poll();
	}

	public boolean hasNext() {
		// Write your code here
		return this.queue.isEmpty();
	}

	public void remove() {
		this.queue.poll();
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);

		List<Integer> list2 = new ArrayList<>();
		list2.add(3);

		List<Integer> list3 = new ArrayList<>();
		list3.add(4);
		list3.add(5);
		list3.add(6);

		list.add(list1);
		list.add(list2);
		list.add(list3);

		Flatten2DVector test = new Flatten2DVector(list);
		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.next());

	}
}
