package com.ecnu.leetcode.test;

import com.ecnu.leetcode.array.MaxProfit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTest {
    @Test
    public void MaxProfitTest() {
//        int[] arr = {7,1,5,3,6,4};
        int[] arr = {3, 3};
//        assertEquals(new MaxProfit().maxProfit(arr), 7);
        assertEquals(new MaxProfit().maxProfit(arr), 0);
    }
}
