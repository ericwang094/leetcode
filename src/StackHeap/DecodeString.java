package StackHeap;

import java.util.Stack;

public class DecodeString {
	/**
	 * @param s: an expression includes numbers, letters and brackets
	 * @return: a string
	 */
	public String expressionExpand(String s) {
		Stack<Object> stack = new Stack<>();
		int num = 0;

		char[] cArray = s.toCharArray();
		for (int i = 0; i < cArray.length; i++) {
			char c = cArray[i];
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			} else if (c == '[') {
				stack.add(num);
				num = 0;
			} else if (c == ']') {
				String str = popString(stack);
				Integer repeat = (Integer) stack.pop();
				for (int j = 0; j < repeat; j++) {
					stack.push(str);
				}
			} else {
				stack.add(String.valueOf(c));
			}
		}

		return popString(stack);
	}

	private String popString(Stack<Object> stack) {
		Stack<String> temp = new Stack<>();
		while (!stack.isEmpty() && stack.peek() instanceof String) {
			temp.add(String.valueOf(stack.pop()));
		}

		StringBuffer sb = new StringBuffer();
		while (!temp.isEmpty()) {
			sb.append(temp.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		String input = "abc3[a]";
		ds.expressionExpand(input);
	}
}
