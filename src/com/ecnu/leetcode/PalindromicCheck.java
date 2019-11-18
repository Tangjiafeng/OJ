package com.ecnu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * �����һЩ�����������������ǳ�ʱ�ˣ��㷨������
 * https://leetcode-cn.com/problems/can-make-palindrome-from-substring/
 */
public class PalindromicCheck {
	/**
	 * ����������1�������Ӵ���β���Ƚϣ���¼�������λ�ó��ִ�����
	 *         ɾ������λ�õ���ĸ��2��ʣ���Ӵ��гɶ��ַ���ͨ��
	 *         ��������ƥ�䣬������ƥ������Ӳ������λ�ó�
	 *         �ִ����м�ȥ��3������ɵ����������Ƚϡ�
	 * @param s
	 * @param queries
	 * @return
	 */
	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> ans = new ArrayList<>();

		for (int[] query : queries) {
//			String str = s.substring(query[0], query[1] + 1);// ע���Ӵ������ţ�"hunu [0,3,1]���Ϊtrue"
			StringBuffer stringB = new StringBuffer(s.substring(query[0], query[1] + 1));
			int len = stringB.toString().length();
			int i = 0;
			int j = len - 1;
			int temp = 0;
			// 1��
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
			// 2��
			int[] letters = new int[26];// �����Ӵ�������
			for (char c : stringB.toString().toCharArray()) {
				letters[c - 'a'] ++;
			}
			int pairs = 0;
			for (int p = 0; p < letters.length; p ++) {
				pairs += letters[p] / 2;
			}
			// 3��
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
	 * ��̬�滮�ⷨ��
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
