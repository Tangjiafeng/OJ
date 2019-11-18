package com.ecnu.leetcode.greedystrategy;

import java.util.Arrays;


public class AssignCookeis {
    /**
     * A brief, faster version.
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        long start = System.nanoTime();
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        long end = System.nanoTime();
        System.out.println("findContentChildren time: " + (end - start) + " ns");
        return gi;
    }

    /**
     * Algor of mine.
     *
     * @param chren
     * @param cookies
     * @return
     */
    public int assign(int chren[], int cookies[]) {
        long start = System.nanoTime();
        Arrays.sort(chren);
        Arrays.sort(cookies);
        int ans = 0;
        int temp = 0;
        for(int i = 0;i < chren.length; i ++) {
            for(int j = temp;j < cookies.length; j ++) {
                if(chren[i] <= cookies[j]) {
                    ans ++;
                    temp = j + 1;
                    break;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("assign time: " + (end - start) + " ns");
        return ans;
    }
}
