package cn.zynworld.leetcode.q100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoyuening
 */
public class Q62 {
    public int uniquePaths(int m, int n) {
        Map<String, Integer> cache = new HashMap<>();
        cache.put("1-1", 1);
        return handle(m, n, cache);
    }

    public int handle(int m, int n, Map<String, Integer> cache) {
        String key = m + "-" + n;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int result = 0;
        if (m > 1) result += handle(m - 1, n, cache);
        if (n > 1) result += handle(m, n - 1, cache);
        cache.put(key, result);
        return result;
    }

    public static void main(String[] args) {
//        Q62 q62 = new Q62();
//        int i = q62.uniquePaths(3, 2);
//        System.out.println(i);
        char c = 1;
        System.out.println(c);

    }
}
