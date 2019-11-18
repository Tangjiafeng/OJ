package com.ecnu.leetcode.math;

/**
 * https://leetcode.com/problems/reverse-integer/
 * @author A
 *
 */
public class ReverseNumber {
	/*
	 * Algor 1: 
	 */
	public static int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;// pop
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;// push
        }
        return rev;
    }
	/*
	 * Algor of mine: notice range of int.
	 */
	public static int reverse(int x) {
		boolean negative = (x < 0) ? true : false;
        
        int ten = 10;
        double result = 0;
        int len = negative ? String.valueOf(x).length() - 1 : String.valueOf(x).length();        
        for(int i = 1; x != 0; i++) {
            int n = x % (int)Math.pow(ten, i);
            x -= n;
            n /= (int)Math.pow(ten, i - 1);
            result += Math.pow(ten, len - i) * n;
            if(result < Integer.MIN_VALUE) return 0;
            if(result > Integer.MAX_VALUE) return 0;
        }
        return (int)result;
    }
}
