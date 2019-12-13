/**
 * 
 */
package com.ecnu.leetcode.string;

import java.math.BigInteger;

/**
 * @author A
 * Only O(1) space
 */
public class ReverseUtil {
	public static void reverseString(char[] s) {
        for (int i = 0; i < s.length; i++) {
			char temp = s[0];
			
			for (int j = 0; j < s.length - i - 1; j ++) {
				s[j] = s[j + 1];
			}
			
			s[s.length - i - 1] = temp;
		}
		
    }
}
