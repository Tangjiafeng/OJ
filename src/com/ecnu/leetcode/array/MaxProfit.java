package com.ecnu.leetcode.array;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {
    // Algor of mine:
    // status: 解答错误，不能一直保证入手股票为卖出之前的最低价。
//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        int i = 0;
//        while (i < prices.length - 1 && prices[i] >= prices[i + 1])
//            i ++;
//        int buy = prices[i];
//        int sell = 0;
//        if (i == prices.length - 1) return 0;
//        while (i < prices.length) {
//            if (prices[i] > buy) {
//                sell = Math.max(sell, prices[i]);
//            }
//            i ++;
//        }
//        return sell - buy;
//    }
    // 修正
    public int maxProfitV2(int[] prices) {
        if (prices.length == 0) return 0;
        int i = 0;
        while (i < prices.length - 1 && prices[i] >= prices[i + 1])
            i ++;
        int buy = prices[i];
        int sell = 0;
        int ans = 0;
        if (i == prices.length - 1) return 0;
        while (i < prices.length) {
            if (prices[i] > buy) {
                sell = Math.max(sell, prices[i]);
            }
            if (prices[i] < buy) {
                buy = prices[i];
                sell = prices[i];
            }
            ans = Math.max(sell - buy, ans);
            i ++;
        }
        return ans;
    }

    // Algor 1: 我们需要找到当前的峰与之前最小的谷的最大值。
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
