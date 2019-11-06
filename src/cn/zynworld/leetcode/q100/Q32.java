package cn.zynworld.leetcode.q100;

import java.util.Stack;

/**
 * @author zhaoyuening
 */
public class Q32 {
    public static int longestValidParentheses(String s) {
        Integer maxResult = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j < s.length(); j++) {
                if (j - i > maxResult && check(s.substring(i, j))) {
                    maxResult = j - i;
                }
            }
        }

        return maxResult;
    }


    public static int longestValidParentheses2(String s) {
        Integer maxResult = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = i; j < s.length(); j++) {
                char c = chars[j];
                if (c == '(') stack.add(c);
                if (c == ')' && stack.isEmpty()) break;
                if (c == ')') stack.pop();
                if (stack.isEmpty()) maxResult = Math.max(maxResult, j - i + 1);
            }
        }

        return maxResult;
    }


    private static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') stack.add(c);
            if (c == ')' && stack.isEmpty()) return false;
            if (c == ')') stack.pop();
        }

        return stack.isEmpty();
    }

    public int longestValidParentheses3(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length -1, -1, -1, ')'));
    }
    private static int calc(char[] chars , int i ,  int flag,int end, char cTem){
        int max = 0, sum = 0, currLen = 0,validLen = 0;
        for (;i != end; i += flag) {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen ++;
            if(sum < 0){
                max = max > validLen ? max : validLen;
                sum = 0;
                currLen = 0;
                validLen = 0;
            }else if(sum == 0){
                validLen = currLen;
            }
        }
        return max > validLen ? max : validLen;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses2(s));
    }
}
