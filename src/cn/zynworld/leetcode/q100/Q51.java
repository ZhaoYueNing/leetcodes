package cn.zynworld.leetcode.q100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhaoyuening
 */
public class Q51 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<List<Integer>> handleResult = handle(n, 0, new ArrayList<>(), new HashSet<>());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(".");
        }

        // 将结果转换为字符
        for (List<Integer> list : handleResult) {
            List<String> strings = new ArrayList<>();
            for (Integer rIndex : list) {
                StringBuilder builder = new StringBuilder(stringBuilder.toString());
                builder.replace(rIndex, rIndex + 1, "Q");
                strings.add(builder.toString());
            }
            result.add(strings);
        }

        return result;
    }

    public static List<List<Integer>> handle(Integer n, Integer cIndex, List<Integer> currentSelectedPosition, Set<String> filteredPosition) {
        List<List<Integer>> result = new ArrayList<>();

        if (cIndex >= n) {
            result.add(currentSelectedPosition);
            return result;
        }

        for (int rIndex = 0; rIndex < n; rIndex++) {
            if (filteredPosition.contains(getKey(cIndex, rIndex))) {
                continue;
            }

            // 该位置可以放置
            List<Integer> nextSelectedPosition = new ArrayList<>(currentSelectedPosition);
            nextSelectedPosition.add(rIndex);
            Set<String> nextFilteredPosition = fillFilteredPosition(cIndex, rIndex, n, filteredPosition);
            List<List<Integer>> selectResult = handle(n, cIndex + 1, nextSelectedPosition, nextFilteredPosition);
            result.addAll(selectResult);
        }

        return result;
    }

    private static Set<String> fillFilteredPosition(Integer cIndex, Integer rIndex,Integer n, Set<String> filteredPosition) {
        filteredPosition = new HashSet<>(filteredPosition);

        // 该行全过滤
        for (Integer c = cIndex + 1; c < n; c++) {
            filteredPosition.add(getKey(c, rIndex));
        }

        // 向右上的斜对角
        for (Integer i = 1; cIndex + i < n && rIndex + i < n; i++) {
            filteredPosition.add(getKey(cIndex + i, rIndex + i));
        }

        // 向右下斜对角
        for (Integer i = 1; cIndex + i < n && rIndex - i >= 0; i++) {
            filteredPosition.add(getKey(cIndex + i, rIndex - i));
        }

        return filteredPosition;
    }

    private static String getKey(int cIndex, Integer rIndex) {
        return cIndex + "-" + rIndex;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(20);
        System.out.println(lists);
    }


}
