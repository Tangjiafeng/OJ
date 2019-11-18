package com.ecnu.leetcode.dynamicprogram;

import java.util.Arrays;

import com.ecnu.leetcode.PerfectSquares;

public class PerfectSquaresDP implements PerfectSquares {

	/*
	 * 
	 * (non-Javadoc)
	 * @see com.ecnu.leetcode.PerfectSquares#numSquares(int)
	 */
	@Override
	public int numSquares(int n) {
		int[] arr = new int[n+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; (j*j) <= i; j++) {
				arr[i] = Math.min(arr[i], arr[i- (j*j)] + 1);
			}
		}

		return arr[n];
	}

}
