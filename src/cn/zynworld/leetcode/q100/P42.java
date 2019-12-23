package cn.zynworld.leetcode.q100;

/**
 * @author zhaoyuening
 *
 */
public class P42 {
    public static int trap(int[] height) {
        // 统计数量
        int amount = 0;

        // 用于统计左侧最大高度
        int[] leftMaxHeightArr = new int[height.length];
        int curLeftMaxHeightValue = 0;
        for (int i = 0; i < leftMaxHeightArr.length; i++) {
            leftMaxHeightArr[i] = curLeftMaxHeightValue;
            curLeftMaxHeightValue = Math.max(curLeftMaxHeightValue, height[i]);
        }

        // 从右侧向左统计右侧最大高度
        int curRightMaxHeight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            // 左侧最大与右侧最大中的最小值为当前位置的可积累数量
            amount += Math.max(Math.min(leftMaxHeightArr[i], curRightMaxHeight) - height[i], 0);
            curRightMaxHeight = Math.max(curRightMaxHeight, height[i]);
        }

        return amount;
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arrs));
        assert trap(arrs) == 6;
    }
}
