package com.ecnu.leetcode.array;

import java.util.Arrays;

public class SumClosest {
	/*
	 * Algor 1: O(n^2) version. Sorting arrays first is a good trick.
	 */
	public static int threeSumClosest1(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i - 1 >= 0 && num[i] == num[i - 1])
				continue;
			int start = i + 1, end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}

	/*
	 * Algor of mine: brute force version.
	 * 
	 * status: Accepted.
	 */
	public static int threeSumClosest(int[] nums, int target) {
		int minDif = 10000;
		int res = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int temp = nums[i] + nums[j] + nums[k];
					int dif = Math.abs(temp - target);
					res = dif - minDif < 0 ? temp : res;
					minDif = Math.min(dif, minDif);
				}
			}
		}
		return res;
	}
}
