package com.ecnu.leetcode.backtraceing;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/generate-parentheses/
 * @author A
 *
 */
public class GenerateParentheses {
	/*
	 * Algor2: Let's only add them when we know it will remain a valid sequence. 
	 * We can do this by keeping track of the number of opening and closing 
	 * brackets we have placed so far.
     *     We can start an opening bracket if we still have one (of n) left to place.
     * And we can start a closing bracket if it would not exceed the number of 
     * opening brackets.
     * 
	 */
	public static List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
	/*
	 * Algor 1: brute force version with recursion.
	 * 
	 * 要敢于用递归，递归的套路，解题很实用，但有时候就是变形的循环。
	 */
	public static List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }
    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        	return;
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }
    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
	/*
	 * Algor of mine: cyclic interpolation.
	 * status: Attempted.
	 * n = 4: ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())"
	 *        ,"(()())()","(())(())","(())()()","()((()))","()(()())","()(())()"
	 *        ,"()()(())","()()()()"]
	 *        
	 * BUG FIX: 每次左括号和右括号做交换只有一对，故结果中没有"(())(())"，"(())()()"，"()()(())"，"()()()()"
	 *          继续增加多对交换，需要处理重复，复杂度更高，故不合适。
	 * 
	 */
	public static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<String>();
		StringBuffer currStr = new StringBuffer();
		for (int i = 0; i < 2 * n; i++) {
			if(i < n) {
				currStr.append("(");
			} else {
				currStr.append(")");
			}
		}
		// Assuming n = 3, currStr is "((()))".
		String constStr = currStr.toString();
		ans.add(constStr);
		// Start the 'swap' operation to produce all the results.
		for (int i = n - 1; i > 0; i --) {// i: ((
			for (int j = n; j < constStr.length() - 1; j++) {// j: ))
				swap(i, j, currStr);
				ans.add(currStr.toString());
				currStr.delete(0, currStr.length());
				currStr.append(constStr);
			}
		}
		return ans;
    }
	public static void swap(int i, int j, StringBuffer temp) {
		String iStr = temp.substring(i, i + 1);
		String jStr = temp.substring(j, j + 1);
		temp.delete(i, i + 1);
		temp.insert(i, jStr);
		temp.delete(j, j + 1);
		temp.insert(j, iStr);
	}
}
