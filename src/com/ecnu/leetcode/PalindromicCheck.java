package com.ecnu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicCheck {
	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> ans = new ArrayList<>();
		
		for(int[] query : queries) {
			String str = s.substring(query[0], query[1] + 1);
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			// ���������������ȥ��һ��ֻ����һ�ε���ĸ�����䳤�ȱ�Ϊż������������
			// ͳ��ֻ����һ�ε���ĸ�ĸ��������������һ�루һ�����Էֳ�һ�룩С�ڿ��Խ����Ĵ���������ɹ�����֮���ɹ���
		}
        return ans;
    }
	
}
