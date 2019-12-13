package com.ecnu.leetcode.string;

/**
 * ������
 * ���ף�https://leetcode-cn.com/problems/valid-palindrome-ii/���������ɾ��һ���ַ����ж��Ƿ�Ϊ���Ĵ���
 */
public class Palindrome {
    // ��ɾ������ֻ���뵽��������
    // ̰���㷨���£�
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
