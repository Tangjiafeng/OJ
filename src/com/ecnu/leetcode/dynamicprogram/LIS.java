package com.ecnu.leetcode.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/lxt_Lucia/article/details/81206439
 * 最长子序列问题
 */
public class LIS {
    public static void main(String[] args) {
        int[] arr = {2,7,1,5,6,4,3,8,9};


        System.out.println(solution2(arr));
    }

    // DP: O(n^2)
    public static int solution1(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
        }

        int res = dp[0];

        for (int i = 1; i < dp.length; i ++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // 贪心 + 二分: O(nlog(n))
    public static int solution2(int[] arr) {
        List<Integer> seq = new ArrayList<>();
        seq.add(arr[0]);

        for (int i = 1; i < arr.length; i ++) {
            if(arr[i] > seq.get(seq.size() - 1)) {
                seq.add(arr[i]);
            } else {
                replaceElement(seq, arr[i]);
            }
        }

        return seq.size();
    }

    private static void replaceElement(List<Integer> seq, int i) {
        int l = 0, r = seq.size() - 1;

        int mid;
        while (l < r) {
            mid = (l + r) >> 1;
            if(seq.get(mid) <= i)
                l = mid + 1;
            else
                r = mid - 1;
        }

        seq.set(l, i);
    }

}
