package cn.zynworld.leetcode.q200;

import java.util.*;
import java.util.stream.IntStream;

import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 * @author zhaoyuening
 * @date 2019/10/21.
 */
public class Q139 {
	public static boolean wordBreak(String s, List<String> wordDict) {
		if (s.isEmpty()) {
			return true;
		}

		return wordBreak(s.toCharArray(), 0, wordDict,new HashMap<>());
	}

	private static boolean wordBreak(char[] chars, Integer startIndex, List<String> wordDict, Map<Integer, Boolean> resultMap) {
		if (startIndex == chars.length) return true;
		if (resultMap.containsKey(startIndex)) return false;

		// 当前检验范围字符长度
		Integer len = chars.length - startIndex;

		// 轮询所有字典的单词
		for (String word : wordDict) {
			// 与该单词匹配
			if (len >= word.length()
					&& checkCharsEquals(chars, startIndex, startIndex + word.length(), word)
					&& wordBreak(chars, startIndex + word.length(), wordDict, resultMap)) {
				return true;
			}
		}

		// 缓存失败结果
		resultMap.put(startIndex, false);
		return false;
	}

	private static boolean checkCharsEquals(char[] chars, Integer startIndex, Integer endIndex, String s) {
		if (endIndex - startIndex != s.length()) return false;

		char[] chars1 = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (chars[startIndex + i] != chars1[i]) return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// use case
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		// System.out.println(!wordBreak(s,wordDict));

		s = "leetcode";
		wordDict = Arrays.asList("leet", "code");
		System.out.println(wordBreak(s,wordDict));

		s = "a";
		wordDict = Arrays.asList("a");
		System.out.println(wordBreak(s,wordDict));

		s = "applepenapple";
		wordDict = Arrays.asList("apple", "pen");
		System.out.println(wordBreak(s,wordDict));

		s = "catsandog";
		wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
		System.out.println(!wordBreak(s,wordDict));



	}
}
