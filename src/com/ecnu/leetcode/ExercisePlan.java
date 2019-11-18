package com.ecnu.leetcode;

public class ExercisePlan {
	/*
	 * 1 <= k <= calories.length <= 10^5
	 * 0 <= calories[i] <= 20000
	 * 0 <= lower <= upper
	 */
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
		int ans = 0;
		int start = 0;
		while(start < calories.length) {
			int end = start + k;
			if(end > calories.length) break;
			// 计算总量，判断lower与upper
			int sum = 0;
			for(int index = start; index < end; index ++) {
				sum += calories[index];
			}
			if(sum > upper) {
				ans ++;
			} else if(sum < lower) {
				ans --;
			}
			start ++;
		}
		
        return ans;
    }
}
