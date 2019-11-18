package com.ecnu.leetcode.test;

import java.util.Arrays;
import com.ecnu.leetcode.ExercisePlan;
import com.ecnu.leetcode.PalindromicCheck;
import com.ecnu.leetcode.PrimeSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Game {
	@Test
	public void primeSortTest() {
		assertEquals(682289015, new PrimeSort().numPrimeArrangements(100), "solution.");
		assertEquals(1, new PrimeSort().numPrimeArrangements(1), "solution.");
		assertEquals(1, new PrimeSort().numPrimeArrangements(2), "solution.");
		assertEquals(2, new PrimeSort().numPrimeArrangements(3), "solution.");
		assertEquals(12, new PrimeSort().numPrimeArrangements(5), "solution.");
	}
	
	@Test
	public void exercisePlanTest() {
		int[] calories_1 = {1,2,3,4,5};
		int[] calories_2 = {3,2};
		int[] calories_3 = {6,5,0,0};
		assertEquals(0, new ExercisePlan().dietPlanPerformance(calories_1, 1, 3, 3), "solution.");
		assertEquals(1, new ExercisePlan().dietPlanPerformance(calories_2, 2, 0, 1), "solution.");
		assertEquals(0, new ExercisePlan().dietPlanPerformance(calories_3, 2, 1, 5), "solution.");
	}
	
	@Test
	public void palindromicCheckTest() {
		int[][] queries = {
				{3,3,0},
				{1,2,0},
				{0,3,1},
				{0,3,2},
				{0,4,1}
		};
		String s = "abcda";
		assertEquals(Arrays.toString(new Boolean[]{true,false,false,true,true}),
				Arrays.toString(new PalindromicCheck().canMakePaliQueries(s, queries).toArray()), "solution.");

		int[][] queries2 = {{1,1,1},{2,3,0},{3,3,1},{0,3,2},{1,3,3},{2,3,1}
							,{3,3,1},{0,3,0},{1,1,1},{2,3,0},{3,3,1},{0,3,1},{1,1,1}};
		String t = "hunu";
		assertEquals(Arrays.toString(new Boolean[]{true,false,true,true,true,true,true,false,true,false,true,true,true}),
				Arrays.toString(new PalindromicCheck().canMakePaliQueries2(t, queries2).toArray()), "solution.");
	}

}
