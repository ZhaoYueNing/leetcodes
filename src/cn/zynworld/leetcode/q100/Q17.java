package cn.zynworld.leetcode.q100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaoyuening
 */
public class Q17 {
    // 保存数字与字母的映射关系
    private static final String[] NUMBER_WORD_ARR = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<String, Set<String>> dp = new HashMap<>();

        // 将2-9初始数字映射到 dp
        for (Integer i = 2; i <= 9; i++) {
            String words = NUMBER_WORD_ARR[i];
            char[] wordChars = words.toCharArray();
            for (Character wordChar : wordChars) {
                //counter++;
                Set<String> wordSet = dp.computeIfAbsent(i.toString(), num -> new HashSet<>());
                wordSet.add(wordChar.toString());
            }
        }

        for (Integer i = 1; i < digits.length(); i++) {
            // 当前下标所生成的words集合
            Set<String> wordSet = new HashSet<>();

            // 前一个下标的word集合
            Set<String> prevWordSet = dp.get(digits.substring(0, i));

            // 得到当前数字的字符
            String words = NUMBER_WORD_ARR[digits.charAt(i) - '0'];
            for (char c :words.toCharArray()){
                counter++;
                wordSet.addAll(prevWordSet.stream().map(s -> s + c).collect(Collectors.toSet()));
            }

            dp.put(digits.substring(0, i + 1), wordSet);
        }

        return dp.get(digits).stream().collect(Collectors.toList());
    }

    private static Integer counter = 0;
    public static void main(String[] args) {
        // "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
        System.out.println(counter);
    }
}
