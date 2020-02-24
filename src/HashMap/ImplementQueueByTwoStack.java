package HashMap;

import java.util.Stack;

public class ImplementQueueByTwoStack {
	private Stack<Integer> s1;
	private Stack<Integer> s2;

	public ImplementQueueByTwoStack() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	private void switchStack() {
		while(!s2.isEmpty()) {
			s1.add(s2.pop());
		}
	}

	/*
	 * @param element: An integer
	 * @return: nothing
	 */
	public void push(int element) {
		s1.add(element);
	}

	/*
	 * @return: An integer
	 */
	public int pop() {
		// write your code here
		while(s1.size() != 1) {
			s2.add(s1.pop());
		}
		int val = s1.pop();
		switchStack();

		return val;
	}

	/*
	 * @return: An integer
	 */
	public int top() {
		// write your code here
		while(s1.size() != 1) {
			s2.add(s1.pop());
		}
		int val = s1.pop();
		s2.add(val);
		switchStack();

		return val;
	}
}
