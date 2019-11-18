package com.ecnu.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @author A
 *
 */
public class LetterCombinations {
	/*
	 * Algor 1: backtracing.
	 */
	static Map<String, String> phone = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};
	static List<String> output = new ArrayList<String>();
	public static void backtrack(String combination, String next_digits) {
		// if there is no more digits to check
		if (next_digits.length() == 0) {
			// the combination is done
			output.add(combination);
		}
		// if there are still digits to check
		else {
			// iterate over all letters which map
			// the next available digit
			String digit = next_digits.substring(0, 1);
			String letters = phone.get(digit);
			for (int i = 0; i < letters.length(); i++) {
				String letter = phone.get(digit).substring(i, i + 1);
				// append the current letter to the combination
				// and proceed to the next digits
				backtrack(combination + letter, next_digits.substring(1));
			}
		}
	}
	public static List<String> letterCombinations1(String digits) {
		if (digits.length() != 0)
			backtrack("", digits);
		return output;
	}
	/*
	 * Algor of mine: directly.
	 */
	public static Map<Integer, String[]> num = new HashMap<Integer, String[]>();
	static {
		String[] chars2 = { "a", "b", "c" };
		num.put(2, chars2);
		String[] chars3 = { "d", "e", "f" };
		num.put(3, chars3);
		String[] chars4 = { "g", "h", "i" };
		num.put(4, chars4);
		String[] chars5 = { "j", "k", "l" };
		num.put(5, chars5);
		String[] chars6 = { "m", "n", "o" };
		num.put(6, chars6);
		String[] chars7 = { "p", "q", "r", "s" };
		num.put(7, chars7);
		String[] chars8 = { "t", "u", "v" };
		num.put(8, chars8);
		String[] chars9 = { "w", "x", "y", "z" };
		num.put(9, chars9);
	}
	public static List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return new ArrayList<String>();
		List<String[]> strList = new ArrayList<String[]>();
		for (int i = 0; i < digits.length(); i++) {
			int n = Integer.parseInt(digits.substring(i, i + 1));
			strList.add(LetterCombinations.num.get(n));
		}
		String[] str = strList.get(0);
		strList.remove(0);
		return Arrays.asList(combine(str, strList));
	}
	public static String[] combine(String[] A, List<String[]> B) {
		if (B.size() == 0)
			return A;
		String[] strs = new String[A.length * B.get(0).length];
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.get(0).length; j++) {
				String str = A[i] + B.get(0)[j];
				strs[index] = str;
				index++;
			}
		}
		B.remove(0);
		return combine(strs, B);
	}
}
