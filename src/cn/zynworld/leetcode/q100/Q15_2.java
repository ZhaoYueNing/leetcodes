package cn.zynworld.leetcode.q100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhaoyuening
 */
public class Q15_2 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        List<Integer> numList = arrayToListAndSort(nums);
        for (int i = 0; i + 2 < numList.size(); i++) {
            Integer num = numList.get(i);
            if (i - 1 >= 0 && numList.get(i - 1).equals(num)) {
                continue;
            }
            if (num > 0) break;

            for (Integer lIndex = i+1,rIndex = nums.length - 1; lIndex < rIndex;) {
                Integer sum = numList.get(lIndex) + numList.get(rIndex) + num;
                if (sum == 0) {
                    // 去重复
                    while (lIndex + 1 < rIndex && numList.get(lIndex).equals(numList.get(lIndex + 1))) lIndex++;
                    while (rIndex - 1 > lIndex && numList.get(rIndex).equals(numList.get(rIndex - 1))) rIndex--;

                    List<Integer> result = new ArrayList<>();
                    result.add(numList.get(i));
                    result.add(numList.get(lIndex));
                    result.add(numList.get(rIndex));
                    results.add(result);
                    lIndex++;
                    rIndex--;
                }

                if (sum > 0) {
                    rIndex --;
                    continue;
                }

                if (sum < 0) {
                    lIndex++;
                }
            }
        }

        return results;

    }

    private static List<Integer> arrayToListAndSort(int[] nums) {
        // 全部加入到 list 中
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) numList.add(num);
        numList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        return numList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};
        List<List<Integer>> results = threeSum(nums);
        System.out.println(results);
    }
}
