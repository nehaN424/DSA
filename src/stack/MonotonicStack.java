package stack;

import java.util.Stack;

public class MonotonicStack {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 12, 10};
        Stack<Integer> stack = increasingStack(arr);
        System.out.println(stack);
    }

    public static Stack<Integer> increasingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int j : arr) {
            while (!stack.isEmpty() && j < stack.peek()) {
                stack.pop();
            }
            stack.push(j);
        }
        return stack;
    }
}
