package com.ecnu.leetcode.string;

/**
 * 
 * https://leetcode.com/problems/longest-common-prefix/
 * @author A
 *
 */
public class LongestCommonPrefix {
	/*
	 * Algor 1: brief and clever version.
	 */
	public static String longestCommonPrefix1(String[] strs) {
	    if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	    	// Delete the different characters in advance.
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	        i++;
	    }
	    return pre;
	}
	/*
	 * Algor of mine: �ҵ��ַ�����������̵��ַ�����ȷ���䳤�ȣ�Ȼ��ͬ�Ƚ��ڸó���
	 * ��Χ�������ַ���ǰ׺ƥ�������
	 *
	 * TC��O(n^2)
	 * MC��
	 * ִ����ʱ : 1 ms, ������ java �ύ�л�����89.15%���û�
     * �ڴ����� : 37.8 MB, ������ java �ύ�л�����69.99%���û�
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		StringBuilder sb = new StringBuilder("");
        int min = strs[0].length();
        for(int i = 1; i < strs.length; i ++) {
            min = Math.min(min,strs[i].length());
        }
        for(int i = 0; i < min; i ++) {
        	char temp = strs[0].charAt(i);
        	boolean eq = true;
        	for(int j = 0; j < strs.length; j ++) {
        		if(temp == strs[j].charAt(i)) {
        			continue;
        		} else {
        			eq = false;
        			break;
        		}
            }
        	if(!eq) break;
        	sb.append(temp);
        }
        return sb.toString();
	}

}
