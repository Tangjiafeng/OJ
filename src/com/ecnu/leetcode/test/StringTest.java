package com.ecnu.leetcode.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.ecnu.leetcode.string.*;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	public void zigzagTest() {
		assertEquals(Zigzag.convert("123456789", 3), "159246837");
		assertEquals(Zigzag.convert("123456789", 4), "172683594");
	}

	@Test
	public void romanToInteger() {
		assertEquals(RomanToInteger.romanToInt("III"), 3);
		assertEquals(RomanToInteger.romanToInt("IV"), 4);
		assertEquals(RomanToInteger.romanToInt("IX"), 9);
		assertEquals(RomanToInteger.romanToInt("LVIII"), 58);
		assertEquals(RomanToInteger.romanToInt("MCMXCIV"), 1994);
	}
	
	@Test
	public void IntegerToRoman() {
		assertEquals(IntegerToRoman.intToRoman(3), "III");
		assertEquals(IntegerToRoman.intToRoman(4), "IV");
		assertEquals(IntegerToRoman.intToRoman(9), "IX");
		assertEquals(IntegerToRoman.intToRoman(58), "LVIII");
		assertEquals(IntegerToRoman.intToRoman(1994), "MCMXCIV");
	}
	
	@Test
	public void generateParentheses() {
		List<String> res = GenerateParentheses.generateParenthesis2(3);
		for(String str : res) {
			System.out.println(str);
		}
	}
	
	@Test
	public void letterCombinationsTest() {
		
	}
	
	@Test
	public void longestCommonPrefix() {
		String[] strs = {"flower","flow","flight"};
		assertEquals(LongestCommonPrefix.longestCommonPrefix1(strs), "fl");
		String[] strsNone = {"cat","dog","car"};
		assertEquals(LongestCommonPrefix.longestCommonPrefix1(strsNone), "");
	}
	
	@Test
	public void regExpTest() {
		assertEquals(RegExp.isMatchRecursion("aa", "a"), false);
		assertEquals(RegExp.isMatchRecursion("aa", "a*"), true);
		assertEquals(RegExp.isMatchRecursion("ab", ".*"), true);
		assertEquals(RegExp.isMatchRecursion("mississippi", "mis*is*p*."), false);
		assertEquals(RegExp.isMatchRecursion("aaaaaaaaab", "ab*a*c*aa*b*aaa"), false);
	}
	
	@Test
	public void reverseNumberTest() {
		System.out.println(ReverseInteger.reverseNumber(-1563847412));
	}
	
	@Test
	public void firstUniqChar() {
		String s = "leetcode";
		int ans = 0;
        Map<Character, Integer> maps = new TreeMap<>();
        Set<Character> sets = new HashSet<>();
		for(int i = 0; i < s.length(); i ++) {
			if(!maps.containsKey(s.charAt(i)) && !sets.contains(s.charAt(i))) {
				maps.put(s.charAt(i), i);
			} else if(sets.contains(s.charAt(i))) {
				continue;
			} else if(maps.containsKey(s.charAt(i))) {
				sets.add(s.charAt(i));
				maps.remove(s.charAt(i));
			}
		}
		
		ans = Integer.parseInt(maps.values().toArray()[0].toString());
		for(Integer i : maps.values()) {
			if(ans > i) {
				ans = i;
			}
		}
		
		System.out.println(ans);
    }
	
	@Test
	public void anagramWords() {// 易序词，包含相同字母的单词互称易序词
		String s = "listen";
		String t = "silent";
		
		if(s.length() != t.length()) {
			//false;
		}
		
		char[] s_chars = s.toCharArray();
		char[] t_chars = t.toCharArray();
		
		Arrays.sort(s_chars);
		Arrays.sort(t_chars);
		
		for (int i = 0; i < s_chars.length; i++) {
			if(s_chars[i] != t_chars[i]) {
				//false;
			}			
		}
		//true;
	}
	
	@Test
	public void PalindromeTest() {
		String s = "deeee";
		System.out.println(new Palindrome().validPalindromeDel(s));
//		assertEquals(Boolean.TRUE, new Palindrome().validPalindromeDel(s));

		/*String s = "A man, a plan, a canal: Panama";
        if(s.length() == 0) {
        	System.out.println(Boolean.TRUE);
            return;
        }
        s = s.toLowerCase().replaceAll("[^a-z]", "");
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
            	System.out.println(Boolean.FALSE);
                return;
            } else {
                i ++;
                j --;
            }
        }
        System.out.println(Boolean.TRUE);*/
    }
	
	@Test
	public void aToI() {
		String str = "4193 with words";
		String str2 = "42";
		String str3 = "   -42";
		String str4 = "words and 987";
		String str5 = "-91283472332";
		System.out.println(AtoI.myAtoi(str));
		System.out.println(AtoI.myAtoi(str2));
		System.out.println(AtoI.myAtoi(str3));
		System.out.println(AtoI.myAtoi(str4));
		System.out.println(AtoI.myAtoi(str5));
	}
	
	@Test
	public void countAndSayTest() {
		System.out.println(CountAndSay.countAndSay(5));
	}
}
