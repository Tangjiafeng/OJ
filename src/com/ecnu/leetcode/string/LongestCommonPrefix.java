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
	 * Algor of mine: 找到字符串数组中最短的字符串，确定其长度，然后共同比较在该长度
	 * 范围内所有字符串前缀匹配情况。
	 *
	 * TC：O(n^2)
	 * MC：
	 * 执行用时 : 1 ms, 在所有 java 提交中击败了89.15%的用户
     * 内存消耗 : 37.8 MB, 在所有 java 提交中击败了69.99%的用户
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
