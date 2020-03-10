package StackHeap;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	int min;
	public MinStack() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
		min = Integer.MAX_VALUE;
	}
	/*
	 * @param number: An integer
	 * @return: nothing
	 */
	public void push(int number) {
		// write your code here
		min = Math.min(number, min);
		stack1.add(number);
		stack2.add(min);
	}

	/*
	 * @return: An integer
	 */
	public int pop() {
		// write your code here
		stack2.pop();
		if (stack2.isEmpty()) {
			min = Integer.MAX_VALUE;
		} else {
			min = stack2.peek();
		}
		return stack1.pop();
	}

	/*
	 * @return: An integer
	 */
	public int min() {
		// write your code here
		return stack2.peek();
	}
}
