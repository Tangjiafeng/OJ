package com.ecnu.leetcode.dynamicprogram;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        if (max < 0) return max;
        for (int i = 0; i < nums.length; i ++) {
            if (sum + nums[i] < 0) {
                sum = 0;
            } else {
                sum += nums[i];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}