package com.ecnu.leetcode.designproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {
/*
    List<Integer> minList = new ArrayList<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    public MinStack() {
        // Algor of mine: 典型的空间换时间。
        // 执行用时: 7 ms, 在所有 Java 提交中击败了87.41%的用户
        // 内存消耗: 41.3 MB, 在所有 Java 提交中击败了15.66%的用户
        // 在Java Stack的基础上，增加一个同步最小值数组，数组index下标处保存index+1长度栈的最小值。
    }

    public void push(int x) {
        if (minList.isEmpty() && stack.isEmpty()) {
            minList.add(x);
            stack.push(x);
            return;
        }
        int temp = minList.get(minList.size() - 1);
        if (x < temp) {
            minList.add(x);
        } else {
            minList.add(temp);
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        minList.remove(minList.size() - 1);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minList.get(minList.size() - 1);
    }
*/

    List<Integer> minList = new ArrayList<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    public MinStack() {
        // Algor 1: 绝对的同步会让最小值数组中加入重复的元素，即入栈都为更大的数时，最小值不变，但是也会加入最小值数组
        // 中，浪费了内存空间。但是多出来的if判断可能影响性能。
        // 执行用时 : 10 ms, 在所有 Java 提交中击败了 34.43% 的用户
        // 内存消耗 : 41.5 MB, 在所有 Java 提交中击败了 14.46% 的用户
        // 采用不同步的方式：
        // 1）辅助栈为空的时候，必须放入新进来的数；
        //
        //（2）新来的数小于或者等于辅助栈栈顶元素的时候，才放入，特别注意这里“等于”要考虑进去，因为出栈的时候，
        // 连续的、相等的并且是最小值的元素要同步出栈；
        //
        //（3）出栈的时候，辅助栈的栈顶元素等于数据栈的栈顶元素，才出栈。
    }

    public void push(int x) {
        if (minList.isEmpty() && stack.isEmpty()) {
            minList.add(x);
            stack.push(x);
            return;
        }
        int temp = minList.get(minList.size() - 1);
        if (x <= temp) {
            minList.add(x);
        }
        stack.push(x);
    }

    public void pop() {
        int temp = stack.pop();
        if (minList.get(minList.size() - 1) == temp) {
            minList.remove(minList.size() - 1);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minList.get(minList.size() - 1);
    }
}
