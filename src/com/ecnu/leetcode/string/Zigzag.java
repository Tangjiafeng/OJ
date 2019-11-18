package com.ecnu.leetcode.string;

import java.util.*;


/**
 * case:"123456789", row=3:
 *   1   5   9
 *   2 4 6 8 
 *   3   7
 * return "159246837"
 * row=4:
 *   1     7
 *   2   6 8
 *   3 5   9
 *   4     
 * return "172683594"
 * 
 * https://leetcode.com/problems/zigzag-conversion/
 * @author A
 *
 */
public class Zigzag {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // How to append the current character of 's' in these rows?
            // when 'curRow == 0', 'goingDown' must be true. When 'curRow == numRows - 1', 'goingDown' must be false.
            // Following by 'goingDown', we decide to add or subtract the 'curRow'.
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}