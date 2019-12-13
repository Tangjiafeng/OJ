package com.ecnu.leetcode.string;

/**
 * 字母异位词，是指单词是共同字母的不同排列。
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class Anagram {
    //排序比较法，时间复杂度O(nlog(n))
    //...
    // Algor 1: 哈希表统计法，时间复杂度O(n)。
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
