package com.ecnu.leetcode.test;

import com.ecnu.leetcode.greedystrategy.AssignCookeis;

public class GSTest {
    public static void main(String args[]) {
        int[] chren = {1,2,5,3,2,6,45,7,5,1,3,34,1,2,34,56,4,123,5454,234,23};
        int[] cookies = {1,2,3,6,9,8,4,89,6,5,75,21,4545,23,545,234,3354,3432,45,32,1};
        System.out.println(new AssignCookeis().assign(chren, cookies));
        System.out.println(new AssignCookeis().findContentChildren(chren, cookies));
    }
}
