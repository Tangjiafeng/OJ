package com.ecnu.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/39/
 * @author A
 *
 */
public class CountAndSay {
	/*
	 * stack solution.
	 */
	public static String countAndSay(int n) {
        List<String> ans = new ArrayList<>();
		ans.add("1");
        for (int i = 1; i < n; i++) {
        	StringBuffer str = new StringBuffer();
        	String post = ans.get(i - 1);
        	Stack<Character> chs = new Stack<>();
        	for(Character c : post.toCharArray()) {
        		if(chs.isEmpty()) {
        			chs.push(c);
        			continue;
        		}
        		if(chs.peek() == c) {
        			chs.push(c);
        		} else {
        			str.append(chs.size() + "" + chs.peek());
        			chs.clear();
        			chs.push(c);
        		}        		
        	}
        	str.append(chs.size() + "" + chs.peek());
        	chs.clear();
        	ans.add(str.toString());
		}
		return ans.get(n - 1);
    }
    // Cpp��һ�ָ����Ĵ��룬�����ַ��������ڳ����еı仯Ӱ����Java��Ч�ʡ�
	public static String countAndSay2(int n) {
		String str,res;
		res="1";
		for(int i=1;i<n;i++){
			str=res;
			res="";
			for(int j=0;j<str.length();){
				int c=0,k=j;
				while(k<str.length()&&str.charAt(k)==str.charAt(j)){
					k++;
					c++;
				}
				res+=c+str.charAt(j);
				j=k;
			}
		}
		return res;
	}
}
