package com.ecnu.leetcode.designproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray {
    List<Integer> lists = new ArrayList<>();
    List<Integer> origin = new ArrayList<>();
    private Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            lists.add(nums[i]);
            origin.add(nums[i]);
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] res = new int[origin.size()];
        for (int i = 0; i < origin.size(); i++) {
            res[i] = origin.get(i);
        }
        return res;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[lists.size()];
        for (int i = 0; i < res.length; i ++) {
            int index = random.nextInt(lists.size());
            res[i] = lists.remove(index);
        }
        for (int i = 0; i < origin.size(); i++) {
            lists.add(origin.get(i));
        }
        return res;
    }
}
