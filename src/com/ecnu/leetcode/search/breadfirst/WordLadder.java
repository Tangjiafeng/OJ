package com.ecnu.leetcode.search.breadfirst;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	// ���еĵ��ʵĳ�����һ���ģ��Ҷ���Сд��ĸ��ƽ�Ҳ��ظ�
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
			// ���û��ת�������У����� 0��
			if(level > wordList.size()) {
				return 0;
			}
			int size = levelWords.size();
			// �ж�����Ϊ��һ����ĵ��ʲ����뵱ǰ����Ķ����У�����һ����ĵ����Ƴ�
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
	
	// �ж����������Ƿ������ת��
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
