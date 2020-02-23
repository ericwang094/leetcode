package HashMap;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	private Queue<Integer> currentQueue = q1;
	/*
	 * @param x: An integer
	 * @return: nothing
	 */
	public void push(int x) {
		// write your code here
		currentQueue.add(x);
	}

	/*
	 * @return: nothing
	 */
	public void pop() {
		// write your code here
		Queue<Integer> toQueue = currentQueue == q1 ? q2 : q1;
		currentQueue.poll();
		for (int i = 0; i < currentQueue.size(); i++) {
			toQueue.add(currentQueue.poll());
		}

		swapCurrentQueue();
	}

	/*
	 * @return: An integer
	 */
	public int top() {
		// write your code here
		Queue<Integer> toQueue = currentQueue == q1 ? q2 : q1;
		int val = currentQueue.poll();
		toQueue.add(val);
		for (int i = 0; i < currentQueue.size(); i++) {
			toQueue.add(currentQueue.poll());
		}


		swapCurrentQueue();
		return val;
	}

	/*
	 * @return: True if the stack is empty
	 */
	public boolean isEmpty() {
		// write your code here
		if (currentQueue.isEmpty()) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		return currentQueue.isEmpty();
	}

	private void swapCurrentQueue() {
		if (currentQueue == q1) {
			currentQueue = q2;
		} else {
			currentQueue = q1;
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
//		stack.pop();
		stack.push(2);
//		stack.isEmpty();
		stack.pop();
		stack.top();
//		stack.isEmpty();
	}
}
