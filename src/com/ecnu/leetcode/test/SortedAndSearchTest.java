package com.ecnu.leetcode.test;

import com.ecnu.leetcode.sortandsearch.FirstBadVersion;
import com.ecnu.leetcode.sortandsearch.MergeSortedArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortedAndSearchTest {
    @Test
    public void mergeSortedArrayTest() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        MergeSortedArray.merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void FirstBadVersionTest() {
        System.out.println(FirstBadVersion.firstBadVersion(5));
    }
}
