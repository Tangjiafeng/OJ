package com.ecnu.leetcode.string;

/**
 * ��ĸ��λ�ʣ���ָ�����ǹ�ͬ��ĸ�Ĳ�ͬ���С�
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class Anagram {
    //����ȽϷ���ʱ�临�Ӷ�O(nlog(n))
    //...
    // Algor 1: ��ϣ��ͳ�Ʒ���ʱ�临�Ӷ�O(n)��
    public boolean isAnagram(String s, String t) {
        int[] counter = new int[26];

        for (char c : s.toCharArray()) {
            counter[c - 'a'] ++;
        }

        for (char c : t.toCharArray()) {
            counter[c - 'a'] --;
        }

        for (int i : counter) {
            if (i != 0) return false;
        }
        return true;
    }
}
