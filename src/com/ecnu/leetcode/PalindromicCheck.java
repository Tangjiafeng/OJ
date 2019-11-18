package com.ecnu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决了一些用例的特殊错误，最后还是超时了，算法有问题
 * https://leetcode-cn.com/problems/can-make-palindrome-from-substring/
 */
public class PalindromicCheck {
	/**
	 * 基本做法：1）首先子串首尾做比较，记录不相配的位置出现次数。
	 *         删除相配位置的字母，2）剩余子串中成对字符可通过
	 *         重排重新匹配，故重新匹配对数从不相配的位置出
	 *         现次数中减去，3）再与可调整次数作比较。
	 * @param s
	 * @param queries
	 * @return
	 */
	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> ans = new ArrayList<>();

		for (int[] query : queries) {
//			String str = s.substring(query[0], query[1] + 1);// 注意子串可重排，"hunu [0,3,1]结果为true"
			StringBuffer stringB = new StringBuffer(s.substring(query[0], query[1] + 1));
			int len = stringB.toString().length();
			int i = 0;
			int j = len - 1;
			int temp = 0;
			// 1）
			while (i < j) {
				if(stringB.toString().charAt(i) != stringB.toString().charAt(j)) {
					temp ++;
				} else {
					stringB.deleteCharAt(j);
					stringB.deleteCharAt(i);
					i --;
					j --;
				}
				i ++;
				j --;
			}
			// 2）
			int[] letters = new int[26];// 处理子串可重排
			for (char c : stringB.toString().toCharArray()) {
				letters[c - 'a'] ++;
			}
			int pairs = 0;
			for (int p = 0; p < letters.length; p ++) {
				pairs += letters[p] / 2;
			}
			// 3）
			if (temp - pairs <= query[2]) {
				ans.add(Boolean.TRUE);
			} else {
				ans.add(Boolean.FALSE);
			}
			/*
			if (len % 2 == 0) {

			} else {

			}
			*/
		}
		return ans;
    }

	/**
	 * 动态规划解法：
	 */
	public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
		int len = s.length();
		List<Boolean> list = new ArrayList<>();
		int[][] arr = new int[len + 1][26];
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < 26; j++)
				arr[i][j] = arr[i - 1][j];
			arr[i][s.charAt(i-1) - 'a']++;
		}
		int left, right, count;
		for (int i = 0; i < queries.length; i++) {
			left = queries[i][0];
			right = queries[i][1];
			count = 0;
			for (int j = 0; j < 26; j++)
				count += (arr[right + 1][j] - arr[left][j]) % 2;
			list.add(count / 2 <= queries[i][2]);
		}
		return list;
	}
}
