package cn.zynworld.leetcode.q100;

import cn.zynworld.leetcode.common.ListNode;
import cn.zynworld.leetcode.common.Node;

import java.util.*;

/**
 * @author zhaoyuening
 *
 */
public class KmovieWordUtils {
    public static int jump(int[] nums) {
        return jump(nums, 0, new HashMap<>());
    }

    public static int jump(int[] nums, int index, Map<Integer, Integer> cacheMap) {
        final int LAST_INDEX = nums.length - 1;
        final int CUR_DISTANCE = nums[index];
        if (cacheMap.containsKey(index)) {
            return cacheMap.get(index);
        }
        if (LAST_INDEX == index) {
            cacheMap.put(index, 0);
            return 0;
        }
        if (CUR_DISTANCE + index >= LAST_INDEX) {
            cacheMap.put(index, 1);
            return 1;
        }
        if (CUR_DISTANCE == 0) {
            cacheMap.put(index, Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }

        int curMinCount = Integer.MAX_VALUE;
        for (int i = 1; i <= CUR_DISTANCE; i++) {
            curMinCount = Math.min(curMinCount, jump(nums, index + i, cacheMap));
        }

        if (curMinCount < Integer.MAX_VALUE) {
            curMinCount++;
        }

        cacheMap.put(index, curMinCount);
        return curMinCount;
    }

    public static void main(String[] args) {
    }
}
