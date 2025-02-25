package msb;

import java.util.Stack;

public class ReverseStack_9_139 {

    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }
}
