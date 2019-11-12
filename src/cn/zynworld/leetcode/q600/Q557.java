package cn.zynworld.leetcode.q600;

/**
 * @author zhaoyuening
 */
public class Q557 {
    public String reverseWords(String s) {
        String[] splits = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            String str = splits[i];
            for (int j = str.length() - 1; j >= 0; j--) {
                stringBuilder.append(str.charAt(j));
            }
            if (i != splits.length - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
