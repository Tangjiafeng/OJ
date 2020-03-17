package com.ecnu.leetcode.dynamicprogram;

public class MaxProfitOfStock {
    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
    // 假如只交易一次（开胃菜，不是动态规划）
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
    // 假如可以尽可能的多次交易
    public int maxProfitB(int[] prices) {
        
        return 0;
    }
}
