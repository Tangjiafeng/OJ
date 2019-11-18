package com.ecnu.leetcode.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public void moveZeroes(int[] arr) {
		for(int i = 0;i < arr.length;i ++) {
			if(arr[i] == 0) {
                int j = i + 1;
                boolean zeros = true;
                for(;j < arr.length;j ++) {
                	if(arr[j] != 0) {
                		zeros = false;
                		break;
                	}
                }
                if(zeros) {
                	break;
                }
                for(;j < arr.length;j ++){
                    arr[j - 1] = arr[j];
                }
                arr[j - 1] = 0;
            }
		}
    }
	/*
	 * plus one
	 */
	public int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length + 1];
        Arrays.fill(ans, 0);
        for (int i = digits.length - 1; i >= 0; i--) {
			int j = digits[i];
			j += 1;
			if(j < 10) {
				digits[i] = j;
				break;
			} else {
				digits[i] = 0;
				if(i == 0) {
					ans[0] = 1;
					return ans;
				}
				continue;
			}			
		}
        return digits;
    }
	/*
	 * 
	 */
	public String replaceSpace(StringBuffer str) {
		int index = str.indexOf(" ");
		while (index != -1) {
			str.replace(index, index + 1, "%20");
			index = str.indexOf(" ", index);
		}
		String result = str.toString();
		return result;
	}
	/*
	 * 集合的交集
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0; int j = 0;
        while(i < nums1.length && j < nums2.length) {
            while(i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) i ++;
            while(i < nums1.length && j < nums2.length && nums1[i] > nums2[j]) j ++;
            if(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] nums = new int[list.size()];
        for (int k = 0; k < nums.length; k++) {
			nums[k] = list.get(k);			
		}
        return nums;
    }
	/*
	 * 求字符串中最长且字符不重复的子串
	 * @param str
	 * @return
	 */
	public static int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            preIndexs[c] = curI;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
	/*
	 * 'try', 'catch', 'finally' with 'return' statement
	 * @param num
	 * @return
	 */
	public static int getNumber(int num){
        try{
            int result = 2 / num;
            return result;
        }catch (Exception exception){
            return 0;
        }finally{
            if(num == 0){
                return -1;
            }
            if(num == 1){
                return 1;
            }
        }
    }
}
