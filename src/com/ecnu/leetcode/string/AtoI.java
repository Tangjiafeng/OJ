package com.ecnu.leetcode.string;

/**
 * 
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtoI {
	public static int myAtoi(String str) {
		str = str.trim();
        Pattern pattern = Pattern.compile("^[\\+ \\- \\d]?\\d+");
		Matcher matcher = pattern.matcher(str);
		
		if(matcher.find()) {
			String ansStr = str.substring(matcher.start(), matcher.end()).trim();
			boolean negative = false;
			if('-' == ansStr.charAt(0)) {
				negative = true;
			}
            if('+' == ansStr.charAt(0)) {
				ansStr = ansStr.substring(1);
			}
			int ans = 0;
			if(negative) {
				for(int i = 1; i < ansStr.length(); i ++) {
					int temp = Integer.parseInt(ansStr.charAt(i) + "");
					if(ans >= Integer.MIN_VALUE / 10 && ans * 10 > Integer.MIN_VALUE + temp) {
						ans = ans * 10 - temp;
					} else {
						return Integer.MIN_VALUE;
					}
				}
			} else {
				for(int i = 0; i < ansStr.length(); i ++) {
					int temp = Integer.parseInt(ansStr.charAt(i) + "");
					if(ans <= Integer.MAX_VALUE / 10 && ans * 10 < Integer.MAX_VALUE - temp) {
						ans = ans * 10 + temp;
					} else {
						return Integer.MAX_VALUE;
					}
				}
			}

			return ans;			
		} else {
			return 0;
		}
    }
	
}