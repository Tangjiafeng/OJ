package com.ecnu.leetcode.array;

import java.util.Arrays;
/**
 * 
 * https://leetcode.com/problems/majority-element/
 * @author A
 *
 */
public class MajorityElement {
	/*
	 * Algor 3: Divide and Conqier.
	 */
	public static int majorityElement3(int[] nums) {
		return majorityElementRec(nums, 0, nums.length-1);
	}
	private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    private static int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }
	/*
	 * Algor 2: using API
	 */
	public static int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
	/*
	 * Algor 1: Preferred. 
	 *     From the first number, let 'count=1'£¬plus 1 when meetting same number£¬
	 * minus 1 when meetting other numbers£¬restart from a new number when 'count==0'
	 */
	public static int majorityElement1(int[] nums) {
		int count = 1;
		int first = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(first == nums[i]) {
				count ++;
			} else {
				count --;
			}
			if(count == 0) {
				first = nums[i];
				count = 1;
			}
		}
		return first;
	}

	/*
	 * Algor of mine: sorted it. A little stupid.
	 */
	public static int majorityElement(int[] nums) {
		if(nums.length == 1) return nums[0];
		Arrays.sort(nums);
		
		int len = nums.length /2;
		int temp = nums[0];
		int temp_len = 1;
		for(int i = 1; i < nums.length; i ++) {
			if(temp == nums[i]) {
				temp_len ++;
			} else {
				temp = nums[i];
				temp_len = 1;
			}
			if(temp_len > len) return nums[i];
		}
		return 0;
    }
}