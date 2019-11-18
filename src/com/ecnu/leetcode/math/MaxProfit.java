package com.ecnu.leetcode.math;

/**
 * int[] prices = {1,2,4,2,5,7,2,4,9,0};
 * 
 * @author A
 *
 */
public class MaxProfit {
	/*
	 * Algor 3: 简化思维，直接继续增加数组的连续数字之间的差值，如果第二个数字大于第一个数字，我们获得的总和将是最大利润。
	 */
	public static int maxProfit3(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
	/*
	 * Algor 2: peak valley method.
	 */
	public static int maxProfit2(int[] prices) {
		/*
		// brief version
		int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
		 */
        int ans = 0;
		for (int i = 0; i < prices.length; i++) {
			int v = prices[i];
			if(i != prices.length - 1 && prices[i] < prices[i + 1]) {
				for (int j = i + 1; j < prices.length; j++) {
					int p = prices[j];
					if(j == prices.length - 1) {
						if(v <= p) {
							ans += p - v;
							i=j;
							break;
						}
					} else {
						if(v <= p && p > prices[j + 1]) {
							ans += p - v;
							i = j;
							break;
						}
					}
				}
			} else {
				continue;
			}
		}		
		return ans;
    }
	/*
	 * Algor 1: brute force using recursion. Calculate the profit corresponding to all possible trading 
	 * combinations and find the cumulative maximum profit among them.
	 */
	public static int maxProfit1(int[] prices) {
        return calculate(prices, 0);
    }
	public static int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }

}
