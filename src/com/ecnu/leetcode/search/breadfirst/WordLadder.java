package com.ecnu.leetcode.search.breadfirst;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	// 所有的单词的长度是一样的，且都是小写字母，平且不重复
	// beginWord != null && endWord != null
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(wordList == null || wordList.size() == 0) {
			return 0;
		}
		if(! wordList.contains(endWord)) {
			return 0;
		}
		int level = 0;
		Queue<String> levelWords = new LinkedList<>();
		boolean[] inPath = new boolean[wordList.size()];
		levelWords.add(beginWord);
		while(!levelWords.contains(endWord)) {
			level ++;
			// 如果没有转换的序列，返回 0。
			if(level > wordList.size()) {
				return 0;
			}
			int size = levelWords.size();
			// 判断能作为下一级别的单词并加入当前级别的队列中，将上一级别的单词移除
			while(size-- > 0) {
				String preWord = levelWords.poll();
				for(String postWord : wordList) {
					if(inPath[wordList.indexOf(postWord)]) {
						continue;
					} else if(this.transform(preWord, postWord)){
						levelWords.add(postWord);
						inPath[wordList.indexOf(postWord)] = true;
					}
				}
			}
		}
		
		return level + 1;
    }
	
	// 判断两个单词是否可以做转换
	public boolean transform(String left, String right) {
		int diffIndeics = 0;
		for(int i = 0; i < left.length(); i ++) {
			if(left.charAt(i) != right.charAt(i)) {
				diffIndeics ++;
				if(diffIndeics > 1) {
					return false;
				}
			}
		}
		return true;
	}
}
