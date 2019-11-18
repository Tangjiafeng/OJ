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
	
	// Accept, but garbage.
	public static int reverseNumber(int x) {
		String xStr = x + "";
        BigInteger ans = new BigInteger("0");
        
        if(x == 0) {
            return 0;
        } else if(x < 0){
            xStr = xStr.substring(1);
            int i = 0;
            for(char c : xStr.toCharArray()) {
            	StringBuffer str = new StringBuffer(c + "");
            	for(int j = 0; j < i; j ++) {
            		str.append("0");
            	}
            	ans = ans.subtract(new BigInteger(str.toString()));
            	if(ans.compareTo(new BigInteger(Integer.MIN_VALUE + "")) < 0) {
            		return 0;
            	}
            	i ++;
            }
            return ans.intValue();
        } else {
        	int i = 0;
            for(char c : xStr.toCharArray()) {
            	StringBuffer str = new StringBuffer(c + "");
            	for(int j = 0; j < i; j ++) {
            		str.append("0");
            	}
            	ans = ans.add(new BigInteger(str.toString()));
            	if(ans.compareTo(new BigInteger(Integer.MAX_VALUE + "")) > 0) {
            		return 0;
            	}
            	i ++;
            }
            return ans.intValue();
        }
    }
	// excellent
	public static int reverseNumber2(int x) {
        long rs = 0;
        while(x != 0){
            rs = rs * 10 + x % 10;
            x /= 10;
        }
        return (rs < Integer.MIN_VALUE || rs > Integer.MAX_VALUE) ? 0 : (int)rs;
    }
}
