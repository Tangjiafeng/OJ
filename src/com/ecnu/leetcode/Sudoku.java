package com.ecnu.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Sudoku {
	private static final int NINE = 9;
	private static final char[] chs = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private char[][] sudoku;
	
	private void print() {
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[i].length; j++) {
				System.out.print(sudoku[i][j]);
				System.out.print(' ');
			}
			System.out.println("");
		}
	}
	
	private boolean isSudoku() {
		Set<Character> chs = new HashSet<>();
		// check rows
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(this.sudoku[i][j] == '.') continue; 
				if(chs.contains(this.sudoku[i][j])) {
					return false;
				} else {
					chs.add(this.sudoku[i][j]);
				}
			}
			
			chs.clear();
		}
		
		// check columns
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(this.sudoku[j][i] == '.') continue;
				if(chs.contains(this.sudoku[j][i])) {
					return false;
				} else {
					chs.add(this.sudoku[j][i]);
				}
			}

			chs.clear();
		}
		// check blocks
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				for (int i1 = i; i1 < i + 3; i1++) {
					for (int j1 = j; j1 < j + 3; j1++) {
						if(this.sudoku[i1][j1] == '.') continue;
						if(chs.contains(this.sudoku[i1][j1])) {
							return false;
						} else {
							chs.add(this.sudoku[i1][j1]);
						}
					}
					
				}
				
				chs.clear();
			}
			
		}
		
		return true;
	}
	
	private void solve0_1(char[][] sudoku) {
		//1, count the dots number
		List<Dot> listDot = new ArrayList<Dot>();
		for (int i = 0; i < NINE; i++) {
			for (int j = 0; j < NINE; j++) {
				if('.' == sudoku[i][j]) {
					Dot dot = new Dot(i, j);
					listDot.add(dot);
				}
			}
		}
		if(listDot.size() == 0) return;
		//2, calculate the possible numbers in every dots
		for (int index = 0; index < listDot.size(); index++) {
			Set<Character> listChar = new HashSet<Character>();
			// Characters already in the row
			for (int x = 0; x < NINE; x ++) {
				if('.' != sudoku[listDot.get(index).i][x]) {
					listChar.add(sudoku[listDot.get(index).i][x]);
				}
			}
			// Characters already in the column
			for (int y = 0; y < NINE; y ++) {
				if('.' != sudoku[y][listDot.get(index).j]) {
					listChar.add(sudoku[y][listDot.get(index).j]);
				}
			}
			// Characters already in the block
			int x = listDot.get(index).i / 3;
			int y = listDot.get(index).j / 3;
			for (int i = x * 3; i < x * 3 + 3; i++) {
				for (int j = y * 3; j < y * 3 + 3; j++) {
					if('.' != sudoku[i][j]) {
						listChar.add(sudoku[i][j]);
					}
				}
			}
			// save to the dot
			for (int n = 0; n < chs.length; n++) {
				if(!listChar.contains(chs[n])) {
					listDot.get(index).list.add(chs[n]);
				}
			}
		}
		//3, unique number should be set first
		listDot.sort(new Comparator<Dot>() {
			@Override
			public int compare(Dot o1, Dot o2) {
				return o1.list.size() - o2.list.size();// incremental order
			}
		});
		for (Iterator<Dot> iterator = listDot.iterator(); iterator.hasNext();) {
			Dot dot = (Dot) iterator.next();
			if(dot.list.size() == 1) {
				char current = dot.list.get(0);
				sudoku[dot.i][dot.j] = current;
			} else {
				break;
			}
		}
		System.out.println("###################################################################################");
		this.print();
		solve0_1(sudoku);
	}
	
	// 
	private void solve0_2(char[][] sudoku) {
		List<Dot> listDot = new ArrayList<Dot>();
		for (int i = 0; i < NINE; i++) {
			for (int j = 0; j < NINE; j++) {
				if('.' == sudoku[i][j]) {
					Dot dot = new Dot(i, j);
					listDot.add(dot);
				}
			}
		}
		for (int index = 0; index < listDot.size(); index++) {
			Set<Character> listChar = new HashSet<Character>();
			// Characters already in the row
			for (int x = 0; x < NINE; x ++) {
				if('.' != sudoku[listDot.get(index).i][x]) {
					listChar.add(sudoku[listDot.get(index).i][x]);
				}
			}
			// Characters already in the column
			for (int y = 0; y < NINE; y ++) {
				if('.' != sudoku[y][listDot.get(index).j]) {
					listChar.add(sudoku[y][listDot.get(index).j]);
				}
			}
			// Characters already in the block
			int x = listDot.get(index).i / 3;
			int y = listDot.get(index).j / 3;
			for (int i = x * 3; i < x * 3 + 3; i++) {
				for (int j = y * 3; j < y * 3 + 3; j++) {
					if('.' != sudoku[i][j]) {
						listChar.add(sudoku[i][j]);
					}
				}
			}
			for (int n = 0; n < chs.length; n++) {
				if(!listChar.contains(chs[n])) {
					listDot.get(index).list.add(chs[n]);
				}
			}
		}
		
		listDot.sort(new Comparator<Dot>() {
			@Override
			public int compare(Dot o1, Dot o2) {
				return o1.list.size() - o2.list.size();// incremental order
			}
			
		});
		while(true) {
			if(listDot.size() == 0) return;
			Dot dot = listDot.get(0);
			if(dot.list.size() == 1) {
				char current = dot.list.get(0);
				sudoku[dot.i][dot.j] = current;
				for (int n = 1; n < listDot.size(); n++) {
					int x = dot.i / 3;
					int y = dot.j / 3;
					if((listDot.get(n).i == dot.i || listDot.get(n).j == dot.j) || 
					   (listDot.get(n).i >= x * 3 && listDot.get(n).i < x * 3 + 3 && listDot.get(n).j >= y * 3 && listDot.get(n).j < y * 3 + 3)) {
						if(listDot.get(n).list.contains(current)) {
							listDot.get(n).list.remove(listDot.get(n).list.indexOf(current));
						}
					}
				}
				listDot.remove(0);
				listDot.sort(new Comparator<Dot>() {
					@Override
					public int compare(Dot o1, Dot o2) {
						return o1.list.size() - o2.list.size();// incremental order
					}
					
				});
			} else {
				break;
			}
		}
	}
	
	public Sudoku(char[][] sudoku) {
		this.sudoku = sudoku;
	}

	public static void main(String[] args) {
		char[][] temp = {{'5','3','.','.','7','.','.','.','.'},
		         {'6','.','.','1','9','5','.','.','.'},
		         {'.','9','8','.','.','.','.','6','.'},
		         {'8','.','.','.','6','.','.','.','3'},
		         {'4','.','.','8','.','3','.','.','1'},
		         {'7','.','.','.','2','.','.','.','6'},
		         {'.','6','.','.','.','.','2','8','.'},
		         {'.','.','.','4','1','9','.','.','5'},
		         {'.','.','.','.','8','.','.','7','9'}};
		Sudoku sudoku = new Sudoku(temp);
		System.out.println(sudoku.isSudoku());
		char[][] temp1 = {{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};

		char[][] temp2 = {{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}};
		Sudoku sudokuObj1 = new Sudoku(temp1);
		sudokuObj1.print();
		long start = System.currentTimeMillis();
		sudokuObj1.solve0_1(sudokuObj1.sudoku);
		long end = System.currentTimeMillis();
		System.out.println("###################################################################################");
		System.out.println("Time: " + (end - start));

		Sudoku sudokuObj2 = new Sudoku(temp2);
		sudokuObj2.print();
		start = System.currentTimeMillis();
		sudokuObj2.solve0_2(sudokuObj2.sudoku);
		end = System.currentTimeMillis();
		System.out.println("###################################################################################");
		System.out.println("Time: " + (end - start));
	}
	
	class Dot {
		int i;
		int j;
		public Dot(int i, int j) {
			this.i = i;
			this.j = j;
		}
		List<Character> list = new ArrayList<Character>();
	}
}
