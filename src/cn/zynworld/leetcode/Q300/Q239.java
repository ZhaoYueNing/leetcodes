package cn.zynworld.leetcode.Q300;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhaoyuening
 */
public class Q239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {


        // 统计最大结果数组
        int[] MAX_ARR = new int[nums.length - k + 1];
        // 定义双端队列
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0,maxIndex = 0; i < nums.length; i++) {
            int num = nums[i];
            // 滑动窗口左侧滑出
            if (!list.isEmpty() && i >= k && nums[i - k] == list.getFirst()) {
                list.removeFirst();
            }

            // 弹出双端队列比自己小的元素
            while (!list.isEmpty() && list.getLast() < num) {
                list.removeLast();
            }

            // 将元素填充
            list.add(num);

            // 得到最大值
            if (!list.isEmpty() && i >= k - 1) {
                MAX_ARR[maxIndex] = list.getFirst();
                maxIndex++;
            }
        }

        return MAX_ARR;
    }

    public static void main(String[] args) {
        int[] result = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(result);
    }
}
