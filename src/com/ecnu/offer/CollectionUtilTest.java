package com.ecnu.offer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class CollectionUtilTest {
	public static void testPriorityQueue() {
		int nums[] = {5, 6, 8, 1 ,7, 8, 2, 9};
		// 默认小根堆
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		// Creates a PriorityQueue whose elements are ordered according 
		// to the specified comparator.
		// 大根堆
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		for(int num : nums) {
			minHeap.add(num);
			maxHeap.add(num);
		}
		System.out.println(minHeap.toString());
		System.out.println(maxHeap.toString());
		System.out.println(minHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(minHeap.toString());
		System.out.println(maxHeap.toString());
	}
	/*
	 * LinkedList：reverse function
	 */
	public static void testLinkedList() {
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < 5; i ++) {
			list.add(new Random().nextInt(10));
		}
		System.out.println(list.toString());
		Collections.reverse(list);
		System.out.println(list.toString());
	}
	/*
	 * Queue：to find the first sole character
	 */
	public static void testQueue() {
		int[] cnts = new int[256];
		char[] chs = {'g','o','o','g','l','e'};
		Queue<Character> queue = new LinkedList<>();// LinkedList implements Queue
		for(char ch : chs) {
			cnts[ch]++;
		    queue.add(ch);
		    while (!queue.isEmpty() && cnts[queue.peek()] > 1) {	    	
		    	queue.poll();
		    }
		}
		char ch = queue.isEmpty() ? '#' : queue.peek();
		System.out.println(ch);
	}
	public static void main(String[] args) {
		CollectionUtilTest.testPriorityQueue();
//		CollectionUtilTest.testQueue();
//		CollectionUtilTest.testLinkedList();
	}

	
}
