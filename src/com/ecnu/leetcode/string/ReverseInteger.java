package com.ecnu.leetcode.string;

import java.math.BigInteger;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseInteger {
    // Algor of mine: bad code.
    // status: Accept.
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
    // Algor 1: very concise.
    public static int reverseNumber2(int x) {
        long rs = 0;
        while(x != 0){
            rs = rs * 10 + x % 10;
            x /= 10;
        }
        return (rs < Integer.MIN_VALUE || rs > Integer.MAX_VALUE) ? 0 : (int)rs;
    }
    // Algor 2: 数学方法，从给定的范围反推计算结果是否越界。
    public int reverseNumber3(int x) {
        int rev = 0;
        int xx = Integer.MAX_VALUE % 10;
        int ss = Integer.MIN_VALUE % 10;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > xx)){
                rev = 0;
                break;
            }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < ss)){
                rev = 0;
                break;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}