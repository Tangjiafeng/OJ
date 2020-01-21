package com.ecnu.leetcode.sortandsearch;

public class FirstBadVersion {
    public static boolean isBadVersion(int version) {
        if (version >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public static int firstBadVersion(int n) {
        int l = 0;
        int r = n - 1;
        int m =  0;
        while (l < r) {
            m =  l + (r - l) / 2;
            if (!isBadVersion(m)) {
                l = m + 1;
            } else if (isBadVersion(m)) {
                r = m - 1;
            }
        }

        return l;
    }
}
