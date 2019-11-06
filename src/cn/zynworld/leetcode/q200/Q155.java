package cn.zynworld.leetcode.q200;

import java.util.Stack;

/**
 * @author zhaoyuening
 */
public class Q155 {

    static class MinStack {

        private final Stack<Integer> DATA_STACK = new Stack<>();
        private final Stack<Integer> MIN_STACK = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if (MIN_STACK.isEmpty() || x <= MIN_STACK.peek()) {
                MIN_STACK.push(x);
            }
            DATA_STACK.push(x);
        }

        public void pop() {
            if (!MIN_STACK.isEmpty() && MIN_STACK.peek().equals(DATA_STACK.peek())) {
                MIN_STACK.pop();
            }
            DATA_STACK.pop();
        }

        public int top() {
            return DATA_STACK.peek();
        }

        public int getMin() {
            return MIN_STACK.peek();
        }
    }

    public static void main(String[] args) {

    }
}
