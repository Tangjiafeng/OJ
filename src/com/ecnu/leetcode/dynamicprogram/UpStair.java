package com.ecnu.leetcode.dynamicprogram;

public class UpStair {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            dp[i] = dp[n - 1] + dp[n - 2];
        }
        return dp[n];
    }
}
