package HashMap;

import java.util.Stack;

public class DecodeString {
	public String expressionExpand(String s) {

		if (s == null || s.length() == 0) {
			return s;
		}
		String result = "";
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			String cur = s.substring(i, i + 1);
			if (cur.equals("]")) {
				StringBuilder sb = new StringBuilder();
				while (!stack.isEmpty() && !stack.peek().equals("[")) {
					sb.append(stack.pop());
				}
				// remove [
				if (!stack.isEmpty()) {
					stack.pop();
				}
				String tempString = sb.toString();

				// get number
				String reverseRepeat = "";

				while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
					reverseRepeat += stack.pop();
				}

				int repeat = 0;
				for (int j = reverseRepeat.length() - 1; j >= 0; j-- ){
					repeat = repeat * 10 + Character.getNumericValue(reverseRepeat.charAt(j));
				}

				if (repeat == 0) {
					continue;
				}

				sb = new StringBuilder();
				for (int j = 0; j < repeat; j++ ) {
					sb.append(tempString);
				}

				stack.add(sb.toString());

			}else {
				stack.add(cur);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
//		return result;

	}

	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
//		ds.expressionExpand("2[0[ab]5[0[abc]xy]uw]1[k]7[17[5[a]bcd]eok]1[haha]2[heihie]4[nihao]3[12[bc]4[t]]");
		ds.expressionExpand("2[5[xy]]");
//		ds.expressionExpand("abc3[a]");
	}
}


