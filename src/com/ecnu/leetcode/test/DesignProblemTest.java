package com.ecnu.leetcode.test;

import com.ecnu.leetcode.designproblem.MinStack;
import com.ecnu.leetcode.designproblem.ShuffleAnArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DesignProblemTest {
    @Test
    public void MinStackTest() {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        for (int i = 0; i < 3; i ++) {
            minStack.pop();
            System.out.println(minStack.getMin());
        }
    }
    @Test
    public void shuffleAnArrayTest() {
        int[] nums = {2,4,6,8,10};
        ShuffleAnArray obj = new ShuffleAnArray(nums);
        int[] param_1 = obj.reset();
        System.out.println(Arrays.toString(param_1));
        int[] param_2 = obj.shuffle();
        System.out.println(Arrays.toString(param_2));
        int[] param_3 = obj.shuffle();
        System.out.println(Arrays.toString(param_3));
        int[] param_4 = obj.shuffle();
        System.out.println(Arrays.toString(param_4));
        int[] param_5 = obj.shuffle();
        System.out.println(Arrays.toString(param_5));
    }
}
