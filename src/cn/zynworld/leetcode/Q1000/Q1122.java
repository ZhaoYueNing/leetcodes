package cn.zynworld.leetcode.Q1000;

import java.util.*;

/**
 * @author zhaoyuening
 */
public class Q1122 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> rankWeightMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            rankWeightMap.put(arr2[i], i);
        }

        // sort
        for (int i = 0; i < arr1.length; i++) {
            for (int k = i + 1; k < arr1.length; k++) {
                int a = getRankWeight(rankWeightMap, arr1[i]);
                int b = getRankWeight(rankWeightMap, arr1[k]);
                if (b < a) {
                    int tmp = arr1[i];
                    arr1[i] = arr1[k];
                    arr1[k] = tmp;
                }
            }
        }

        return arr1;
    }

    private static int getRankWeight(Map<Integer, Integer> rankWeightMap,Integer num) {
        if (rankWeightMap.containsKey(num)) {
            return rankWeightMap.get(num);
        }

        return num + 1000;
    }
}
