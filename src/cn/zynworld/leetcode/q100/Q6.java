package cn.zynworld.leetcode.q100;

/**
 * @author zhaoyuening
 * @date 2019/8/21.
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class Q6 {

	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		StringBuilder convertedBuilder = new StringBuilder();

		for (int i = 0; i < numRows; i++) {
			int distanceA = numRows * 2 - 2 - (i * 2);
			int distanceB = i * 2;

			for (int w = i, currentDistance = distanceA; w < s.length(); currentDistance = currentDistance != distanceA ? distanceA : distanceB) {
				if (currentDistance == 0) {
					continue;
				}

				convertedBuilder.append(s.charAt(w));
				w += currentDistance;
			}
		}
		return convertedBuilder.toString();
	}

	public static void main(String[] args) {
		Q6 q6 = new Q6();
		boolean result1 = q6.convert("A", 1).equals("A");
		System.out.println(result1);
	}
}
