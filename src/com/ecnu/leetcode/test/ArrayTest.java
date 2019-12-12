package com.ecnu.leetcode.test;

import com.ecnu.leetcode.array.ArrayIntersection;
import com.ecnu.leetcode.array.MaxProfit;
import com.ecnu.leetcode.array.MaxProfit2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTest {
    @Test
    public void MaxProfitTest() {
        int[] arr = {7,1,5,3,6,4};
        int[] arr2 = {3, 3};
        assertEquals(new MaxProfit().maxProfit(arr), 5);
        assertEquals(new MaxProfit().maxProfit(arr2), 0);
    }
    @Test
    public void MaxProfit2Test() {
//        int[] arr = {7,1,5,3,6,4};
        int[] arr = {3, 3};
//        assertEquals(new MaxProfit2().maxProfit(arr), 7);
        assertEquals(new MaxProfit2().maxProfit(arr), 0);
    }
    @Test
    public void ArrayIntersectionTest() {
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};

        System.out.println(Arrays.toString(new ArrayIntersection().intersection(nums1, nums2)));
    }
}
