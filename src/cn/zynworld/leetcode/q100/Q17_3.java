package cn.zynworld.leetcode.q100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoyuening
 */
public class Q17_3 {
    private static final Map<String,String> phone = new HashMap<String,String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        backtrack("", digits, result);
        return result;
    }

    private static void backtrack(String combination, String next_digits,List<String> result) {
        if (next_digits.length() == 0) {
            result.add(combination);
            return ;
        }

        char[] chars = phone.get(next_digits.substring(0, 1)).toCharArray();
        next_digits = next_digits.substring(1);
        for (char c : chars) {
            counter++;
            backtrack(combination + c, next_digits,result);
        }
        return ;
    }


    private static Integer counter = 0;
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(counter);
    }
}
