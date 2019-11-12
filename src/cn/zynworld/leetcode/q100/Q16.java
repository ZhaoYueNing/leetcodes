package cn.zynworld.leetcode.q100;

import java.util.Arrays;

/**
 * @author zhaoyuening
 */
public class Q16 {
    public static int threeSumClosest(int[] nums, int target) {
        int nearestSum = nums[0] + nums[1] + nums[2];

        // 对数组排序
        Arrays.sort(nums);

        // 以 i 为基准
        for (int i = 0; i + 2 < nums.length; i++) {
            // 定义 i 后的首位下标
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;

            // 若已经小于当前最小没有必要继续计算
            int curMinSum = nums[i] + nums[leftIndex] + nums[leftIndex + 1];
            if (target < curMinSum) {
                nearestSum = getNearestSum(nearestSum, curMinSum, target);
                continue;
            }

            int curMaxSum = nums[i] + nums[rightIndex] + nums[rightIndex - 1];
            if (target > curMaxSum) {
                nearestSum = getNearestSum(nearestSum, curMaxSum, target);
                continue;
            }

            // 通过对比差值大小决定下标的左右移动方向
            while (leftIndex < rightIndex) {
                int curSum = nums[i] + nums[leftIndex] + nums[rightIndex];

                nearestSum = getNearestSum(nearestSum, curSum, target);
                // 尾指针左移
                if (curSum > target){
                    rightIndex --;
                    continue;
                }
                // 首指针右移
                if (curSum < target) {
                    leftIndex++;
                    continue;
                }
                break;
            }

            // 对基准i去重复
            while (i + 3 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        return nearestSum;
    }

    private static int getNearestSum(int oldNearestSum, int curSum, int target) {
        int oldGap = Math.abs(oldNearestSum - target);
        int newGap = Math.abs(curSum - target);
        return newGap < oldGap ? curSum : oldNearestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};
        int result = threeSumClosest(nums, 0);
        System.out.println(result);
    }
}
