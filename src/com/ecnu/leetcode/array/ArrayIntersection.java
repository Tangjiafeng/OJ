package com.ecnu.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * �����������飬��дһ���������������ǵĽ�����
 * https://leetcode-cn.com/problems/intersection-of-two-arrays
 */
public class ArrayIntersection {
    // Algor of mine: ���򣬱Ƚϣ�ȥ��
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums.add(nums1[i]);
                i ++;
                j ++;
            } else if (nums1[i] < nums2[j]) {
                i ++;
            } else if (nums1[i] > nums2[j]) {
                j ++;
            }
        }
        int[] ans = new int[nums.size()];
        int k = 0;
        for (Integer e : nums) {
            ans[k ++] = e;
        }
        return ans;
    }
}
