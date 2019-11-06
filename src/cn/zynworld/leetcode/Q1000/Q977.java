package cn.zynworld.leetcode.Q1000;

/**
 * @author zhaoyuening
 */
public class Q977 {

    // 双指针解法 时间复杂度 O(N)
    public int[] sortedSquares(int[] A) {
        // 对所有数字求平方
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }

        int[] resultArr = new int[A.length];
        int leftIndex = 0;
        int rightIndex = A.length - 1;

        for (int i = rightIndex; i >= 0; i--) {
            if (A[rightIndex] >= A[leftIndex]) {
                resultArr[i] = A[rightIndex];
                rightIndex--;
                continue;
            }

            resultArr[i] = A[leftIndex];
            leftIndex++;
        }

        return resultArr;
    }
}
