package cn.zynworld.leetcode.q100;

/**
 * @author zhaoyuening
 */
public class Q53 {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int maxResult = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum = Math.max(0, currentSum) + num;
            maxResult = Math.max(currentSum, maxResult);
        }

        return maxResult;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1};
        int result = maxSubArray(nums);
        System.out.println(result);
    }
}
