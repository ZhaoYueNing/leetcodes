package cn.zynworld.leetcode.Q1000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaoyuening
 */
public class Q1248 {
    public static int numberOfSubarrays(int[] nums, int k) {
        // 统计奇数左侧有多少个非奇数排列数
        List<Integer> counter = new ArrayList<>();
        // 上一个奇数位置
        int prevNumIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) continue;
            counter.add(i - prevNumIndex);
            prevNumIndex = i;
        }

        // 如果奇数个数小于k 返回0
        if (counter.size() < k) {
            return 0;
        }

        // 统计最后一个奇数右侧非奇数个数
        counter.add(nums.length - prevNumIndex);

        int totalCounter = 0;
        for (int i = 0, j = k; j < counter.size(); i++, j++) {
            totalCounter += counter.get(i) * counter.get(j);
        }

        return totalCounter;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,1,1};
        int result = numberOfSubarrays(arr, 3);
        System.out.println(result);
    }
}
