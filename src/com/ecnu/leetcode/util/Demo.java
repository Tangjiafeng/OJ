package com.ecnu.leetcode.util;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Demo {
	/*
	 * 最长递增子序列
	 * 
	 * Input: [10,9,2,5,3,7,101,18]
	 * Output: 4 
	 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
	 * 
	 * 动态规划
	 * 
	 * 原文：https://leetcode.com/problems/longest-increasing-subsequence
	 */
	public int longestSubSequence(int[] nums) {
		int dp[] = new int[nums.length];
		for (int i = 0; i < dp.length; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
		}
		int ret = 0;
		for (int i = 0; i < dp.length; i++) {
		    ret = Math.max(ret, dp[i]);
		}
		return ret;
	}
	/*
	 * 
	 */
	public int lengthOfLIS(int[] nums) {
	    int n = nums.length;
	    int[] tails = new int[n];
	    int len = 0;
	    for (int num : nums) {
	        int index = binarySearch(tails, len, num);
	        tails[index] = num;
	        if (index == len) {
	            len++;
	        }
	    }
	    return len;
	}
	public int binarySearch(int[] tails, int len, int key) {
	    int l = 0, h = len;
	    while (l < h) {
	        int mid = l + (h - l) / 2;
	        if (tails[mid] == key) {
	            return mid;
	        } else if (tails[mid] > key) {
	            h = mid;
	        } else {
	            l = mid + 1;
	        }
	    }
	    return l;
	}
	/*
	 * 
	 */
	public void rotate(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			int front = nums[nums.length - 1];
			for(int j = nums.length - 1; j > 0; j --) {
				nums[j] = nums[j - 1];
			}
			nums[0] = front;
		}
	}
	/*
	 * 
	 */
	public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = i + 1;
        while(i < j && j < nums.length) {
            if(nums[i] == nums[j]) {
                j ++;
            } else {
            	nums[i + 1] = nums[j];
            	j ++;
            	i ++;
            }
        }
        nums = Arrays.copyOf(nums, i + 1);
        return nums.length;
    }
	/*
     * 
     */
    public String minimizeError(String[] prices, int target) {
    	Double ans = 0.0;
    	int len = prices.length;
    	int ceilNum = 0;
    	int floorNum = 0;
    	double[] pricesDou = new double[len];
    	double[] floorAll = new double[len];
    	double[] ceilAll = new double[len];
    	for (int i = 0; i < prices.length; i++) {
    		pricesDou[i] = Double.parseDouble(prices[i]);
		}
    	int min = 0;
    	int max = 0;
    	for (int i = 0; i < pricesDou.length; i++) {
    		floorAll[i] = pricesDou[i] - Math.floor(pricesDou[i]);
    		ceilAll[i] = Math.ceil(pricesDou[i]) -pricesDou[i];
    		min += Math.floor(pricesDou[i]);
    		max += Math.ceil(pricesDou[i]);
		}
    	Arrays.sort(floorAll);
    	Arrays.sort(ceilAll);
    	if(target < min || target > max) {
    		return "-1";
    	} else {
    		ceilNum = target - min;
    		floorNum = max - target;
    	}
    	for (int i = 0; i < floorNum; i++) {
    		ans += floorAll[i];
		}
    	for (int i = 0; i < ceilNum; i++) {
			ans += ceilAll[i];
		}
    	
    	return String.format("%.2f", ans);
    }
    
    public static void main(String args[]) {
//    	String S = "leetcodetom";
//    	char maxChar = S.charAt(0);
//    	int[] maxCharIndex = new int[S.length()];
//    	int count = 0;
//    	for(char c : S.toCharArray()) {
//    		if(c > maxChar) {
//    			maxChar = c;    			
//    		}
//    	}
//    	for (int i = 0; i < S.length(); i++) {
//    		if(S.charAt(i) == maxChar) {
//    			maxCharIndex[i] = 1; 
//    			count ++;
//    		}
//		}
//    	List<Integer> lists = new ArrayList<>();
//    	for (int j = 0; j < maxCharIndex.length; j++) {
//			if(1 == maxCharIndex[j]) {				
//				lists.add(j);
//			}
//		}
//    	StringBuffer[] ans = new StringBuffer[count];
//		for (int j = 0; j < lists.size(); j++) {
//			ans[j] = new StringBuffer("");
//			ans[j].append(S.substring(lists.get(j), S.length()));
//			maxCharIndex[j] = 0;
//		}
//    	
//    	Arrays.sort(ans, new Comparator<StringBuffer>() {
//
//			@Override
//			public int compare(StringBuffer o1, StringBuffer o2) {
//				return o1.toString().compareTo(o2.toString());
//			}
//    		
//		});
//    	
//    	System.out.println(ans[ans.length - 1]);
    	
//    	int[] nums = {4,3,6,5};
//    	new Solution().moveZeroes(nums);
//    	new Demo().removeDuplicates(nums);
//    	new Demo().rotate(nums, 3);
//    	System.out.println(Arrays.toString(nums));
//    	int temp = 1;
//    	for (int i = 0; i < 100; i++) {
//			System.out.print(temp);
//		}
//    	System.out.println(new Demo().lengthOfLIS(nums));
    }
}
