package com.ecnu.leetcode.array;

public class MaxSubArray {
	/*
	 * Algor 1: the exquisite version. The main idea is that
     * to accumulate the array, if the array and <=0, it means to start a new array
	 */
	public int maxSubArray1(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
	/*
	 * Algor of mine: may ignore some cases. 
	 * 
	 * status: Attempted.
	 */
	public int maxSubArray(int[] nums) {
		if(nums.length == 1) return nums[0];// only one element
        int l = 0;
        int r = nums.length - 1;
        int sum = this.sum(nums, l, r);
        while(l < r) {
            if(nums[l] < nums[r]) {
                l ++;
                sum = Math.max(sum, sum(nums, l, r));
            } else {
                r --;
                sum = Math.max(sum, sum(nums, l, r));
            }
        }
        
        return sum;
    }
    public int sum(int[] arr, int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i ++) {
            sum += arr[i];
        }
        return sum;
    }
}
