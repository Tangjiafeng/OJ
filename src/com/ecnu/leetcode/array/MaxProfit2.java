package com.ecnu.leetcode.array;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
public class MaxProfit2 {
    // Algor 1: 峰谷法
    public int maxProfit(int[] prices) {
        int ans = 0;
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];

        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i ++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i ++;
            peak = prices[i];

            ans += peak - valley;
        }

        return ans;
    }

    // Algor 2: 一次遍历法
    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
