package com.ecnu.leetcode.sortandsearch;
// https://leetcode-cn.com/problems/merge-sorted-array/
// TC:
// MC:
// ִ����ʱ : ms, ������ java �ύ�л�����%���û�
// �ڴ����� : MB, ������ java �ύ�л�����%���û�
public class MergeSortedArray {
    // Algor of mine: ֱ�Ӳ�������
    // TC: O(m * n)
    // MC: O(1)
    // ִ����ʱ : 1 ms, ������ java �ύ�л����� 33.23% ���û�
    // �ڴ����� : 35.9 MB, ������ java �ύ�л����� 93.51% ���û�
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i ++) {
            int j = m - 1;
            while (j > -1) {
                if (nums1[j] > nums2[i]) {
                    j --;
                    continue;
                } else {
                    break;
                }
            }
            for (int k = m - 1; k > j; k --) {
                nums1[k + 1] = nums1[k];
            }
            nums1[j + 1] = nums2[i];
            m ++;
        }

    }
    // Algor1: ˫ָ�룬��ǰ������Ҫ�ȴ洢nums1�е�ֵ��
    // TC: O(m + n)
    // MC: O(m)
    // ִ����ʱ : 0 ms, ������ java �ύ�л����� 100% ���û�
    // �ڴ����� : 36 MB, ������ java �ύ�л����� 77.07% ���û�
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
    // Algor2: ˫ָ�룬�Ӻ�ǰ�����Ա������洢��
    // TC: O(m + n)
    // MC: O(1)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
