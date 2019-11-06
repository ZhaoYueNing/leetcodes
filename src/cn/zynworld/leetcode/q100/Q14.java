package cn.zynworld.leetcode.q100;

/**
 * @author zhaoyuening
 * 最长公共子串
 */
public class Q14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        // 最长公共前缀的长度
        int len = 0;
        String firstString = strs[0];
        Integer currentMaxEqualLen = firstString.length();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int currentCount = 0;
            for (int j = 0; j < s.length() && j < currentMaxEqualLen && s.charAt(j) == firstString.charAt(j); j++) {
                currentCount++;
            }
            currentMaxEqualLen = currentCount;
        }

        return firstString.substring(0, currentMaxEqualLen);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"a",""};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
