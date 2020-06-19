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
        // Algor of mine: ���͵Ŀռ任ʱ�䡣
        // ִ����ʱ: 7 ms, ������ Java �ύ�л�����87.41%���û�
        // �ڴ�����: 41.3 MB, ������ Java �ύ�л�����15.66%���û�
        // ��Java Stack�Ļ����ϣ�����һ��ͬ����Сֵ���飬����index�±괦����index+1����ջ����Сֵ��
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
        // Algor 1: ���Ե�ͬ��������Сֵ�����м����ظ���Ԫ�أ�����ջ��Ϊ�������ʱ����Сֵ���䣬����Ҳ�������Сֵ����
        // �У��˷����ڴ�ռ䡣���Ƕ������if�жϿ���Ӱ�����ܡ�
        // ִ����ʱ : 10 ms, ������ Java �ύ�л����� 34.43% ���û�
        // �ڴ����� : 41.5 MB, ������ Java �ύ�л����� 14.46% ���û�
        // ���ò�ͬ���ķ�ʽ��
        // 1������ջΪ�յ�ʱ�򣬱�������½���������
        //
        //��2����������С�ڻ��ߵ��ڸ���ջջ��Ԫ�ص�ʱ�򣬲ŷ��룬�ر�ע��������ڡ�Ҫ���ǽ�ȥ����Ϊ��ջ��ʱ��
        // �����ġ���ȵĲ�������Сֵ��Ԫ��Ҫͬ����ջ��
        //
        //��3����ջ��ʱ�򣬸���ջ��ջ��Ԫ�ص�������ջ��ջ��Ԫ�أ��ų�ջ��
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
