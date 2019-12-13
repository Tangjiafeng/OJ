package com.ecnu.leetcode.string;

/**
 * 基础：
 * 进阶：https://leetcode-cn.com/problems/valid-palindrome-ii/，允许最多删除一个字符，判断是否为回文串。
 */
public class Palindrome {
    // 可删除，我只能想到暴力法；
    // 贪心算法如下：
    public boolean validPalindromeDel(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
            } else {
                return helper(s.substring(i + 1 , j + 1)) || helper(s.substring(i, j));
            }
        }
        return true;
    }

    public boolean helper(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
            } else {
                return false;
            }
        }
        return true;
    }
}
