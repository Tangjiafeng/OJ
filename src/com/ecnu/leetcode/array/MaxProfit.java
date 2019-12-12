package com.ecnu.leetcode.array;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {
    // Algor of mine:
    // status: ������ [2,1,2,1,0,1,2]���Ҳ�����С�Ĺȡ�
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int i = 0;
        while (i < prices.length - 1 && prices[i] >= prices[i + 1])
            i ++;
        int buy = prices[i];
        int sell = 0;
        if (i == prices.length - 1) return 0;
        while (i < prices.length) {
            if (prices[i] > buy) {
                sell = Math.max(sell, prices[i]);
            }
            i ++;
        }
        return sell - buy;
    }

    // Algor 1: ������Ҫ�ҵ���С�Ĺ�֮������ķ塣
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
