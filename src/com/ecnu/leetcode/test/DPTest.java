package com.ecnu.leetcode.test;

import com.ecnu.leetcode.dynamicprogram.MaximumSubarray;
import com.ecnu.leetcode.dynamicprogram.PairChain;
import com.ecnu.leetcode.dynamicprogram.RobHouse;
import com.ecnu.leetcode.dynamicprogram.UpStair;
import org.junit.jupiter.api.Test;


public class DPTest {
    public static void main(String args[]) {
        int[][] pairs = {{1,2},{2,3},{3,4},{6,8},{4,5}};
        System.out.println(new PairChain().findLongestChain(pairs));
    }

    @Test
    public void upStairTest() {
        int n = 3;
        System.out.println(new UpStair().climbStairs(n));
    }

    @Test
    public void maximumSubarrayTest() {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(arr));
    }

    @Test
    public void robHouseTest() {
        int[] arr1 = {1,2,3,1};
        int[] arr2 = {2,7,9,3,1};
        System.out.println(new RobHouse().rob(arr1));
        System.out.println(new RobHouse().rob(arr2));
    }
}
