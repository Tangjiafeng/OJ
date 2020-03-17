package com.ecnu.leetcode.dynamicprogram;

public class RobHouse {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 0) return 0;
        int[] moneys = new int[n + 1];
        moneys[0] = 0;
        moneys[1] = nums[0];
        for (int i = 2; i <= n; i ++) {
            // ×´Ì¬×ªÒÆ·½³Ì
            moneys[i] = Math.max(moneys[i - 1], moneys[i - 2] + nums[i - 1]);
        }
        return moneys[n];
    }
}
