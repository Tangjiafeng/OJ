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
			// 如果长度是奇数先去掉一个只出现一次的字母，让其长度变为偶数，再做处理
			// 统计只出现一次的字母的个数，如果个数的一半（一定可以分成一半）小于可以交换的次数，则检测成功；反之不成功。
		}
        return ans;
    }
	
}
