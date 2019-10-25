package cn.zynworld.leetcode.q400;

/**
 * @author zhaoyuening
 * @see <a href="https://leetcode-cn.com/problems/bulb-switcher/">q319</a>
 */
public class Q319 {
    public static int bulbSwitch(int n) {
        // 用二进制来表示灯的开关
        // 开始所有的灯关闭
        Long number = 0L;

        // 异或数
        Long xor = (long) Math.pow(2, n) - 1;
        // 记录当前异或值为最大值
        final Long MAX_XOR = xor;

        for (int i = 0; i < n; i++) {
            // 计算当前轮次异或值
            xor = getCurrentXor(i, MAX_XOR);
            number ^= xor;
        }

        // 计算当前灯亮数量
        int result = 0;
        for (long tmp = 1; tmp <= MAX_XOR; tmp*=2) {
            result += (tmp & number) == 0 ? 0 : 1;
        }

        return result;
    }

    public static int f(int n) {
        if (n == 0) {
            return 0;
        }
        int val = 1;
        int i = 1;
        int cur = 3;
        while (true) {
            i += cur;
            cur += 2;
            if (i > n) {
                break;
            }
            val++;
        }
        return val;
    }

    private static Long getCurrentXor(Integer n, final Long MAX_XOR) {
        Long xor = 0L;
        long position = 0;
        while (true) {
            Long tmp = (long) Math.pow(2, position + (position + 1) * n);
            if (xor + tmp > MAX_XOR) {
                return xor;
            }
            xor += tmp;
            position ++;
        }
    }

    public static void main(String[] args) {
        int f = f(9);
        System.out.println(f);
    }
}
