package com.ecnu.leetcode.test;

import com.ecnu.leetcode.dynamicprogram.PairChain;


public class DPTest {
    public static void main(String args[]) {
        int[][] pairs = {{1,2},{2,3},{3,4},{6,8},{4,5}};
        System.out.println(new PairChain().findLongestChain(pairs));
    }
}
