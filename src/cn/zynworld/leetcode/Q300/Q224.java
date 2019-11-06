package cn.zynworld.leetcode.Q300;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaoyuening
 */
public class Q224 {

    public static Integer calculate(String calString) {
        // 转为后缀表达式
        List<String> cals = convert(calString);

        Stack<Integer> numberStack = new Stack<>();
        for (int i = 0; i < cals.size(); i++) {
            String s = cals.get(i);
            // 如果是数字
            if (isNumberString(s)) {
                numberStack.add(Integer.parseInt(s));
                continue;
            }

            // 如果是符号
            // 进行四则运算
            Integer b = numberStack.pop();
            Integer a = numberStack.pop();
            switch (s.charAt(0)) {
                case '+':
                    numberStack.add(a + b);
                    break;
                case '-':
                    numberStack.add(a - b);
                    break;
                case '*':
                    numberStack.add(a * b);
                    break;
                case '/':
                    numberStack.add(a / b);
                    break;
            }
        }

        return numberStack.pop();
    }

    private static boolean isNumberChar(char c) {
        if ((c - '0' <= 9 && c - '0' >= 0) || c == '.') {
            return true;
        }
        return false;
    }

    private static boolean isNumberString(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!isNumberChar(c)) return false;
        }
        return true;
    }

    /**
     * 将中缀表达式转化为后缀表达式
     * @param calString
     * @return
     */
    private static List<String> convert(String calString) {
        List<String> cals = new ArrayList<>();

        char[] chars = calString.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 如果是数字
            if (isNumberChar(c)) {
                Integer lastIndex = i + 1;
                while (lastIndex < chars.length && isNumberChar(chars[lastIndex])) lastIndex++;
                cals.add(new String(chars, i, lastIndex - i));
                i = lastIndex - 1;
                continue;
            }

            if (c == ' ') {
                continue;
            }
            // 如果是 (
            if (c == '(') {
                stack.add(c);
                continue;
            }

            // 如果是 )
            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    cals.add(stack.pop().toString());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                continue;
            }

            // 如果是其他类型符号
            Integer charLevel = charLevel(c);
            // 将优先级高于当前字符的弹出
            while (!stack.isEmpty() && charLevel <= charLevel(stack.peek())) {
                cals.add(stack.pop().toString());
            }
            stack.add(c);
        }

        while (!stack.isEmpty()) {
            cals.add(stack.pop().toString());
        }

        return cals;
    }

    private static Integer charLevel(char c) {
        switch (c) {
            case '*':
            case '/':
                return 3;
            case '+':
            case '-':
                return 2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String calString = "2*3-4*5";
        System.out.println(calculate(calString));
    }
}
