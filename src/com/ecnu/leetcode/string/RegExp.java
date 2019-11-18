package com.ecnu.leetcode.string;

import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/regular-expression-matching/
 * @author A
 *
 */
public class RegExp {
	/*
	 * Algor 1: recursion version.
	 */
	public static boolean isMatchRecursion(String text, String pattern) {
		// Concise judgment operation for empty strings.
		if (pattern.isEmpty()) return text.isEmpty();
		
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
        	// Containing two compare cases' result. Effective!!!
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
	}
	
	/*
	 * Algor of mine: matching them from left to right one by one.
	 * 
	 * status: Attempted.
	 * 
	 */
    public static boolean isMatch(String s, String p) {
    	// Optimizing the code for compactive structure.
        if(s.isEmpty()) return p.isEmpty();
        StringBuffer str = new StringBuffer(s);
        StringBuffer pattern = new StringBuffer(p);
        Stack<Character> tmp = new Stack<Character>();
        int i_str = 0;
    	int i_pattern = 0;
    	
        while(str.length() > i_str && pattern.length() > i_pattern) {
        	// Case 1: the first letter of 'pattern' is '.'.
        	if('.' == pattern.charAt(i_pattern)) {
        		char temp = str.charAt(i_str);
    			i_str ++;
    			i_pattern ++;
    			// Case 1_1: the next is '*'
    			if(i_pattern < pattern.length() && '*' == pattern.charAt(i_pattern)) {
    				tmp.push(temp);
    				while(i_str < str.length()) {
    					tmp.push(str.charAt(i_str));
    					i_str ++;
    				}
    				i_pattern ++;
    			}
    			continue;
    		}
        	// Case 2: Equation.
        	if(str.charAt(i_str) == pattern.charAt(i_pattern)) {
        		char temp = str.charAt(i_str);
        		i_str ++;
    			i_pattern ++;
    			// Case 2_1: the next is '*'
    			if(i_pattern < pattern.length() && '*' == pattern.charAt(i_pattern)) {
    				tmp.push(temp);
    				while(i_str < str.length() && temp == str.charAt(i_str)) {
    					tmp.push(str.charAt(i_str));
    					i_str ++;
    				}
    				i_pattern ++;
    			}
    			continue;
    		} else {// No equation.
    			if(i_pattern + 1 < pattern.length() && '*' == pattern.charAt(i_pattern + 1)) {
    				i_pattern += 2;
    				continue;
    			} else {
    				if(pattern.charAt(i_pattern) != str.charAt(i_str)) {
    					if(tmp.size() == 0) return false;
    					if(pattern.charAt(i_pattern) == tmp.pop()) {
    						i_pattern ++;
    						continue;
    					} else {
    						return false;
    					}
    				}
    			}
    		}
        }
        
        if(str.length() == i_str && pattern.length() == i_pattern) return true;
        // The remaining operations.
        if(str.length() - i_str > pattern.length() - i_pattern) {
        	return false;
        } else {
        	while (i_pattern < pattern.length()) {
    			if(i_pattern + 1 < pattern.length() && '*' == pattern.charAt(i_pattern + 1)) {
    				i_pattern += 2;
    				continue;
    			}
    			if(tmp.size() == 0) return false;
				if(pattern.charAt(i_pattern) == tmp.pop() || '.' == pattern.charAt(i_pattern)) {
					i_pattern ++;
					continue;
				} else {
					return false;
				}
			}
        	return true;
        }
    }
	
}
