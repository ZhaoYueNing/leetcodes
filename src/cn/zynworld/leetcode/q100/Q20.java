package cn.zynworld.leetcode.q100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhaoyuening
 */
public class Q20 {

    private static final Map<Character,Character> CHAR_MAP = new HashMap<Character, Character>(){{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (CHAR_MAP.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != CHAR_MAP.get(c)) {
                    return false;
                }
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
