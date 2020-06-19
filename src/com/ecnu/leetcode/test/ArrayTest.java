package com.ecnu.leetcode.test;

import com.ecnu.leetcode.array.ArrayIntersection;
import com.ecnu.leetcode.array.MatrixRotate;
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
        int[] arr3 = {2,4,1};
        assertEquals(new MaxProfit().maxProfitV2(arr), 5);
        assertEquals(new MaxProfit().maxProfitV2(arr2), 0);
        assertEquals(new MaxProfit().maxProfitV2(arr3), 2);
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
    @Test
    public void MatrixRotateTest() {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,2,3},{5,6,7},{9,10,11}};
        new MatrixRotate().rotate(matrix);
    }
}
