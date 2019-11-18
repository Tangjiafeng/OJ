package com.ecnu.leetcode.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;


import com.ecnu.leetcode.dynamicprogram.PerfectSquaresDP;
import com.ecnu.leetcode.search.breadfirst.PerfectSquaresBFS;
import com.ecnu.leetcode.search.breadfirst.WordLadder;
import org.junit.jupiter.api.Test;


public class FSTest {

	@Test
	public void perfectSquares() {
		assertEquals(3, new PerfectSquaresBFS().numSquares(12), "BFS solution.");
		assertEquals(2, new PerfectSquaresDP().numSquares(13), "DP solution.");
		assertEquals(2, new PerfectSquaresDP().numSquares(32), "DP solution.");
	}
	
	@Test
	public void WordLadderTest() {
		assertEquals(5, new WordLadder().ladderLength("hit","cog",Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})), "BFS solution.");
	}
}
