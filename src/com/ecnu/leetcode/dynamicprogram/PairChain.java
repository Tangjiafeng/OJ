package com.ecnu.leetcode.dynamicprogram;

import java.util.Arrays;

public class PairChain {
    /*
        You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
        Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
        Given a set of pairs, find the length longest chain which can be formed.
        You needn't use up all the given pairs. You can select pairs in any order.
     */
    public int findLongestChain(int pairs[][]) {
        int N = pairs.length;
        int[] dp = new int[N];
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i ++) {
            for(int j = 0; j <= i; j ++) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int ans = 0;
        for(int n : dp) {
            ans = n > ans ? n : ans;
        }

        return ans;
    }
}
