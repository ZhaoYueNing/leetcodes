package cn.zynworld.leetcode.q100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhaoyuening
 */
public class Q17_2 {
    private static final String[] NUMBER_WORD_ARR = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        Set<String> currentWords = new HashSet<>();
        currentWords.add("");

        for (char c : digits.toCharArray()) {
            Set<String> newWords = new HashSet<>();
            String words = NUMBER_WORD_ARR[c - '0'];
            for (char ch : words.toCharArray()) {
                newWords.addAll(currentWords.stream().map(s -> s + ch).collect(Collectors.toSet()));
            }
            currentWords = newWords;
        }

        return currentWords.stream().collect(Collectors.toList());
    }
}
